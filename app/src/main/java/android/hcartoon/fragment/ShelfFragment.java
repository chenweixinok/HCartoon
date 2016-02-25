package android.hcartoon.fragment;

import android.content.Intent;
import android.hcartoon.MyApplication;
import android.hcartoon.activity.DetailActivity;
import android.hcartoon.activity.R;
import android.hcartoon.adapter.RecentAdapter;
import android.hcartoon.adapter.ShelfAdapter;
import android.hcartoon.bean.RecentBean;
import android.hcartoon.bean.ShelfBean;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

import java.util.ArrayList;


public class ShelfFragment extends Fragment implements OnCheckedChangeListener,
        OnItemClickListener {

    private ListView list;
    private ShelfAdapter adapter;

    private RadioButton rb_recent;
    private RadioButton rb_collect;
    private ArrayList<RecentBean> recent;
    private ArrayList<ShelfBean> collection;
    private RecentAdapter recAdp;
    private DbUtils dbUtils;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_bookshelf, null);
        RadioGroup group = (RadioGroup) view.findViewById(R.id.shelf_group);
        group.setOnCheckedChangeListener(this);
        rb_recent = (RadioButton) view.findViewById(R.id.shelf_recent);
        rb_collect = (RadioButton) view.findViewById(R.id.shelf_collect);
        list = (ListView) view.findViewById(R.id.shlef_list1);
        list.setOnItemClickListener(this);
        adapter = new ShelfAdapter(getActivity());
        recAdp = new RecentAdapter(getActivity());
        MyApplication app = (MyApplication) getActivity().getApplication();
        dbUtils = app.getDb();
        try {
            collection = (ArrayList<ShelfBean>) dbUtils
                    .findAll(ShelfBean.class);
            recent = (ArrayList<RecentBean>) dbUtils.findAll(RecentBean.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
        if (recent != null) {
            recAdp.setData(recent);
            list.setAdapter(recAdp);
        }
        return view;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.shelf_recent:
                if (recent != null) {
                    recAdp.setData(recent);
                    list.setAdapter(recAdp);
                }
                break;
            case R.id.shelf_collect:
                if (collection != null) {
                    adapter.setData(collection);
                    list.setAdapter(adapter);
                }
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        String cid = null;
        if (rb_recent.isChecked()) {
            cid = recent.get(position).getCid();
        }
        if (rb_collect.isChecked()) {
            cid = collection.get(position).getCid();
        }
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("cid", cid);
        getActivity().startActivity(intent);
    }

}
