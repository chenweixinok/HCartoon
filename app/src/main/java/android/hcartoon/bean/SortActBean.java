package android.hcartoon.bean;

/**
 * Created by Lenovo on 2015/12/4.
 */
public class SortActBean {

    private String img;
    private String title;
    private String author;
    private String introduction;
    private String cid;

    public SortActBean(){
        super();
    }

    public SortActBean(String img, String title, String author, String introduction, String cid){

        super();
        this.img = img;
        this.introduction = introduction;
        this.title = title;
        this.author = author;
        this.cid = cid;

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
