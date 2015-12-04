package android.hcartoon.adapter;

import android.content.Context;
import android.hcartoon.activity.R;
import android.hcartoon.bean.Recommend;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2015/11/18.
 */
public class RecomAdapter extends BaseAdapter{

    private ArrayList<Recommend> data;
    private LayoutInflater inflater;
    private BitmapUtils bitmapUtils;

    public RecomAdapter(Context context){
        super();
        inflater = LayoutInflater.from(context);
        bitmapUtils = new BitmapUtils(context);
        bitmapUtils.configDefaultLoadingImage(R.drawable.recommend_banner_image);
    }

    public void setData(ArrayList<Recommend> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_recom, null);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.recom_img);
            holder.title = (TextView) convertView
                    .findViewById(R.id.recom_title);
            holder.chapter = (TextView) convertView
                    .findViewById(R.id.recom_chapter);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Recommend recommend = data.get(position);
        String img = recommend.getImg_url();
        String title = recommend.getTitle();
        String chapter = recommend.getChapter();

        holder.title.setText(title);
        holder.chapter.setText(chapter);

        bitmapUtils.display(holder.img, img);

        return convertView;
    }

    public class ViewHolder {
        public ImageView img;
        public TextView title;
        public TextView chapter;
        public TextView hits;
        public TextView author;
        public TextView type;
    }
}
