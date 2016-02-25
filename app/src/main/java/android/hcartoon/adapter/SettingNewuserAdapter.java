package android.hcartoon.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.app.ActionBar.LayoutParams;

import java.util.List;

/**
 * Created by Lenovo on 2016/2/25.
 */
public class SettingNewuserAdapter extends PagerAdapter{

    private List<Integer> list;
    private Context context;


    public SettingNewuserAdapter(List<Integer> list, Context context){
        super();
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView view = new ImageView(context);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);
        view.setImageResource(list.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
    }
}
