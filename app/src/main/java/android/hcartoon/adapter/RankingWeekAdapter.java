package android.hcartoon.adapter;

import android.hcartoon.activity.R;
import android.hcartoon.bean.RankingWeekBean;
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
public class RankingWeekAdapter extends BaseAdapter{


    private List<RankingWeekBean> weekList;
    private final int TYPE_COUNT = 2;
    private final int FIRST_TYPE = 0;
    private final int OTHERS_TYPE = 1;
    private int countType;

    /**
     * 初始化数据
     *
     * @param list
     */
    public void setWeekData(List<RankingWeekBean> list) {
        this.weekList = list;
    }



    @Override
    public int getCount() {
        return weekList.size();
    }

    @Override
    public Object getItem(int position) {
        return weekList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return FIRST_TYPE;
        } else {
            return OTHERS_TYPE;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        WeekViewHolder weekViewHolder;
        countType = getItemViewType(position);
        View firstView = null;
        if (countType == FIRST_TYPE){
            firstView = convertView;
            if (firstView == null){

                firstView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.rank_week_head, parent, false);
                ImageView headImage = (ImageView) firstView
                        .findViewById(R.id.iv_ranking_header);
                TextView headCName = (TextView) firstView
                        .findViewById(R.id.tv_ranking_head_cname);
                TextView headAname = (TextView) firstView
                        .findViewById(R.id.tv_ranking_head_author_name);
                TextView headText = (TextView) firstView
                        .findViewById(R.id.tv_head_text);

                RankingWeekBean rbean = weekList.get(position);
                headCName.setText(rbean.getC_name());
                headAname.setText(rbean.getAuthor_name());
                headText.setText("简介 ：" + rbean.getC_memo());

                BitmapUtils bitmapUtils = new BitmapUtils(parent.getContext());
                bitmapUtils.display(headImage, rbean.getFrontcover_small());// 设置图片
                convertView = firstView;

            }
        }else {
            if (convertView == null){
                weekViewHolder = new WeekViewHolder();
                convertView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_ranking_week, parent, false);
                weekViewHolder.weekCname = (TextView) convertView
                        .findViewById(R.id.tv_ranking_week_cname);
                weekViewHolder.weekChapter = (TextView) convertView
                        .findViewById(R.id.tv_ranking_week_chapter);
                convertView.setTag(weekViewHolder);
            }else {
                weekViewHolder = (WeekViewHolder) convertView.getTag();
            }

            // 设置值
            RankingWeekBean rweek = weekList.get(position);
            String cname = rweek.getC_name();// 获取作品名字
            String chapter = rweek.getNew_chapter();// 获取该章节
            weekViewHolder.weekCname.setText(cname);
            weekViewHolder.weekChapter.setText(chapter);
        }
        return convertView;
    }


    private class WeekViewHolder {
        private TextView weekCname;// 作品名字
        private TextView weekChapter;// 章节
    }
}
