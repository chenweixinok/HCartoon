package android.hcartoon.fragment;

import android.content.Intent;
import android.hcartoon.activity.DetailActivity;
import android.hcartoon.activity.R;
import android.hcartoon.adapter.RankingPopAdapter;
import android.hcartoon.bean.RankingBean;
import android.hcartoon.constant.Constant;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Lenovo on 2016/2/24.
 */
public class RankingPopFragment extends Fragment implements AdapterView.OnItemClickListener {



    private ListView popListview;// 人气排行listview
    private RankingPopAdapter popAdapter;// 人气排行适配器
    private List<RankingBean> popList;// 人气排行数据集合
    private RequestQueue requestQueue;// 请求队列



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_ranking_pop, container, false);
        popListview = (ListView) view.findViewById(R.id.ranking_pop_listview);
        requestQueue = Volley.newRequestQueue(getActivity());
        popAdapter = new RankingPopAdapter(getActivity());
        popList = new ArrayList<RankingBean>();

        String path = Constant.POPULARITY_RANK + "&" + Constant.DEVICE_MODEL;
        setPopData(path);

        popListview.setOnItemClickListener(this);
        return view;
    }

    private void setPopData(String path) {

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, path,
                null, new Response.Listener<JSONObject>() {

            TreeSet<RankingBean> treeSet = new TreeSet<RankingBean>();

            @Override
            public void onResponse(JSONObject jsonObject) {

                try {
                    JSONObject object = jsonObject.getJSONObject("data");
                    Iterator iterator = object.keys();
                    while (iterator.hasNext()) {
                        String key = String.valueOf(iterator.next());
                        JSONObject obj = object.getJSONObject(key);

                        String cid = obj.getString("c_id");
                        String cName = obj.getString("c_name");
                        String statusName = obj.getString("c_status_name");
                        String authorName = obj.getString("author_name");
                        String tName = obj.getString("t_name");
                        String collection = obj.getString("collection");
                        String pop = obj.getString("popularity");
                        String imageUrl = Constant.HOST_NAME
                                + obj.getString("frontcover_small");
                        RankingBean rb = new RankingBean();
                        rb.setC_id(cid);
                        rb.setC_name(cName);
                        rb.setC_status_name(statusName);
                        rb.setAuthor_name(authorName);
                        rb.setT_name(tName);
                        rb.setCollevtion(collection);
                        rb.setPopularity(pop);
                        rb.setImage_small(imageUrl);
                        treeSet.add(rb);
                        // popList.add(rb);
                    }
                    RankingBean rkb = new RankingBean();
                    Iterator it = treeSet.iterator();
                    while (it.hasNext()) {
                        rkb = (RankingBean) it.next();
                        popList.add(rkb);
                    }
                    popAdapter.setPopData(popList);
                    popListview.setAdapter(popAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },null);
        requestQueue.add(jsonRequest);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String cid = popList.get(position).getC_id();
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("cid", cid);
        startActivity(intent);
        
    }
}
