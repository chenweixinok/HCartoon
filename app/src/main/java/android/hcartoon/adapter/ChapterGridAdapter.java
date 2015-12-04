package android.hcartoon.adapter;

import android.content.Context;
import android.content.Intent;
import android.hcartoon.activity.R;
import android.hcartoon.activity.ReadingActivity;
import android.hcartoon.bean.ChapterGridBean;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;

import java.util.List;

/**
 * 章节列表 gridview 适配器
 * Created by Lenovo on 2015/11/25.
 */
public class ChapterGridAdapter extends BaseAdapter{

    private List<ChapterGridBean> gList;
    private Context context;

    public ChapterGridAdapter(Context context){
        super();
        this.context = context;
    }

    /**
     * 初始化数据聚合
     * @param list
     */
    public void setGridViewData(List<ChapterGridBean> list){
        this.gList = list;
    }


    @Override
    public int getCount() {
        return gList.size();
    }

    @Override
    public Object getItem(int position) {
        return gList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        GridViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new GridViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_chapter_gridview, parent,false);
            viewHolder.radioButton = (RadioButton) convertView.findViewById(R.id.chapter_gv_rb);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (GridViewHolder) convertView.getTag();
        }
            ChapterGridBean cgBean = gList.get(position);
            String ccname = cgBean.getCcname();
            final String ccid = cgBean.getCcid();
            final String cid = cgBean.getCid();
            viewHolder.radioButton.setText(ccname);

            viewHolder.radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,ReadingActivity.class);
                    intent.putExtra("ccid",ccid);
                    intent.putExtra("cid",cid);
                    context.startActivity(intent);
                }
            });
        return convertView;
    }

    class GridViewHolder {
        private RadioButton radioButton;
    }
}
