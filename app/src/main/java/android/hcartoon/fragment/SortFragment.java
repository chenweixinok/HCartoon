package android.hcartoon.fragment;


import android.content.Intent;
import android.hcartoon.activity.LoginActivity;
import android.hcartoon.activity.R;
import android.hcartoon.activity.SortActivity;
import android.hcartoon.adapter.SortAdapter;
import android.hcartoon.bean.Sort;
import android.hcartoon.constant.Constant;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Lenovo on 2015/11/20.
 */
public class SortFragment extends Fragment implements AdapterView.OnItemClickListener, Response.Listener<JSONObject> {

    private GridView gridView;
    private SortAdapter sortAdapter;
    private ArrayList<Sort> list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_sort, null);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        gridView = (GridView) view.findViewById(R.id.sort_gv);
        sortAdapter = new SortAdapter(getActivity());
        gridView.setOnItemClickListener(this);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                Constant.SORT_LIST,null,this,null);
        queue.add(request);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (list != null){
            Sort sort = list.get(position);
            String t_id = sort.getT_id();
            String title = sort.getT_name();
            Intent intent = new Intent(getActivity(), SortActivity.class);
            intent.putExtra("id",t_id);
            intent.putExtra("title",title);
            startActivity(intent);
        }

    }

    @Override
    public void onResponse(JSONObject jsonObject) {

        list = new ArrayList<Sort>();
        try {
            JSONObject object = jsonObject.getJSONObject("data");
            Iterator iterator = object.keys();
            while (iterator.hasNext()){
                String key = String.valueOf(iterator.next());
                JSONObject object1 = object.getJSONObject(key);
                String title = object1.getString("t_name");
                String id = object1.getString("t_id");
                String img = Constant.HOST_NAME + object1.getString("t_pic");
                list.add(new Sort(id,title,img));
            }
            sortAdapter.setData(list);
            gridView.setAdapter(sortAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
