package android.hcartoon.activity;



import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.hcartoon.adapter.MainPageAdapter;
import android.hcartoon.fragment.NavigationFragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends FragmentActivity implements OnCheckedChangeListener,
        View.OnClickListener, OnPageChangeListener {

    private ViewPager boby;
    private RadioGroup radioGroup;
    private TextView title;
    private DrawerLayout drawerLayout;
    private LinearLayout navigation;

    private ObjectAnimator anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initNavigation();

        anim = ObjectAnimator.ofFloat(title, "alpha", 0.25f, 1f);
        anim.setDuration(5000);
        //anim.setRepeatCount(5);
        //anim.setRepeatMode(ObjectAnimator.RESTART);


    }

    private void initNavigation() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigation = (LinearLayout) findViewById(R.id.navigation);
        getSupportFragmentManager().beginTransaction()
               .add(R.id.navigation, new NavigationFragment()).commit();

    }

    private void initView() {
        boby = (ViewPager) findViewById(R.id.page_boby);
        boby.setAdapter(new MainPageAdapter(getSupportFragmentManager()));
        boby.setCurrentItem(0);
        boby.setOnPageChangeListener(this);

        /**
         * MainActivity底部的几个RadioButton
         */
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        RadioButton defaultButton = (RadioButton) radioGroup.getChildAt(0);
        defaultButton.setChecked(true);
        radioGroup.setOnCheckedChangeListener(this);
        title = (TextView) findViewById(R.id.title);

        /**
         * MainActvity里的标题栏 设置与搜索按钮  点击事件
         */
        findViewById(R.id.setting).setOnClickListener(this);
        findViewById(R.id.search).setOnClickListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){
            case R.id.rb_recommend:
                boby.setCurrentItem(0);
                anim.start();
                title.setText("嗨漫画");
                break;

            case R.id.rb_sort:
                boby.setCurrentItem(1);
                anim.start();
                title.setText("分类");
                break;

            case R.id.rb_topic:
                boby.setCurrentItem(2);
                anim.start();
                title.setText("专区");
                break;

            case R.id.rb_order:
                boby.setCurrentItem(3);
                anim.start();
                title.setText("排行");
                break;

            case R.id.rb_shelf:
                boby.setCurrentItem(4);
                anim.start();
                title.setText("书架");
                break;
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.setting:
                drawerLayout.openDrawer(navigation);
                break;

            case R.id.search:
                Toast.makeText(this,"开发中。。。",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        RadioButton child = (RadioButton) radioGroup.getChildAt(position);
        child.setChecked(true);
    }

        @Override
    public void onPageScrollStateChanged(int state) {

    }
}
