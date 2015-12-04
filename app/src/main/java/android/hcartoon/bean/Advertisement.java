package android.hcartoon.bean;

/**
 * Created by Lenovo on 2015/11/18.
 */
public class Advertisement {


    /**
     * 封装图片的链接 标题 ID
     */
    private String img_url;
    private String title;
    private String cid;

    public Advertisement(){
        super();
    }

    public Advertisement(String img_url,String title, String cid){

        super();
        this.img_url = img_url;
        this.title = title;
        this.cid = cid;
    }

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

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Advertisement [img_url =" + img_url
                + ", title=" + title + ", cid="+ cid + "]";
    }
}
