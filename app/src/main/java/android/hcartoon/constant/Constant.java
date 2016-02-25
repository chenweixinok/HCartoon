package android.hcartoon.constant;

/**
 * Created by Lenovo on 2015/11/18.
 */
public class Constant {

    /**
     * 主机名
     */
    public static final String HOST_NAME = "http://www.mstars.cn";
    /**
     * 手机参数信息（仅测试用，实际应获取用户手机信息）
     */
    public static final String DEVICE_MODEL = "phonemodel=vivoX710L&phonesystem=android4.4.2&phoneid=864855029870732&apptype=android&appname=mstars&appver=2.5.4";
    /**
     * 广告栏
     */
    public static final String AD_LIST = "http://www.mstars.cn/api/mstars_api/ad_api.php?type=ad_list&"
            + DEVICE_MODEL + "&ad_area=2";

    /**
     * 推荐列表
     */
    public static final String RECOMMEND_LIST = "http://www.mstars.cn/api/mstars_api/app_index.php?type=%d";

    /**
     * 书籍详情
     */
    public static final String BOOK_DETAIL = "http://www.mstars.cn/api/mstars_api/cartoon_info.php?phonemodel=NoxW&phonesystem=android4.4.2&phoneid=352284044073926&apptype=android&appname=mstars&appver=2.5.4&c_id=";

    /**
     * 用户名
     */
    public static final String USERNAME="&u_id=&user_name=mstars1438764774284694";
    /**
     * 分类列表
     */
    public static final String SORT_LIST = "http://www.mstars.cn/api/mstars_api/cartoon_theme.php?type=theme";

    /**
     * 分类列表项
     */
    public static final String SORT_LIST_ITEMS = "http://www.mstars.cn/api/mstars_api/cartoon_list.php?type=theme&"
            + DEVICE_MODEL + "&t_id=";

    /**
     * 专区列表
     */
    public static final String TOPIC_LIST = "http://www.mstars.cn/api/mstars_api/specialtopic_list_v2.php?phonemodel=vivoX710L&phonesystem=android4.4.2&phoneid=864855029870732&apptype=android&appname=mstars&appver=2.5.4&type=";
    /**
     * 专区列表项
     */
    public static final String TOPIC_LIST_ITEMS = "http://www.mstars.cn/api/mstars_api/specialtopic_info.php?phonemodel=vivoX710L&phonesystem=android4.4.2&phoneid=864855029870732&apptype=android&appname=mstars&appver=2.5.4&st_id=";

    /**
     * 人气排行
     */
    public static final String POPULARITY_RANK = "http://www.mstars.cn/api/mstars_api/cartoon_list.php?type=order";
    /**
     * 周排行
     */
    public static final String WEEK_RANK = "http://www.mstars.cn/api/mstars_api/cartoon_month_order.php?";
}
