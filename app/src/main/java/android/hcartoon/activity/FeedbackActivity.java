package android.hcartoon.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

/**
 * Created by Lenovo on 2016/2/25.
 */
public class FeedbackActivity extends Activity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        findViewById(R.id.feedback_top_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
