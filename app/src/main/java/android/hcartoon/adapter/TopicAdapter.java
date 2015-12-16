package android.hcartoon.adapter;

import android.content.Context;
import android.hcartoon.activity.R;
import android.hcartoon.bean.Topic;
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
public class TopicAdapter extends BaseAdapter{

    List<Topic> list = new ArrayList<Topic>();
    private BitmapUtils bitmapUtils;

    public TopicAdapter(Context context) {
        bitmapUtils = new BitmapUtils(context);
    }

    /**
     * 更新专区ui
     * @param list
     */
    public void addData(List<Topic> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic, parent, false);
            holder.img=(ImageView) convertView.findViewById(R.id.topic_item_logo_iv);
            holder.title=(TextView) convertView.findViewById(R.id.topic_item_name_tv);
            holder.hits=(TextView) convertView.findViewById(R.id.topic_item_hits_tv);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //绑定数据
        setDate2Ui(holder, position,parent);
        return convertView;
    }
    /**
     * 绑定数据
     * @param holder
     * @param position
     */
    private void setDate2Ui(ViewHolder holder, int position,ViewGroup parent) {
        // TODO Auto-generated method stub
        Topic  topic= list.get(position);
        holder.title.setText(topic.getSt_name());
        holder.hits.setText(topic.getHits());
        //获取图片
        if(topic.getSt_logo().equals("")||topic.getSt_logo()==null){
            //默认
            holder.img.setImageResource(R.drawable.special_definite_banner);
        }else{
            bitmapUtils.configDefaultLoadingImage(R.drawable.special_definite_banner);
            bitmapUtils.display(holder.img, Constant.HOST_NAME + topic.getSt_logo());
        }
    }

}
