package android.hcartoon.bean;

/**
 * Created by Lenovo on 2015/12/4.
 */
public class Topic {

    private String st_id;
    private String st_name;
    private String st_logo;
    private String st_num;
    private String st_order;
    private String hits;
    private String st_type;
    private String st_url;

    public Topic() {
        super();
    }

    public Topic(String st_id, String st_name, String st_logo,
                     String st_num, String st_order, String hits, String st_type,
                     String st_url) {
        super();
        this.st_id = st_id;
        this.st_name = st_name;
        this.st_logo = st_logo;
        this.st_num = st_num;
        this.st_order = st_order;
        this.hits = hits;
        this.st_type = st_type;
        this.st_url = st_url;
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
    public String getSt_logo() {
        return st_logo;
    }
    public void setSt_logo(String st_logo) {
        this.st_logo = st_logo;
    }
    public String getSt_num() {
        return st_num;
    }
    public void setSt_num(String st_num) {
        this.st_num = st_num;
    }
    public String getSt_order() {
        return st_order;
    }
    public void setSt_order(String st_order) {
        this.st_order = st_order;
    }
    public String getHits() {
        return hits;
    }
    public void setHits(String hits) {
        this.hits = hits;
    }
    public String getSt_type() {
        return st_type;
    }
    public void setSt_type(String st_type) {
        this.st_type = st_type;
    }
    public String getSt_url() {
        return st_url;
    }
    public void setSt_url(String st_url) {
        this.st_url = st_url;
    }

    @Override
    public String toString() {
        return "Topic_List [st_id=" + st_id + ", st_name=" + st_name
                + ", st_logo=" + st_logo + ", st_num=" + st_num + ", st_order="
                + st_order + ", hits=" + hits + ", st_type=" + st_type
                + ", st_url=" + st_url + "]";
    }
}
