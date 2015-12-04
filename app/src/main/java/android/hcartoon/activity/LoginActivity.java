package android.hcartoon.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Lenovo on 2015/11/18.
 */
public class LoginActivity extends Activity{

    private int[] textIds = new int[]{R.id.text01,R.id.text02,
            R.id.text03,R.id.text04,R.id.text05};

    private int[] colors = new int[]{Color.RED,Color.MAGENTA,Color.GREEN,
            Color.YELLOW,Color.BLUE};

    private TextView[] views = new TextView[textIds.length];

    private Handler mHandler;

    private int current = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        for (int i = 0;i < textIds.length; i++){
            views[i] = (TextView) findViewById(textIds[i]);
        }

        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x11){
                    for (int i = 0;i < views.length;i++){
                        views[i].setBackgroundColor(colors[(i+current)%colors.length]);
                    }
                    current = (current + 1)%colors.length;
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(0x11);
            }
        },0,3000);
    }
}
