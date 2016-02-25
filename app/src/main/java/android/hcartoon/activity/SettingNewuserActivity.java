package android.hcartoon.activity;

import android.app.Activity;
import android.hcartoon.adapter.SettingNewuserAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2016/2/25.
 */
public class SettingNewuserActivity extends Activity{

    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_newuser);

        viewPager = (ViewPager) findViewById(R.id.newuser_viewpager);
        List<Integer> list = new ArrayList<Integer>();

        list.add(R.drawable.lead01);
        list.add(R.drawable.lead02);
        list.add(R.drawable.lead03);
        list.add(R.drawable.lead04);

        SettingNewuserAdapter adapter = new SettingNewuserAdapter(list, this);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
    }
}
