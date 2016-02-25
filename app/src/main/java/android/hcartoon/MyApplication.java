package android.hcartoon;

import android.app.Application;
import android.hcartoon.bean.Details;
import android.hcartoon.bean.RecentBean;
import android.hcartoon.bean.ShelfBean;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2015/11/24.
 */
public class MyApplication extends Application{

    private ArrayList<Details> recentReading = new ArrayList<Details>();
    private ArrayList<Details> collect = new ArrayList<Details>();
    private DbUtils dbUtils;
    private int id;

    public void addReading(Details details){

        recentReading.add(details);

        String title = details.getC_name();
        String author = details.getAuthor_name();
        String img = details.getFrontcover();
        String pop = details.getPopularity();
        String cid = details.getC_id();

        RecentBean bean = new RecentBean(id++,cid,title,author,pop,img);
        try {
            dbUtils.save(bean);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }


    public void addCollection(Details details) {
        collect.add(details);
        String title = details.getC_name();
        String author = details.getAuthor_name();
        String img = details.getFrontcover();
        String pop = details.getPopularity();
        String cid = details.getC_id();
        ShelfBean bean = new ShelfBean(id++, cid, title, author, pop, img);
        try {
            dbUtils.save(bean);
        } catch (DbException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Details> getRecent(){
        return recentReading;
    }

    public ArrayList<Details> getCollection() {
        return collect;
    }

    public DbUtils getDb(){
        return dbUtils;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dbUtils = DbUtils.create(this);
    }
}
