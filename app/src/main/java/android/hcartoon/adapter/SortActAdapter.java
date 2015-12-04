package android.hcartoon.adapter;

import android.content.Context;
import android.hcartoon.activity.R;
import android.hcartoon.bean.SortActBean;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2015/12/4.
 */
public class SortActAdapter extends BaseAdapter{

    private ArrayList<SortActBean> data;
    private BitmapUtils bitmapUtils;
    private LayoutInflater inflater;

    public SortActAdapter(Context context){

        super();
        inflater = LayoutInflater.from(context);
        bitmapUtils = new BitmapUtils(context);
        bitmapUtils.configDefaultLoadingImage(R.drawable.bookdetails_book_image);

    }

    public void setData(ArrayList<SortActBean> data) {
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
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_sort_activity, null);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.sort_img_activity);
            holder.title = (TextView) convertView.findViewById(R.id.sort_title_activity);
            holder.author = (TextView) convertView.findViewById(R.id.sort_author_activity);
            holder.hits = (TextView) convertView.findViewById(R.id.sort_introd_activity);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        SortActBean sortActBean = data.get(position);
        String img = sortActBean.getImg();
        String title = sortActBean.getTitle();
        String author = sortActBean.getAuthor();
        String hits = sortActBean.getIntroduction();

        holder.title.setText("《"+ title + "》");
        holder.author.setText("作者:" + author);
        holder.hits.setText(hits);
        bitmapUtils.display(holder.img,img);
        return convertView;
    }

    public class ViewHolder{

        ImageView img;
        TextView title;
        TextView author;
        TextView hits;

    }
}
