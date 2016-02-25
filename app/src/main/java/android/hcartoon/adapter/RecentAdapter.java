package android.hcartoon.adapter;

import android.content.Context;
import android.hcartoon.activity.R;
import android.hcartoon.bean.RecentBean;
import android.hcartoon.bean.ViewHolder;
import android.hcartoon.constant.Constant;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2016/2/24.
 */
public class RecentAdapter extends BaseAdapter{


    private ArrayList<RecentBean> data;
    private BitmapUtils bitmapUtils;
    private LayoutInflater inflater;

    public RecentAdapter(Context context) {
        super();
        inflater = LayoutInflater.from(context);
        bitmapUtils = new BitmapUtils(context);
    }

    public void setData(ArrayList<RecentBean> data) {
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_shelf, null);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.recent_img);
            holder.title = (TextView) convertView
                    .findViewById(R.id.recent_title);
            holder.chapter = (TextView) convertView
                    .findViewById(R.id.recent_author);
            holder.hits = (TextView) convertView.findViewById(R.id.recent_pop);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        RecentBean details = data.get(position);
        String title = details.getTitle();
        String author = details.getAuthor();
        String pop = details.getPopularity();
        String img = details.getImg();
        String image = Constant.HOST_NAME + img;
        holder.title.setText("《" + title + "》");
        holder.hits.setText("人气：" + pop);
        holder.chapter.setText("作者：" + author);
        bitmapUtils.display(holder.img, image);

        return convertView;
    }
}
