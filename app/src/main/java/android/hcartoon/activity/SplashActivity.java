package android.hcartoon.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

/**
 * Created by Lenovo on 2015/11/17.
 */
public class SplashActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        //延迟5000毫秒跳转
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                //结束当前Activity的生命周期
                SplashActivity.this.finish();
            }
        },5000);
    }
}
