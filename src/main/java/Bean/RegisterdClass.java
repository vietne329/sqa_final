package Bean;

public class RegisterdClass {
    private int id;
    private int giaovien_id;
    private int class_id;

    public RegisterdClass() {
    }

    public RegisterdClass(int id, int giaovien_id, int class_id) {
        this.id = id;
        this.giaovien_id = giaovien_id;
        this.class_id = class_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGiaovien_id() {
        return giaovien_id;
    }

    public void setGiaovien_id(int giaovien_id) {
        this.giaovien_id = giaovien_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }
}
