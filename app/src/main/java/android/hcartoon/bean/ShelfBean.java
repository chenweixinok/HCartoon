package android.hcartoon.bean;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Table;

/**
 * Created by Lenovo on 2015/11/25.
 */
@Table(name = "collection")
public class ShelfBean {

    @Column(column = "id")
    int id;
    @Column(column = "cid")
    String cid;
    @Column(column = "title")
    String title;
    @Column(column = "author")
    String author;
    @Column(column = "pop")
    String popularity;// ÈËÆø
    @Column(column = "img")
    String img;

    public ShelfBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ShelfBean(int id, String cid, String title, String author,
                     String pop, String img) {
        super();
        this.id = id;
        this.cid = cid;
        this.title = title;
        this.author = author;
        this.popularity = pop;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
