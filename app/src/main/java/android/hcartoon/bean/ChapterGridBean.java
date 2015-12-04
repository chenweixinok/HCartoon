package android.hcartoon.bean;

/**
 * 章节列表 gridview 数据javabean
 * Created by Lenovo on 2015/11/25.
 */
public class ChapterGridBean implements Comparable{

    private String cid;// 书籍id
    private String ccid;// 章节id
    private String ccname;// 章节名字
    private boolean isChecked;// 是否选中，默认false

    public ChapterGridBean(){
        super();
    }

    public ChapterGridBean(String cid,String ccid,String ccname){
        super();
        this.cid = cid;
        this.ccid = ccid;
        this.ccname = ccname;
    }

    public boolean isChecked(){
        return isChecked;
    }

    public void setChecked(boolean isChecked){
        this.isChecked = isChecked;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCcname() {
        return ccname;
    }

    public void setCcname(String ccname) {
        this.ccname = ccname;
    }

    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((ccid == null)? 0 : ccid.hashCode());
        result = prime * result + ((ccname == null)? 0 : ccname.hashCode());
        result = prime * result + ((cid == null)? 0 : cid.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (getClass() != o.getClass()){
            return false;
        }
        ChapterGridBean other = (ChapterGridBean) o;
        if (ccid == null) {
            if (other.ccid != null)
                return false;
        } else if (!ccid.equals(other.ccid))
            return false;
        if (ccname == null) {
            if (other.ccname != null)
                return false;
        } else if (!ccname.equals(other.ccname))
            return false;
        if (cid == null) {
            if (other.cid != null)
                return false;
        } else if (!cid.equals(other.cid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ChapterGridBean [cid=" + cid + ", ccid=" + ccid + ", ccname="
                + ccname + "]";
    }

    @Override
    public int compareTo(Object another) {
        if (another instanceof ChapterGridBean) {
            int thisCcid = Integer.valueOf(this.ccid);
            ChapterGridBean cg = (ChapterGridBean) another;
            int aCcid = Integer.valueOf(cg.getCcid());
            return thisCcid - aCcid;
        }
        return 0;
    }

}
