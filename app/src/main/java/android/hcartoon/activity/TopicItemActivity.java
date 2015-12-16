package android.hcartoon.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.hcartoon.adapter.TopicItemAdapter;
import android.hcartoon.bean.Topic;
import android.hcartoon.bean.TopicItem;
import android.hcartoon.constant.Constant;
import android.hcartoon.parser.TopicListJson;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2015/12/4.
 */
public class TopicItemActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ImageView iv_logo;
    private TextView tv_top_name;
    private ListView listView;
    private TopicItemAdapter adapter;
    private List<TopicItem> mdata=new ArrayList<TopicItem>();
    /**
     * 设置头
     */
    private Handler handler=new Handler(){
        public void handleMessage(android.os.Message msg) {
            if(msg.what==100){
                mdata=(List<TopicItem>) msg.obj;
                final TopicItem item = mdata.get(0);
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        tv_top_name.setText(item.getSt_name());

                    }
                });
            }
        };
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_item);
        String st_id = getIntent().getStringExtra("st_id");

        tv_top_name=(TextView) findViewById(R.id.topic_item_top_name_1111);
        //数据加载框

        findViewById(R.id.topic_item_back).setOnClickListener(this);
        listView = (ListView) findViewById(R.id.topic_item_lv);
        adapter = new TopicItemAdapter(this);
        //下载
        download(st_id);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

    }

    /**
     * 下载并解析
     * @param st_id
     */
    private void download(final String st_id) {

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest postJson = new JsonObjectRequest(Request.Method.POST,
                Constant.TOPIC_LIST_ITEMS+st_id,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            List<TopicItem> mlist = TopicListJson.topicItemJson(response);
                            //下拉刷新
                            Message msg=Message.obtain();
                            msg.what=100;
                            msg.obj=mlist;
                            handler.sendMessage(msg);
                            adapter.addData(mlist);

                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("log", "请求错误:" + error.getMessage());
            }
        }) {
            /**
             * 设置请求头(指定字符集,设置代理,请求超时...)
             * @return
             * @throws AuthFailureError
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("Content-Type", "application/x-www-form-urlencoded");
                map.put("User-Agent", "Apache-HttpClient/UNAVAILABLE (java 1.4)");
                return map;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("phonemodel","vivoX710L");
                map.put("phonesystem","android4.4.2");
                map.put("phoneid","864855029870732");
                map.put("apptype","android");
                map.put("appname","mstars");
                map.put("appver","2.5.4");
                map.put("st_id", st_id);
                return map;
            }
        };
        queue.add(postJson);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Intent intent=new Intent(TopicItemActivity.this, DetailActivity.class);
        TopicItem items = (TopicItem) adapter.getItem(position);
        String cid = items.getC_id();
        intent.putExtra("cid", cid);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

        finish();
    }
}
