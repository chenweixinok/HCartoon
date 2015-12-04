package android.hcartoon.activity;

import android.app.Activity;
import android.content.Intent;
import android.hcartoon.adapter.ReadViewpageAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2015/11/25.
 */
public class ReadingActivity extends Activity{

    private ViewPager viewPager;
    private ReadViewpageAdapter readViewpageAdapter;
    private List<String> urlList;
    private RequestQueue requestQueue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        viewPager = (ViewPager) findViewById(R.id.read_viewpager);
        requestQueue = Volley.newRequestQueue(this);
        urlList = new ArrayList<String>();
        Intent intent = getIntent();

        String ccid = intent.getStringExtra("ccid");
        String cid = intent.getStringExtra("cid");

        String path = "http://www.mstars.cn/api/mstars_api/cartoon_chapter_info.php?phonemodel=NoxW&phonesystem=android4.4.2&phoneid=352284044073926&apptype=android&appname=mstars&appver=2.5.4&u_id=0&user_name=mstars1438764774284694&c_id="
                + cid + "&cc_id=" + ccid;

        getData(path);

        readViewpageAdapter = new ReadViewpageAdapter(this);
        viewPager.setOffscreenPageLimit(2);

    }

    private void getData(String path) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, path,
                null, new Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                try {
                    JSONObject object = jsonObject.getJSONObject("data");
                    String pageNum = object.getString("cc_page");
                    String urlRoot = object.getString("s_root");//图片地址前缀
                    String ext = object.getString("cc_ext"); //图片类型 如：.jpg

                    String imageUrl = "";
                    int maxNum = Integer.parseInt(pageNum);
                    for (int i = 1; i <= maxNum; i++ ){
                        if (i < 10){
                            imageUrl = urlRoot + "0"+ i + ext;
                        }else {
                            imageUrl = urlRoot + i + ext;
                        }

                        urlList.add(imageUrl);
                        imageUrl = "";
                    }
                    readViewpageAdapter.setImageData(urlList);
                    viewPager.setAdapter(readViewpageAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },null);
        requestQueue.add(jsonObjectRequest);
    }
}
