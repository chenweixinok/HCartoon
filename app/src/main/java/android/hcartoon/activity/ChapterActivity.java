package android.hcartoon.activity;

import android.hcartoon.fragment.ChapterDownloadFragment;
import android.hcartoon.fragment.ChapterReadFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 章节列表activity
 * Created by Lenovo on 2015/11/24.
 */
public class ChapterActivity extends FragmentActivity implements View.OnClickListener {

    private TextView tvCname, tvStatusName;
    private ImageButton btnBrank;
    private RadioButton rbRead, rbDownload;
    private RequestQueue requestQueue;

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private ChapterReadFragment chapterReadFragment;
    private ChapterDownloadFragment cdFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);
        initView();

        requestQueue = Volley.newRequestQueue(this);
        String cid = getIntent().getStringExtra("cid");
        String path = "http://www.mstars.cn/api/mstars_api/cartoon_info.php?phonemodel=NoxW&phonesystem=android4.4.2&phoneid=352284044073926&apptype=android&appname=mstars&appver=2.5.4&c_id="
                + cid + "&u_id=&user_name=mstars1438764774284694";
        setTextViewData(path);

        btnBrank.setOnClickListener(this);
        rbRead.setOnClickListener(this);
        rbDownload.setOnClickListener(this);

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        chapterReadFragment = new ChapterReadFragment();
        transaction.replace(R.id.chapter_fragment,chapterReadFragment);
        transaction.commit();
    }

    private void setTextViewData(String path) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                path, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                    String cname = jsonObject1.getString("c_name");
                    String statusName = jsonObject1
                            .getString("c_status_name");
                    tvCname.setText(cname);
                    tvStatusName.setText(statusName);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },null);
        requestQueue.add(jsonObjectRequest);
    }

    /**
     * 初始化控件
     */
    private void initView() {

        tvCname = (TextView) findViewById(R.id.chapter_cname_tv);
        tvStatusName = (TextView) findViewById(R.id.chapter_status_tv);
        btnBrank = (ImageButton) findViewById(R.id.chapter_back_bt);
        rbRead = (RadioButton) findViewById(R.id.chapter_index_read);
        rbDownload = (RadioButton) findViewById(R.id.chapter_index_download);
    }

    @Override
    public void onClick(View v) {
        transaction = manager.beginTransaction();
        switch (v.getId()){
            case R.id.chapter_back_bt:
                finish();
                break;

            case R.id.chapter_index_read:
                if (chapterReadFragment == null){
                    chapterReadFragment = new ChapterReadFragment();
                }
                transaction.replace(R.id.chapter_fragment,chapterReadFragment);
                transaction.commit();
                break;

            case R.id.chapter_index_download:
                if (cdFragment == null){
                    cdFragment = new ChapterDownloadFragment();
                }
                transaction.replace(R.id.chapter_fragment, cdFragment);
                transaction.commit();
                break;
        }

    }
}
