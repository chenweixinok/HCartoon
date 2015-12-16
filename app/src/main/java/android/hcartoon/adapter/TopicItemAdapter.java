package android.hcartoon.adapter;

import android.content.Context;
import android.hcartoon.activity.R;
import android.hcartoon.bean.TopicItem;
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
import java.util.List;

/**
 * Created by Lenovo on 2015/12/4.
 */
public class TopicItemAdapter extends BaseAdapter{

    private List<TopicItem> mlist = new ArrayList<TopicItem>();
    private BitmapUtils bitmapUtils;

    private final int TOP = 0;//头内容
    private final int DOWN = 1;//listview内容

    public TopicItemAdapter(Context context){
        bitmapUtils = new BitmapUtils(context);
    }

    /**
     * 添加数据
     *
     * @param list
     */
    public void addData(List<TopicItem> list) {
        mlist.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return TOP;//返回头
        }else {
            return DOWN;//返回listView
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        int type = getItemViewType(position);
        if (convertView == null){
            if (type == DOWN){
                /**
                 * listView 内容
                 */
                holder = new ViewHolder();
                convertView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_topicitem, parent, false);
                holder.img = (ImageView) convertView
                        .findViewById(R.id.topicitem_logo_iv);
                holder.author = (TextView) convertView
                        .findViewById(R.id.topicitem_author_tv);
                holder.title = (TextView) convertView
                        .findViewById(R.id.topicitem_name_tv);
                holder.hits = (TextView) convertView
                        .findViewById(R.id.topicitem_popularity_tv);
                holder.chapter = (TextView) convertView
                        .findViewById(R.id.topicitem_status_tv);
                holder.type = (TextView) convertView
                        .findViewById(R.id.topicitem_type_tv);
                convertView.setTag(holder);
            }else {
                //头
                holder = new ViewHolder();
                convertView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_topicitem_top, parent, false);
                holder.img = (ImageView) convertView
                        .findViewById(R.id.topic_item_top_logo_iv);
                holder.title = (TextView) convertView
                        .findViewById(R.id.topic_item_top_title_tv);
                holder.hits = (TextView) convertView
                        .findViewById(R.id.topic_item_top_num_tv);
                holder.chapter = (TextView) convertView
                        .findViewById(R.id.topic_item_top_neirong_tv);
                convertView.setTag(holder);
            }
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        // 绑定数据
        setDate2Ui(holder, position, parent, type);
        return convertView;
    }

    /**
     * 绑定数据
     *
     * @param holder
     * @param position
     * @param parent
     */
    private void setDate2Ui(ViewHolder holder, int position, ViewGroup parent,
                            int type) {
        // TODO Auto-generated method stub
        TopicItem topicItem = mlist.get(position);
        if (type == DOWN) {
            //listview内容
            String st_ids = topicItem.getSt_id();
            String c_id = topicItem.getC_id();
            String status_name = topicItem.getC_status_name();
            String c_name = topicItem.getC_name();
            String frontcover = topicItem.getFrontcover();
            String author_name = topicItem.getAuthor_name();
            String t_name = topicItem.getT_name();
            String popularity = topicItem.getPopularity();
            holder.author.setText(author_name);
            holder.title.setText(c_name);
            holder.hits.setText(popularity);
            holder.chapter.setText(status_name);
            holder.type.setText(t_name);
            // 获取图片
            if (frontcover.equals("") || frontcover == null) {
                // 默认
                holder.img.setImageResource(R.drawable.special_definite_book);
            } else {
                bitmapUtils
                        .configDefaultLoadingImage(R.drawable.special_definite_book);
                bitmapUtils
                        .display(holder.img, Constant.HOST_NAME + frontcover);
            }
        }else{
            //listview头
            holder.hits.setText(topicItem.getSt_num());
            holder.chapter.setText(topicItem.getSt_content());
            holder.title.setText(topicItem.getSt_name());
            String st_pic = topicItem.getSt_pic();
            if (st_pic.equals("") || st_pic == null) {
                // 默认
                holder.img.setImageResource(R.drawable.special_definite_banner);
            } else {
                BitmapUtils bitmapUtils = new BitmapUtils(parent.getContext());
                bitmapUtils.configDefaultLoadingImage(R.drawable.special_definite_banner);
                bitmapUtils.display(holder.img, Constant.HOST_NAME + st_pic);
            }
        }
    }
}
