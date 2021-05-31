package Bean;

public class TeachPlan  extends StudyClass{
        private int id;
        private int kip;
        private String tenbaihoc;
        private String loai;
        private String ghichu;
        private int lophoc_id;

        public TeachPlan(){

        }

    public TeachPlan(int kip,String tenbaihoc, String loai, String ghichu,int lophoc_id) {
        this.kip = kip;
        this.tenbaihoc = tenbaihoc;
        this.loai = loai;
        this.ghichu = ghichu;
        this.lophoc_id = lophoc_id;
    }
    public TeachPlan(int id,int kip,String tenbaihoc, String loai, String ghichu,int lophoc_id) {
        this.id = id;
        this.kip = kip;
        this.tenbaihoc = tenbaihoc;
        this.loai = loai;
        this.ghichu = ghichu;
        this.lophoc_id = lophoc_id;
    }

    public int getLophoc_id() {
        return lophoc_id;
    }

    public void setLophoc_id(int lophoc_id) {
        this.lophoc_id = lophoc_id;
    }

    public int getKip() {
        return kip;
    }

    public void setKip(int kip) {
        this.kip = kip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenbaihoc() {
        return tenbaihoc;
    }

    public void setTenbaihoc(String tenbaihoc) {
        this.tenbaihoc = tenbaihoc;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
