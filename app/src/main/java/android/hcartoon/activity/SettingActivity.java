package android.hcartoon.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.hcartoon.MyApplication;
import android.hcartoon.bean.RecentBean;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.lidroid.xutils.exception.DbException;

import java.io.File;

/**
 * Created by Lenovo on 2016/2/25.
 */
public class SettingActivity extends Activity implements View.OnClickListener {


    private RelativeLayout banduser, clearread, clearcache;
    private RelativeLayout copyright, newuser, abouthi;
    private Button bBtn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);



        banduser = (RelativeLayout) findViewById(R.id.setting_banduser);
        clearread = (RelativeLayout) findViewById(R.id.setting_clear_read);
        clearcache = (RelativeLayout) findViewById(R.id.setting_clear_cache);
        copyright = (RelativeLayout) findViewById(R.id.setting_copyright);
        newuser = (RelativeLayout) findViewById(R.id.setting_newuser);
        abouthi = (RelativeLayout) findViewById(R.id.setting_about);
        bBtn = (Button) findViewById(R.id.setting_brank_btn);

        // 设置监听事件
        banduser.setOnClickListener(this);
        clearread.setOnClickListener(this);
        clearcache.setOnClickListener(this);
        copyright.setOnClickListener(this);
        newuser.setOnClickListener(this);
        abouthi.setOnClickListener(this);
        bBtn.setOnClickListener(this);

    }


    private static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.setting_banduser:
                Intent intent = new Intent(this, SettingBindingActivity.class);
                startActivity(intent);
                break;

            case R.id.setting_clear_read:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("确定要清除阅读记录？");
                builder.setTitle("提示");
                builder.setPositiveButton("确定",
                        new android.content.DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MyApplication application = (MyApplication) getApplication();
                                try {
                                    application.getDb().deleteAll(RecentBean.class);
                                } catch (DbException e) {
                                    e.printStackTrace();
                                }
                                dialog.dismiss();
                            }
                        });
                builder.setNegativeButton("取消",
                        new android.content.DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                builder.show();
                break;

            case R.id.setting_clear_cache:
                AlertDialog.Builder clearCache = new AlertDialog.Builder(this);
                clearCache.setMessage("确定要清除缓存？");
                clearCache.setTitle("提示");
                clearCache.setPositiveButton("确定",
                        new android.content.DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                if (Environment.getExternalStorageState().equals(
                                        Environment.MEDIA_MOUNTED)) {
                                    deleteDir(SettingActivity.this
                                            .getExternalCacheDir());
                                }
                                dialog.dismiss();
                            }
                        });
                clearCache.setNegativeButton("取消",
                        new android.content.DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                clearCache.show();
                break;
            case R.id.setting_copyright:
                Intent intentcp = new Intent(this, SettingCopyActivity.class);
                startActivity(intentcp);
                break;
            case R.id.setting_newuser:
                Intent intentnew = new Intent(this, SettingNewuserActivity.class);
                startActivity(intentnew);
                break;
            case R.id.setting_about:
                Intent intentabout = new Intent(this, SetttingAboutActivity.class);
                startActivity(intentabout);
                break;
            case R.id.setting_brank_btn:
                finish();
                break;

            default:
                break;
        }
    }

}
