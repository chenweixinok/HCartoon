package android.hcartoon.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hcartoon.MyApplication;
import android.hcartoon.bean.Details;
import android.hcartoon.constant.Constant;
import android.hcartoon.parser.DetailsParser;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.lidroid.xutils.BitmapUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2015/11/20.
 */
public class DetailActivity extends Activity implements View.OnClickListener {

    private ImageView iv_logo;
    private TextView tv_name;
    private TextView tv_author;
    private TextView tv_pop;
    private TextView tv_neirong, tv_jiazai;
    private Button read_bt;

    private List<Details> mdata = new ArrayList<Details>();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 300){
                mdata = (List<Details>) msg.obj;
                final Details details = mdata.get(0);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv_name.setText(details.getC_name());
                        tv_author.setText("作者："+ details.getAuthor_name());
                        tv_pop.setText("人气："+ details.getPopularity());
                        tv_neirong.setText(details.getC_memo());
                        tv_jiazai.setText(details.getC_status_name()+"至"+details.getNew_chapter_name());
                        String small = details.getFrontcover_small();
                        if (small.equals("") || small == null){
                            //默认
                            iv_logo.setImageResource(R.drawable.special_definite_book);
                        }else {
                            BitmapUtils bitmapUtils = new BitmapUtils(DetailActivity.this);
                            bitmapUtils.configDefaultLoadingImage(R.drawable.special_definite_book);
                            bitmapUtils.display(iv_logo, Constant.HOST_NAME+small);
                        }
                    }
                });
            }
        }
    };

    private String id;
    private RadioButton rb_collect;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        id = getIntent().getStringExtra("cid");
        
        initView();

        findViewById(R.id.detail_top_ib).setOnClickListener(this);
        findViewById(R.id.bt_tucao).setOnClickListener(this);
        findViewById(R.id.bt_share).setOnClickListener(this);
        rb_collect.setOnClickListener(this);
        //开始阅读点击事件
        if (mdata != null){
            read_bt.setOnClickListener(this);
        }

        download(id);

    }

    /**
     * 下载并解析
     * @param id
     */
    private void download(final String id) {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest postJson = new JsonObjectRequest(Request.Method.POST,
                Constant.BOOK_DETAIL + id + Constant.USERNAME, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            List<Details> mList = DetailsParser.detailsJson(response);
                            // 下拉刷新
                           Message msg = Message.obtain();
                            msg.what = 300;
                            msg.obj = mList;
                            handler.sendMessage(msg);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("LOG","请求错误："+ volleyError.getMessage());
            }
        }){

            /**
             * 设置请求头(指定字符集,设置代理,请求超时...)
             *
             * @return
             * @throws AuthFailureError
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("Content-Type", "application/x-www-form-urlencoded");
                map.put("User-Agent",
                        "Apache-HttpClient/UNAVAILABLE (java 1.4)");
                return map;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("phonemodel", "vivoX710L");
                map.put("phonesystem", "android4.4.2");
                map.put("phoneid", "864855029870732");
                map.put("apptype", "android");
                map.put("appname", "mstars");
                map.put("appver", "2.5.4");
                map.put("c_id", id);
                map.put("user_name", "mstars1438764774284694");
                return map;
            }
        };

        queue.add(postJson);
    }

    private void initView() {
        iv_logo = (ImageView) findViewById(R.id.detail_logo_iv);
        tv_name = (TextView) findViewById(R.id.detail_name_tv);
        tv_author = (TextView) findViewById(R.id.detail_author_tv);
        tv_pop = (TextView) findViewById(R.id.detail_pop_tv);
        tv_neirong = (TextView) findViewById(R.id.details_neirong_tv);
        tv_jiazai = (TextView) findViewById(R.id.detail_lianzai_tv);
        read_bt = (Button) findViewById(R.id.detail_start_bt);
        rb_collect = (RadioButton) findViewById(R.id.rb_collect);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.detail_top_ib:
                finish();
                break;

            case R.id.detail_start_bt:
                MyApplication myapplication = (MyApplication) getApplication();
                Details details2 = mdata.get(0);
                myapplication.addReading(details2);
                Intent intent = new Intent(this,ChapterActivity.class);
                intent.putExtra("cid",id);
                startActivity(intent);
                break;

            case R.id.rb_collect:// 收藏
                // Toast.makeText(this, "收藏", 1).show();
                MyApplication myapplication1 = (MyApplication) getApplication();
                Details details3 = mdata.get(0);
                myapplication1.addCollection(details3);
                break;
        }

    }
}
