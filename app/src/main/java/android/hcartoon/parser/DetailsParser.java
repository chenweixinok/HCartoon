package android.hcartoon.parser;

import android.hcartoon.bean.Details;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2015/11/22.
 */
public class DetailsParser {

    public static List<Details> detailsJson(JSONObject response) throws JSONException{

        List<Details> list = new ArrayList<Details>();
        JSONObject jsonObject2 = response.getJSONObject("data");
        String c_id = jsonObject2.getString("c_id");
        String c_name = jsonObject2.getString("c_name");
        String c_memo=jsonObject2.getString("c_memo");
        String author_name = jsonObject2.getString("author_name");
        String popularity = jsonObject2.getString("popularity");
        String frontcover = jsonObject2.getString("frontcover");
        String frontcover_small = jsonObject2.getString("frontcover_small");
        String c_status_name = jsonObject2.getString("c_status_name");
        String new_chapter_name = jsonObject2.getString("new_chapter_name");
        Details details=new Details(c_id, c_name, c_memo, author_name, popularity, frontcover, frontcover_small, c_status_name, new_chapter_name);
        list.add(details);
        return list;
    }
}
