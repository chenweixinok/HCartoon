package android.hcartoon.adapter;

import android.content.Context;;
import android.content.Intent;
import android.hcartoon.activity.DetailActivity;
import android.hcartoon.activity.R;
import android.hcartoon.bean.Advertisement;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2015/11/18.
 */
public class AdPagerAdapter extends PagerAdapter{

    private ArrayList<Advertisement> data;
    private Context context;
    private BitmapUtils bitmapUtils;


    public AdPagerAdapter(Context context){
        super();
        this.context = context;
        bitmapUtils = new BitmapUtils(context);
        bitmapUtils.configDefaultLoadingImage(R.drawable.recommend_ad_banner);
    }

    public void setData(ArrayList<Advertisement> data){
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.items_ads, null);
        ImageView adImg = (ImageView) view.findViewById(R.id.ad_img);
        TextView adTitle = (TextView) view.findViewById(R.id.ad_title);
        adImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cid = data.get(position).getCid();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("cid",cid);
                context.startActivity(intent);
            }
        });

        Advertisement ad = data.get(position);
        String imgUrl = ad.getImg_url();
        String title = ad.getTitle();

        adTitle.setText(title);
        bitmapUtils.display(adImg,imgUrl);
        container.addView(view);
        return view;
    }


}
