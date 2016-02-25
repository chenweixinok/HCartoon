package android.hcartoon.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lenovo on 2016/2/25.
 */
public class DownloadActivity extends Activity implements View.OnClickListener {

    private TextView downTitle, downText, bianjiText;
    private RadioButton radioFinsh, radioDowning;
    private ImageView btnBreak;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        downTitle = (TextView) findViewById(R.id.download_title);
        downText = (TextView) findViewById(R.id.download_status);
        bianjiText = (TextView) findViewById(R.id.bianji);
        radioFinsh = (RadioButton) findViewById(R.id.download_finsh);
        radioDowning = (RadioButton) findViewById(R.id.download_loading);
        btnBreak = (ImageView) findViewById(R.id.downloads_brank_btn);

        radioFinsh.setOnClickListener(this);
        radioDowning.setOnClickListener(this);
        btnBreak.setOnClickListener(this);
        bianjiText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.download_finsh:
                radioFinsh.setChecked(true);
                radioDowning.setChecked(false);
                downText.setText("没有已下载信息");
                downTitle.setText("下载完成");
                break;
            case R.id.download_loading:
                radioFinsh.setChecked(false);
                radioDowning.setChecked(true);
                downText.setText("没有下载信息");
                downTitle.setText("正在下载");
                break;
            case R.id.downloads_brank_btn:
                finish();
                break;

            case R.id.bianji:
                Toast.makeText(this, "开发中...请耐心等候！", Toast.LENGTH_LONG).show();
                break;

            default:
                break;
        }

    }
}
