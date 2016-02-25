package android.hcartoon.bean;

/**
 * Created by Lenovo on 2016/2/24.
 */
public class RankingWeekBean {


    private String c_id; //作品id
    private String c_name;//作品名字
    private String author_name;//作者名字
    private String hit;//点击量
    private String frontcover;//大图
    private String c_memo;//简介
    private String frontcover_small;//小图
    private String new_chapter;//章节
    /**
     * 无参构造方法
     */
    public RankingWeekBean() {
        super();
    }
    /**
     * 有参构造方法
     * @param c_id 作品id
     * @param c_name 作品名字
     * @param author_name 作者名字
     * @param hit 点击量
     * @param frontcover 大图
     * @param c_memo
     * @param frontcover_small 小图
     * @param new_chapter 章节
     */
    public RankingWeekBean(String c_id, String c_name, String author_name,
                           String hit, String frontcover, String c_memo,
                           String frontcover_small, String new_chapter) {
        super();
        this.c_id = c_id;
        this.c_name = c_name;
        this.author_name = author_name;
        this.hit = hit;
        this.frontcover = frontcover;
        this.c_memo = c_memo;
        this.frontcover_small = frontcover_small;
        this.new_chapter = new_chapter;
    }
    public String getC_id() {
        return c_id;
    }
    public void setC_id(String c_id) {
        this.c_id = c_id;
    }
    public String getC_name() {
        return c_name;
    }
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
    public String getAuthor_name() {
        return author_name;
    }
    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
    public String getHit() {
        return hit;
    }
    public void setHit(String hit) {
        this.hit = hit;
    }
    public String getFrontcover() {
        return frontcover;
    }
    public void setFrontcover(String frontcover) {
        this.frontcover = frontcover;
    }
    public String getC_memo() {
        return c_memo;
    }
    public void setC_memo(String c_memo) {
        this.c_memo = c_memo;
    }
    public String getFrontcover_small() {
        return frontcover_small;
    }
    public void setFrontcover_small(String frontcover_small) {
        this.frontcover_small = frontcover_small;
    }
    public String getNew_chapter() {
        return new_chapter;
    }
    public void setNew_chapter(String new_chapter) {
        this.new_chapter = new_chapter;
    }
    @Override
    public String toString() {
        return "RankingWeekBean [c_id=" + c_id + ", c_name=" + c_name
                + ", author_name=" + author_name + ", hit=" + hit
                + ", frontcover=" + frontcover + ", c_memo=" + c_memo
                + ", frontcover_small=" + frontcover_small + ", new_chapter="
                + new_chapter + "]";
    }

}
