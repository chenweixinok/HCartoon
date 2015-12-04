package android.hcartoon.bean;

/**
 * 书籍详情实体类
 * Created by Lenovo on 2015/11/22.
 */
public class Details {
    private String c_id;
    private String c_name;
    private String c_memo;
    private String author_name;
    private String c_status;
    private String own_copyright;
    private String popularity;
    private String frontcover;
    private String t_id;
    private String ty_id;
    private String c_from;
    private String jump_out;
    private String frontcover_small;
    private String out_url;
    private String c_status_name;
    private String new_chapter_name;
    private String is_collection;
    private String can_download;

    public Details(String c_id, String c_name, String c_memo,
                   String author_name, String popularity, String frontcover,
                   String frontcover_small, String c_status_name,
                   String new_chapter_name) {
        super();
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_memo = c_memo;
        this.author_name = author_name;
        this.popularity = popularity;
        this.frontcover = frontcover;
        this.frontcover_small = frontcover_small;
        this.c_status_name = c_status_name;
        this.new_chapter_name = new_chapter_name;
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
    public String getC_status() {
        return c_status;
    }
    public void setC_status(String c_status) {
        this.c_status = c_status;
    }
    public String getOwn_copyright() {
        return own_copyright;
    }
    public void setOwn_copyright(String own_copyright) {
        this.own_copyright = own_copyright;
    }
    public String getPopularity() {
        return popularity;
    }
    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }
    public String getFrontcover() {
        return frontcover;
    }
    public void setFrontcover(String frontcover) {
        this.frontcover = frontcover;
    }
    public String getT_id() {
        return t_id;
    }
    public void setT_id(String t_id) {
        this.t_id = t_id;
    }
    public String getTy_id() {
        return ty_id;
    }
    public void setTy_id(String ty_id) {
        this.ty_id = ty_id;
    }
    public String getC_from() {
        return c_from;
    }
    public void setC_from(String c_from) {
        this.c_from = c_from;
    }
    public String getJump_out() {
        return jump_out;
    }
    public void setJump_out(String jump_out) {
        this.jump_out = jump_out;
    }
    public String getFrontcover_small() {
        return frontcover_small;
    }
    public void setFrontcover_small(String frontcover_small) {
        this.frontcover_small = frontcover_small;
    }
    public String getOut_url() {
        return out_url;
    }
    public void setOut_url(String out_url) {
        this.out_url = out_url;
    }
    public String getC_status_name() {
        return c_status_name;
    }
    public void setC_status_name(String c_status_name) {
        this.c_status_name = c_status_name;
    }
    public String getNew_chapter_name() {
        return new_chapter_name;
    }
    public void setNew_chapter_name(String new_chapter_name) {
        this.new_chapter_name = new_chapter_name;
    }
    public String getIs_collection() {
        return is_collection;
    }
    public void setIs_collection(String is_collection) {
        this.is_collection = is_collection;
    }
    public String getCan_download() {
        return can_download;
    }
    public void setCan_download(String can_download) {
        this.can_download = can_download;
    }
    public String getC_memo() {
        return c_memo;
    }
    public void setC_memo(String c_memo) {
        this.c_memo = c_memo;
    }
    @Override
    public String toString() {
        return "Details [c_id=" + c_id + ", c_name=" + c_name + ", c_memo="
                + c_memo + ", author_name=" + author_name + ", popularity="
                + popularity + ", frontcover=" + frontcover
                + ", frontcover_small=" + frontcover_small + ", c_status_name="
                + c_status_name + ", new_chapter_name=" + new_chapter_name
                + "]";
    }

}
