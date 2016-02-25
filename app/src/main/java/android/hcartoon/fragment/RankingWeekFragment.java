package android.hcartoon.fragment;

import android.content.Intent;
import android.hcartoon.activity.DetailActivity;
import android.hcartoon.activity.R;
import android.hcartoon.adapter.RankingWeekAdapter;
import android.hcartoon.bean.RankingWeekBean;
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

/**
 * Created by Lenovo on 2016/2/24.
 */
public class RankingWeekFragment extends Fragment implements AdapterView.OnItemClickListener {


    private ListView weekListView;
    private RankingWeekAdapter rwAdapter;
    private List<RankingWeekBean> wlist;
    private RequestQueue requestQueue;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_ranking_week, container, false);
        weekListView = (ListView) view.findViewById(R.id.ranking_week_listview);

        rwAdapter = new RankingWeekAdapter();

        requestQueue = Volley.newRequestQueue(getActivity());
        wlist = new ArrayList<RankingWeekBean>();
        String path = Constant.WEEK_RANK;
        setListData(path);// 获取数据填充集合

        weekListView.setOnItemClickListener(this);
        return view;
    }


    /**
     * 使用Volley 获取数据并解析填充到wlist里
     *
     * @param path
     */
    private void setListData(String path) {

        JsonObjectRequest jsRequest = new JsonObjectRequest(Request.Method.GET,
                path, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONObject object = jsonObject
                            .getJSONObject("data");
                    Iterator iterator = object.keys();
                    int flag = 0;// 标志是否是第一个
                    while (iterator.hasNext()) {
                        String key = String.valueOf(iterator.next());
                        JSONObject obj = object.getJSONObject(key);
                        if (flag == 0) {

                            String img = Constant.HOST_NAME
                                    + obj.getString("frontcover_small");
                            String cid = obj.getString("c_id");
                            String cName = obj.getString("c_name");
                            String author = obj.getString("author_name");
                            String memo = obj.getString("c_memo");

                            RankingWeekBean rwBean = new RankingWeekBean();
                            rwBean.setC_id(cid);
                            rwBean.setC_name(cName);
                            rwBean.setAuthor_name(author);
                            rwBean.setFrontcover_small(img);
                            rwBean.setC_memo(memo);
                            wlist.add(rwBean);
                            flag = 1;
                        } else {
                            String cid = obj.getString("c_id");
                            String cName = obj.getString("c_name");
                            String chapter = obj
                                    .getString("new_chapter");
                            RankingWeekBean bean = new RankingWeekBean();
                            bean.setC_id(cid);
                            bean.setC_name(cName);
                            bean.setNew_chapter(chapter);
                            wlist.add(bean);
                        }

                    }
                    rwAdapter.setWeekData(wlist);// 给适配器设置数据

                    weekListView.setAdapter(rwAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, null);
        requestQueue.add(jsRequest);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String cid = wlist.get(position).getC_id();
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("cid", cid);
        startActivity(intent);

    }
}
