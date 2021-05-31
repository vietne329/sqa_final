package Bean;

public class StudyClass {
    private int id;
    private String tenlop;
    private String tenmonhoc;
    private int sotin;
    private int sokip;
    private int sokiplythuyet;
    private int sokipthuchanh;
    private String thoigian;

    public StudyClass(){

    }

    public StudyClass(int id, String tenlop, String tenmonhoc, int sotin, int sokip, int sokiplythuyet, int sokipthuchanh, String thoigian) {
        this.id = id;
        this.tenlop = tenlop;
        this.tenmonhoc = tenmonhoc;
        this.sotin = sotin;
        this.sokip = sokip;
        this.sokiplythuyet = sokiplythuyet;
        this.sokipthuchanh = sokipthuchanh;
        this.thoigian = thoigian;
    }

    public StudyClass(String tenlop, String tenmonhoc, int sotin, int sokip, int sokiplythuyet, int sokipthuchanh, String thoigian) {
        this.tenlop = tenlop;
        this.tenmonhoc = tenmonhoc;
        this.sotin = sotin;
        this.sokip = sokip;
        this.sokiplythuyet = sokiplythuyet;
        this.sokipthuchanh = sokipthuchanh;
        this.thoigian = thoigian;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenlop() {
        return tenlop;
    }

    public int getSotin() {
        return sotin;
    }

    public void setSotin(int sotin) {
        this.sotin = sotin;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getTenmonhoc() {
        return tenmonhoc;
    }

    public void setTenmonhoc(String tenmonhoc) {
        this.tenmonhoc = tenmonhoc;
    }

    public int getSokip() {
        return sokip;
    }

    public void setSokip(int sokip) {
        this.sokip = sokip;
    }

    public int getSokiplythuyet() {
        return sokiplythuyet;
    }

    public void setSokiplythuyet(int sokiplythuyet) {
        this.sokiplythuyet = sokiplythuyet;
    }

    public int getSokipthuchanh() {
        return sokipthuchanh;
    }

    public void setSokipthuchanh(int sokipthuchanh) {
        this.sokipthuchanh = sokipthuchanh;
    }
}
