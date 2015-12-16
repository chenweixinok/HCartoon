package android.hcartoon.parser;

import android.hcartoon.bean.Topic;
import android.hcartoon.bean.TopicItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Json解析
 * 
 * @author Administrator
 * 
 */
public class TopicListJson {
	/**
	 * 解析专区列表
	 *
	 * @param
	 * @return list
	 * @throws JSONException
	 */
	public static List<Topic> topicListJson(HashMap<String, String> datajson)
			throws JSONException {
		List<Topic> list = new ArrayList<Topic>();
		Set<String> set = datajson.keySet();
		JSONObject jsonObject;
		for (String key : set) {
			String vales = datajson.get(key);
			jsonObject = new JSONObject(vales);
			String st_name = jsonObject.getString("st_name");
			String st_id = jsonObject.getString("st_id");
			String st_logo = jsonObject.getString("st_logo");
			String st_num = jsonObject.getString("st_num");
			String hits = jsonObject.getString("hits");
			String st_type = jsonObject.getString("st_type");
			String st_url = jsonObject.getString("st_url");
			String st_order = jsonObject.getString("st_order");
			Topic topic=new Topic(st_id, st_name, st_logo, st_num, st_order, hits, st_type, st_url);
			list.add(topic);
		}
		return list;
	}
	/**
	 * 解析专区列表项
	 * @param
	 * @return
	 * @throws JSONException
	 */
	public static List<TopicItem> topicItemJson(JSONObject response) throws JSONException{
		HashMap<String, String> data = new HashMap<String, String>();
		List<TopicItem> list = new ArrayList<TopicItem>();
		JSONObject jsonObject2 = response.getJSONObject("data");
		String st_id = jsonObject2.getString("st_id");
		String st_name = jsonObject2.getString("st_name");
		String st_pic=jsonObject2.getString("st_pic");
		String st_content = jsonObject2.getString("st_content");
		String st_type = jsonObject2.getString("st_type");
		String st_num = jsonObject2.getString("st_num");
		String st_cartoon = jsonObject2.getString("st_cartoon");
		String st_status = jsonObject2.getString("st_status");
		String st_url = jsonObject2.getString("st_url");
		JSONObject jsonObject3 = jsonObject2.getJSONObject("cartoon_list");
		Iterator it = jsonObject3.keys();
		JSONObject js = null;
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			js = (JSONObject) jsonObject3.get(key);
			data.put(key, js.toString());
		}


		Set<String> set = data.keySet();
		JSONObject jsonObject4;
		for (String key : set) {
			String vales = data.get(key);
			jsonObject4 = new JSONObject(vales);
			String c_id = jsonObject4.getString("c_id");
			String c_name = jsonObject4.getString("c_name");
			String frontcover = jsonObject4.getString("frontcover");
			String author_name = jsonObject4.getString("author_name");
			String t_id = jsonObject4.getString("t_id");
			String popularity = jsonObject4.getString("popularity");
			String c_status = jsonObject4.getString("c_status");
			String frontcover_small = jsonObject4.getString("frontcover_small");
			String c_status_name = jsonObject4.getString("c_status_name");
			String t_name = jsonObject4.getString("t_name");

			TopicItem topicItem=new TopicItem(st_id, st_name, st_pic, st_content, st_type,
					st_num, st_status, st_url, st_cartoon, c_id,
					frontcover, author_name, t_id, popularity, frontcover_small,
					c_status_name, t_name, c_status, c_name);
			list.add(topicItem);
		}
		return list;
	}
}
