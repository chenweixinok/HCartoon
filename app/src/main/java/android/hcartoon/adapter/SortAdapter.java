package android.hcartoon.adapter;

import android.content.Context;
import android.hcartoon.activity.R;
import android.hcartoon.bean.Sort;
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
public class SortAdapter extends BaseAdapter{

    private ArrayList<Sort> data;
    private BitmapUtils bitmapUtils;
    private LayoutInflater inflater;


    public SortAdapter(Context context){
        super();
        bitmapUtils = new BitmapUtils(context);
        inflater = LayoutInflater.from(context);
        bitmapUtils.configDefaultLoadingImage(R.drawable.other_classify_icon);
    }

    public void setData(ArrayList<Sort> data) {
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
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_sort, null);
            holder.imageView = (ImageView) convertView.findViewById(R.id.sort_img);
            holder.title = (TextView) convertView.findViewById(R.id.sort_title);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Sort sort = data.get(position);
        String t_name = sort.getT_name();
        String t_pic = sort.getT_pic();

        holder.title.setText(t_name);
        bitmapUtils.display(holder.imageView,t_pic);
        return convertView;
    }

    public class ViewHolder{
        ImageView imageView;
        TextView title;
    }
}
