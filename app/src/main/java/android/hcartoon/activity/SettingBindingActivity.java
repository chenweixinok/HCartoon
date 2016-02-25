package android.hcartoon.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Lenovo on 2016/2/25.
 */
public class SettingBindingActivity extends Activity{

    private Button breakBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_binding);
        breakBtn = (Button) findViewById(R.id.settingbind_brank_btn);
        breakBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
