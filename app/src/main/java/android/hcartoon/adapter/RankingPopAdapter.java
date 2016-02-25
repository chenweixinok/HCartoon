package android.hcartoon.adapter;

import android.content.Context;
import android.hcartoon.activity.R;
import android.hcartoon.bean.RankingBean;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by Lenovo on 2016/2/24.
 */
public class RankingPopAdapter extends BaseAdapter{


    private List<RankingBean> popList;
    private BitmapUtils bitmapUtils;

    public RankingPopAdapter(Context context){
        super();
        bitmapUtils = new BitmapUtils(context);
    }

    /**
     *设置数据集合
     * @return
     */
    public void setPopData(List<RankingBean> list){
        this.popList = list;
    }


    @Override
    public int getCount() {
        return popList.size();
    }

    @Override
    public Object getItem(int position) {
        return popList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PopViewHolder pViewHolder = null;
        if (convertView == null) {
            pViewHolder = new PopViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_ranking_pop, parent, false);
            pViewHolder.popImage = (ImageView) convertView
                    .findViewById(R.id.iv_ranking_pop_cover);
            pViewHolder.popCname_tv = (TextView) convertView
                    .findViewById(R.id.tv_ranking_pop_cname);
            pViewHolder.popStatusName_tv = (TextView) convertView
                    .findViewById(R.id.tv_ranking_pop_statusname);
            pViewHolder.popAname_tv = (TextView) convertView
                    .findViewById(R.id.tv_ranking_pop_author_name);
            pViewHolder.popTypeName_tv = (TextView) convertView
                    .findViewById(R.id.tv_ranking_pop_tname);
            pViewHolder.popCollection_tv = (TextView) convertView
                    .findViewById(R.id.tv_ranking_pop_collection);
            pViewHolder.popPopu_tv = (TextView) convertView
                    .findViewById(R.id.tv_ranking_pop_popularity);
            convertView.setTag(pViewHolder);
        } else {
            pViewHolder = (PopViewHolder) convertView.getTag();
        }

        setDataToUI(pViewHolder, position, parent);
        return convertView;
    }

    private void setDataToUI(PopViewHolder pViewHolder, int position, ViewGroup parent) {

        if (popList == null) {
            return;
        }
        RankingBean rb = popList.get(position);
        String cname = rb.getC_name();
        String statusName = rb.getC_status_name();
        String aName = rb.getAuthor_name();
        String typeName = rb.getT_name();
        String collection = rb.getCollevtion();
        String popularity = rb.getPopularity();
        String imageUrl = rb.getImage_small();// ??使用大图还是小图？→使用小图

        if (!cname.equals("")) {
            pViewHolder.popCname_tv.setText(cname);
        }
        if (!statusName.equals("")) {
            pViewHolder.popStatusName_tv.setText(statusName);
        }
        if (!aName.equals("")) {
            pViewHolder.popAname_tv.setText(aName);
        }
        if (!typeName.equals("")) {
            pViewHolder.popTypeName_tv.setText(typeName);
        }
        if (!collection.equals("")) {
            pViewHolder.popCollection_tv.setText(collection);
        }
        if (!popularity.equals("")) {
            pViewHolder.popPopu_tv.setText(popularity);
        }

        if (!imageUrl.equals("")) {
            bitmapUtils.display(pViewHolder.popImage, imageUrl);// 设置图片
        }
    }


    class PopViewHolder {
        private ImageView popImage; // 图片
        private TextView popCname_tv; // 作品名字
        private TextView popStatusName_tv; // 连载
        private TextView popAname_tv;// 作者名字
        private TextView popTypeName_tv; // 分类名字
        private TextView popCollection_tv; // 收藏数量
        private TextView popPopu_tv; // 人气数量
    }

}
