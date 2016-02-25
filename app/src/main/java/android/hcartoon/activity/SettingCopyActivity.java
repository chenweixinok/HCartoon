package android.hcartoon.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Lenovo on 2016/2/25.
 */
public class SettingCopyActivity extends Activity implements View.OnClickListener {


    private Button breakBtn, sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_copyright);
        breakBtn = (Button) findViewById(R.id.settingcopy_brank_btn);
        sendBtn = (Button) findViewById(R.id.settingcopy_ok_btn);
        breakBtn.setOnClickListener(this);
        sendBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.settingcopy_brank_btn:
                finish();
                break;
            case R.id.settingcopy_ok_btn:
                Toast.makeText(this, "投诉成功！我们会尽快处理", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}
