package android.hcartoon.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.hcartoon.activity.LoginActivity;
import android.hcartoon.activity.R;
import android.hcartoon.activity.TopicItemActivity;
import android.hcartoon.adapter.TopicAdapter;
import android.hcartoon.bean.Topic;
import android.hcartoon.constant.Constant;
import android.hcartoon.parser.TopicListJson;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.lidroid.xutils.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * 专区碎片
 * Created by Lenovo on 2015/11/20.
 */
public class TopicFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listview;
    private TopicAdapter adapter;
    // 当前展示数据的页码
    private int curPage = 1;
    private List<Topic> list = new ArrayList<Topic>();
    private View view;



    /**
     * 下载并解析json
     */
    private void initVolley(final int curPage) {
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        JsonObjectRequest postJson = new JsonObjectRequest(Request.Method.POST,
                Constant.TOPIC_LIST+curPage,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        HashMap<String, String> data = new HashMap<String, String>();
                        try {
                            JSONObject jsonObject2 = response.getJSONObject("data");
                            Iterator it = jsonObject2.keys();
                            JSONObject js = null;
                            while (it.hasNext()) {
                                String key = String.valueOf(it.next());
                                js = (JSONObject) jsonObject2.get(key);
                                data.put(key, js.toString());
                            }
                            List<Topic> mlist = TopicListJson.topicListJson(data);
                            adapter.addData(mlist);

                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }, null);
        queue.add(postJson);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view==null){
            view = inflater.inflate(R.layout.frag_topic, container, false);

            listview = (ListView) view.findViewById(R.id.topic_listview);
            adapter = new TopicAdapter(getActivity());
            initVolley(curPage);
            listview.setAdapter(adapter);
            listview.setOnItemClickListener(this);
        }
        return view;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub
        //获取数据并且传过去
        Intent intent=new Intent(getActivity(), TopicItemActivity.class);
        Topic items = (Topic) adapter.getItem(position);
        String topics_id = items.getSt_id();
        intent.putExtra("st_id", topics_id);
        startActivity(intent);

    }


}
