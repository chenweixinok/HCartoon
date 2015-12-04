package android.hcartoon.activity;

import android.app.Activity;
import android.content.Intent;
import android.hcartoon.adapter.SortActAdapter;
import android.hcartoon.bean.SortActBean;
import android.hcartoon.constant.Constant;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Lenovo on 2015/12/4.
 */
public class SortActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener, Response.Listener<JSONObject> {

    private SortActAdapter sortActAdapter;
    private ListView listView;
    private ArrayList<SortActBean> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("title");

        TextView title = (TextView) findViewById(R.id.sort_ac_title);
        title.setText(name);
        findViewById(R.id.sort_back).setOnClickListener(this);

        listView = (ListView) findViewById(R.id.sort_listview);
        sortActAdapter = new SortActAdapter(this);
        listView.setOnItemClickListener(this);

        String url = Constant.SORT_LIST_ITEMS + id;
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,url,
                null,this, null);
        queue.add(request);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sort_back){
            finish();
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (list != null){
            SortActBean sortActBean = list.get(position);
            String cid = sortActBean.getCid();
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("cid",cid);
            startActivity(intent);
        }

    }

    @Override
    public void onResponse(JSONObject jsonObject) {

        list = new ArrayList<SortActBean>();
        try {
            JSONObject object = jsonObject.getJSONObject("data");
            Iterator iterator = object.keys();
            while (iterator.hasNext()){
                String key = String.valueOf(iterator.next());
                JSONObject object1 = object.getJSONObject(key);

                String img = Constant.HOST_NAME
                        + object1.getString("frontcover");
                String cid = object1.getString("c_id");
                String title = object1.getString("c_name");
                String author = object1.getString("author_name");
                String intro = object1.getString("rl_long");
                list.add(new SortActBean(img, title, author, intro, cid));
            }
            sortActAdapter.setData(list);
            listView.setAdapter(sortActAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
