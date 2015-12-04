package android.hcartoon.bean;

/**
 * Created by Lenovo on 2015/11/18.
 */
public class Recommend {
    private String img_url;
    private String title;
    private String chapter;
    private String cid;

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Recommend() {

        super();
        // TODO Auto-generated constructor stub
    }

    public Recommend(String img_url, String title, String chapter, String cid) {
        super();
        this.img_url = img_url;
        this.title = title;
        this.chapter = chapter;
        this.cid = cid;
    }
}
