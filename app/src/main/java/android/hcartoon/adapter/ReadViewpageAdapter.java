package android.hcartoon.adapter;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.hcartoon.activity.R;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;


import java.util.List;

/**
 * Created by Lenovo on 2015/11/27.
 */
public class ReadViewpageAdapter extends PagerAdapter{

    private List<String> pathlist;
    private Context context;
    private BitmapUtils bitmapUtils;

    public ReadViewpageAdapter(){
        super();
    }

    public void setImageData(List<String> list){

        this.pathlist = list;

    }

    public ReadViewpageAdapter(Context context){
        super();
        this.context = context;
        bitmapUtils = new BitmapUtils(context);
        bitmapUtils.configDefaultLoadingImage(R.drawable.wait);
    }
    @Override
    public int getCount() {
        return pathlist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView view = new ImageView(context);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);
        String url = pathlist.get(position);

        bitmapUtils.display(view,url);
        container.addView(view);
        return view;
    }
}
