package android.hcartoon.bean;

/**
 * Created by Lenovo on 2015/12/4.
 */
public class Sort {

    /**
     * id,Í¼Æ¬£¬Ãû×Ö
     */
    private String t_id;
    private String t_name;
    private String t_pic;

    public Sort(){
        super();
    }

    public Sort(String t_id,String t_name,String t_pic){
        super();
        this.t_id = t_id;
        this.t_name = t_name;
        this.t_pic = t_pic;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_pic() {
        return t_pic;
    }

    public void setT_pic(String t_pic) {
        this.t_pic = t_pic;
    }
}
