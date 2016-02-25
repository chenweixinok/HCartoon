package android.hcartoon.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Lenovo on 2016/2/25.
 */
public class SetttingAboutActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_about);
        findViewById(R.id.settingabout_brank_btn).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
    }
}
