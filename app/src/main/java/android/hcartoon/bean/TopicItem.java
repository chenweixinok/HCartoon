package android.hcartoon.bean;

/**
 * 专区列表项实体类
 * @author Administrator
 *
 */
public class TopicItem {
    private String st_id;
    private String st_name;
    private String st_pic;
    private String st_content;
    private String st_type;
    private String st_num;
    private String st_status;
    private String st_url;
    private String st_cartoon;
    private String c_id;
    private String frontcover;
    private String author_name;
    private String t_id;
    private String popularity;
    private String frontcover_small;
    private String c_status_name;
    private String t_name;
    private String c_status;
    private String c_name;

    public TopicItem(String st_id, String st_name, String st_pic, String st_content,
                     String st_type, String st_num, String st_status, String st_url,
                     String st_cartoon, String c_id, String frontcover, String author_name,
                     String t_id, String popularity, String frontcover_small, String c_status_name,
                     String t_name, String c_status, String c_name) {
        super();
        this.st_id = st_id;
        this.st_name = st_name;
        this.st_pic = st_pic;
        this.st_content = st_content;

        this.st_type = st_type;
        this.st_num = st_num;
        this.st_status = st_status;
        this.st_url = st_url;

        this.st_cartoon = st_cartoon;
        this.c_id = c_id;
        this.frontcover = frontcover;
        this.author_name = author_name;

        this.t_id = t_id;
        this.popularity = popularity;
        this.frontcover_small = frontcover_small;
        this.c_status_name = c_status_name;

        this.t_name = t_name;
        this.c_status = c_status;
        this.c_name = c_name;
    }
    public String getSt_id() {
        return st_id;
    }
    public void setSt_id(String st_id) {
        this.st_id = st_id;
    }
    public String getSt_name() {
        return st_name;
    }
    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }
    public String getSt_pic() {
        return st_pic;
    }
    public void setSt_pic(String st_pic) {
        this.st_pic = st_pic;
    }
    public String getSt_content() {
        return st_content;
    }
    public void setSt_content(String st_content) {
        this.st_content = st_content;
    }
    public String getSt_type() {
        return st_type;
    }
    public void setSt_type(String st_type) {
        this.st_type = st_type;
    }
    public String getSt_num() {
        return st_num;
    }
    public void setSt_num(String st_num) {
        this.st_num = st_num;
    }
    public String getSt_status() {
        return st_status;
    }
    public void setSt_status(String st_status) {
        this.st_status = st_status;
    }
    public String getSt_url() {
        return st_url;
    }
    public void setSt_url(String st_url) {
        this.st_url = st_url;
    }
    public String getC_id() {
        return c_id;
    }
    public void setC_id(String c_id) {
        this.c_id = c_id;
    }
    public String getFrontcover() {
        return frontcover;
    }
    public void setFrontcover(String frontcover) {
        this.frontcover = frontcover;
    }
    public String getAuthor_name() {
        return author_name;
    }
    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
    public String getT_id() {
        return t_id;
    }
    public void setT_id(String t_id) {
        this.t_id = t_id;
    }
    public String getPopularity() {
        return popularity;
    }
    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }
    public String getFrontcover_small() {
        return frontcover_small;
    }
    public void setFrontcover_small(String frontcover_small) {
        this.frontcover_small = frontcover_small;
    }
    public String getC_status_name() {
        return c_status_name;
    }
    public void setC_status_name(String c_status_name) {
        this.c_status_name = c_status_name;
    }
    public String getT_name() {
        return t_name;
    }
    public void setT_name(String t_name) {
        this.t_name = t_name;
    }
    public String getC_status() {
        return c_status;
    }
    public void setC_status(String c_status) {
        this.c_status = c_status;
    }
    public String getC_name() {
        return c_name;
    }
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
    public String getSt_cartoon() {
        return st_cartoon;
    }
    public void setSt_cartoon(String st_cartoon) {
        this.st_cartoon = st_cartoon;
    }
    @Override
    public String toString() {
        return "TopicItem [st_id=" + st_id + ", st_name=" + st_name
                + ", st_pic=" + st_pic + ", st_content=" + st_content
                + ", st_type=" + st_type + ", st_num=" + st_num
                + ", st_status=" + st_status + ", st_url=" + st_url
                + ", st_cartoon=" + st_cartoon + ", c_id=" + c_id
                + ", frontcover=" + frontcover + ", author_name=" + author_name
                + ", t_id=" + t_id + ", popularity=" + popularity
                + ", frontcover_small=" + frontcover_small + ", c_status_name="
                + c_status_name + ", t_name=" + t_name + ", c_status="
                + c_status + ", c_name=" + c_name + "]";
    }


}
