package android.hcartoon.fragment;

import android.content.Intent;
import android.hcartoon.activity.DetailActivity;
import android.hcartoon.activity.R;
import android.hcartoon.adapter.AdPagerAdapter;
import android.hcartoon.adapter.RecomAdapter;
import android.hcartoon.bean.Advertisement;
import android.hcartoon.bean.Recommend;
import android.hcartoon.constant.Constant;
import android.hcartoon.view.RecomGridView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.yfbx.autoscrollpager.AutoScrollViewPager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Lenovo on 2015/11/17.
 */
public class RecommendFragment extends Fragment implements RadioGroup.OnCheckedChangeListener,
        AdapterView.OnItemClickListener, Response.Listener<JSONObject> {

    private AutoScrollViewPager autoScrollViewPager;
    private AdPagerAdapter adPagerAdapter;      //Viewpager的适配器

    private RequestQueue queue;
    private RecomGridView recomGridView;
    private RecomAdapter recomAdapter;   //GridView的适配器
    private ArrayList<Recommend> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_recommend,null);

        queue = Volley.newRequestQueue(getActivity());

        /**
         * 设置RadioGroup按钮的点击事件
         */
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.recom_tab);
        radioGroup.setOnCheckedChangeListener(this);

        /**
         * ViewPager  自动循环的mainactivity布局的头部部分
         */
        autoScrollViewPager = (AutoScrollViewPager) view.findViewById(R.id.ad_pager);
        autoScrollViewPager.setCycle(true);
        autoScrollViewPager.startAutoScroll();
        autoScrollViewPager.setFocusable(true);
        autoScrollViewPager.setFocusableInTouchMode(true);
        autoScrollViewPager.requestFocus();

        adPagerAdapter = new AdPagerAdapter(getActivity());
        showAds();


        /**
         * MainActivity的GridView部分 也就是主体
         */
        recomGridView = (RecomGridView) view.findViewById(R.id.reco_gridview);
        recomAdapter = new RecomAdapter(getActivity());
        showRecom(1);

        recomGridView.setOnItemClickListener(this);

        return view;
    }

    public void showRecom(int type) {
        String path = String.format(Constant.RECOMMEND_LIST,type);
        /**
         * 需要实现onResponse方法
         */
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                path,null,this,null);
        queue.add(request);
    }

    private void showAds() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,
                Constant.AD_LIST, null, new Response.Listener<JSONObject>(){

                    @Override
                    public void onResponse(JSONObject response) {
                        ArrayList<Advertisement> list = new ArrayList<Advertisement>();
                        try {
                            JSONObject jsonObject = response.getJSONObject("data");
                            Iterator iterator = jsonObject.keys();
                            while (iterator.hasNext()){
                                String key = String.valueOf(iterator.next());
                                JSONObject object = jsonObject.getJSONObject(key);
                                String title = object.getString("ad_name");
                                String img = Constant.HOST_NAME + object.getString("ad_img");
                                String cid = object.getString("obj_id");
                                list.add(new Advertisement(img, title, cid));
                            }
                            adPagerAdapter.setData(list);
                            autoScrollViewPager.setAdapter(adPagerAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },null);
        queue.add(request);
    }

    /**
     * 点击改变RecomGridView的内容
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){
            case R.id.hot:
                showRecom(1);
                break;

            case R.id.original:
                showRecom(2);
                break;
            case R.id.oversea:
                showRecom(3);
                break;
            case R.id.latest:
                showRecom(4);
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (list != null){
            Recommend recommend = list.get(position);
            String cid = recommend.getCid();

            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("cid", cid);
            startActivity(intent);
        }

    }

    @Override
    public void onResponse(JSONObject response) {

        list = new ArrayList<Recommend>();
        try {
            JSONObject object = response.getJSONObject("data");
            Iterator iterator = object.keys();
            while (iterator.hasNext()){
                String key = String.valueOf(iterator.next());
                JSONObject obj = object.getJSONObject(key);
                String img = Constant.HOST_NAME + obj.getString("recomm_pic");
                String title = obj.getString("c_name");
                String chapter = obj.getString("new_chapter");
                String cid = obj.getString("c_id");
                Recommend recommend = new Recommend(img,title ,chapter ,cid);
                list.add(recommend);
            }
            recomAdapter.setData(list);
            recomGridView.setAdapter(recomAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
