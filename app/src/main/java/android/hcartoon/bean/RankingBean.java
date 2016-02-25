package android.hcartoon.bean;

/**
 * Created by Lenovo on 2016/2/24.
 */
/**
 * ����ģ��ʵ����
 *
 * @author Administrator
 *
 */
public class RankingBean implements Comparable {
    private String c_id; // ��ƷID
    private String c_name;// ��Ʒ����
    private String c_status;//
    private String image_big;// ��ͼ ��Ӧjson��frontcover
    private String author_name;// ��������
    private String t_id;// ����ID
    private String popularity;// ����
    private String collevtion;// �ղ�
    private String image_small;// Сͼ ��Ӧjson��frontcover_small
    private String c_status_name;// ����״̬
    private String t_name;// ��������

    /**
     * �޲ι��췽��
     */
    public RankingBean() {
        super();
    }

    /**
     * �вι��췽��
     *
     * @param c_id
     *            ��ƷID
     * @param c_name
     *            ��Ʒ����
     * @param c_status
     * @param image_big
     *            ��ͼ
     * @param author_name
     *            ��������
     * @param t_id
     *            ����ID
     * @param popularity
     *            ����
     * @param collevtion
     *            �ղ�
     * @param image_small
     *            Сͼ
     * @param c_status_name
     *            ����״̬
     * @param t_name
     *            ��������
     */
    public RankingBean(String c_id, String c_name, String c_status,
                       String image_big, String author_name, String t_id,
                       String popularity, String collevtion, String image_small,
                       String c_status_name, String t_name) {
        super();
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_status = c_status;
        this.image_big = image_big;
        this.author_name = author_name;
        this.t_id = t_id;
        this.popularity = popularity;
        this.collevtion = collevtion;
        this.image_small = image_small;
        this.c_status_name = c_status_name;
        this.t_name = t_name;
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

    public String getC_status() {
        return c_status;
    }

    public void setC_status(String c_status) {
        this.c_status = c_status;
    }

    public String getImage_big() {
        return image_big;
    }

    public void setImage_big(String image_big) {
        this.image_big = image_big;
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

    public String getCollevtion() {
        return collevtion;
    }

    public void setCollevtion(String collevtion) {
        this.collevtion = collevtion;
    }

    public String getImage_small() {
        return image_small;
    }

    public void setImage_small(String image_small) {
        this.image_small = image_small;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((author_name == null) ? 0 : author_name.hashCode());
        result = prime * result + ((c_id == null) ? 0 : c_id.hashCode());
        result = prime * result + ((c_name == null) ? 0 : c_name.hashCode());
        result = prime * result
                + ((c_status == null) ? 0 : c_status.hashCode());
        result = prime * result
                + ((c_status_name == null) ? 0 : c_status_name.hashCode());
        result = prime * result
                + ((collevtion == null) ? 0 : collevtion.hashCode());
        result = prime * result
                + ((image_big == null) ? 0 : image_big.hashCode());
        result = prime * result
                + ((image_small == null) ? 0 : image_small.hashCode());
        result = prime * result
                + ((popularity == null) ? 0 : popularity.hashCode());
        result = prime * result + ((t_id == null) ? 0 : t_id.hashCode());
        result = prime * result + ((t_name == null) ? 0 : t_name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RankingBean other = (RankingBean) obj;
        if (author_name == null) {
            if (other.author_name != null)
                return false;
        } else if (!author_name.equals(other.author_name))
            return false;
        if (c_id == null) {
            if (other.c_id != null)
                return false;
        } else if (!c_id.equals(other.c_id))
            return false;
        if (c_name == null) {
            if (other.c_name != null)
                return false;
        } else if (!c_name.equals(other.c_name))
            return false;
        if (c_status == null) {
            if (other.c_status != null)
                return false;
        } else if (!c_status.equals(other.c_status))
            return false;
        if (c_status_name == null) {
            if (other.c_status_name != null)
                return false;
        } else if (!c_status_name.equals(other.c_status_name))
            return false;
        if (collevtion == null) {
            if (other.collevtion != null)
                return false;
        } else if (!collevtion.equals(other.collevtion))
            return false;
        if (image_big == null) {
            if (other.image_big != null)
                return false;
        } else if (!image_big.equals(other.image_big))
            return false;
        if (image_small == null) {
            if (other.image_small != null)
                return false;
        } else if (!image_small.equals(other.image_small))
            return false;
        if (popularity == null) {
            if (other.popularity != null)
                return false;
        } else if (!popularity.equals(other.popularity))
            return false;
        if (t_id == null) {
            if (other.t_id != null)
                return false;
        } else if (!t_id.equals(other.t_id))
            return false;
        if (t_name == null) {
            if (other.t_name != null)
                return false;
        } else if (!t_name.equals(other.t_name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RankingBean [c_id=" + c_id + ", c_name=" + c_name
                + ", c_status=" + c_status + ", image_big=" + image_big
                + ", author_name=" + author_name + ", t_id=" + t_id
                + ", popularity=" + popularity + ", collevtion=" + collevtion
                + ", image_small=" + image_small + ", c_status_name="
                + c_status_name + ", t_name=" + t_name + "]";
    }

    @Override
    public int compareTo(Object another) {
        if (another instanceof RankingBean) {
            RankingBean rb = (RankingBean) another;
            int thisNum = Integer.valueOf(this.popularity);
            int aNum = Integer.valueOf(rb.getPopularity());
            return aNum - thisNum;
        }

        return 0;
    }

}