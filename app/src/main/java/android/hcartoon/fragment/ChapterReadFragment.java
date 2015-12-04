package android.hcartoon.fragment;

import android.hcartoon.activity.R;
import android.hcartoon.adapter.ChapterGridAdapter;
import android.hcartoon.bean.ChapterGridBean;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Lenovo on 2015/11/25.
 */
public class ChapterReadFragment extends Fragment{

    private GridView gridView;
    private RequestQueue requestQueue;
    private List<ChapterGridBean> gList;
    private ChapterGridAdapter chapterGridAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_chapter_read,container,false);
        gridView = (GridView) view.findViewById(R.id.chapter_read_gridview);
        requestQueue = Volley.newRequestQueue(getActivity());
        chapterGridAdapter = new ChapterGridAdapter(getActivity());

        gList = new ArrayList<ChapterGridBean>();
        String cid = getActivity().getIntent().getStringExtra("cid");
        String gPath = "http://www.mstars.cn/api/mstars_api/cartoon_chapter_list.php?phonemodel=NoxW&phonesystem=android4.4.2&phoneid=352284044073926&apptype=android&appname=mstars&appver=2.5.4&c_id="
                + cid;
        setGridViewData(gPath);
        return view;

    }

    /*
        获取并设置gridview的值
     */
    private void setGridViewData(String gPath) {

        JsonObjectRequest gridRequest = new JsonObjectRequest(Request.Method.POST,
                gPath, null, new Response.Listener<JSONObject>() {

            TreeSet<ChapterGridBean> treeSet = new TreeSet<ChapterGridBean>();

            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONObject object = jsonObject.getJSONObject("data");
                    Iterator iterator = object.keys();
                    while (iterator.hasNext()){
                        String key = String.valueOf(iterator.next());
                        JSONObject obj = object.getJSONObject(key);

                        String cid = obj.getString("c_id");
                        String ccid = obj.getString("cc_id");
                        String ccname = obj.getString("cc_name");

                        ChapterGridBean cgbean = new ChapterGridBean(cid, ccid, ccname);
                        treeSet.add(cgbean);
                    }

                    ChapterGridBean cgb = new ChapterGridBean();
                    Iterator<ChapterGridBean> it = treeSet.iterator();
                    while (it.hasNext()){
                        cgb = it.next();
                        gList.add(cgb);
                    }
                    chapterGridAdapter.setGridViewData(gList);
                    gridView.setAdapter(chapterGridAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },null);
        requestQueue.add(gridRequest);
    }
}
