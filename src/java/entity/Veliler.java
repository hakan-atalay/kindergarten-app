package entity;

public class Veliler {

    private int veli_id;
    private String veli_ad;
    private String veli_soyad;
    private String veli_tel;
    private String veli_tc;

    public Veliler() {
    }

    public Veliler(int veli_id, String veli_ad, String veli_soyad, String veli_tel, String veli_tc) {
        this.veli_id = veli_id;
        this.veli_ad = veli_ad;
        this.veli_soyad = veli_soyad;
        this.veli_tel = veli_tel;
        this.veli_tc = veli_tc;
    }

    public int getVeli_id() {
        return veli_id;
    }

    public void setVeli_id(int veli_id) {
        this.veli_id = veli_id;
    }

    public String getVeli_ad() {
        return veli_ad;
    }

    public void setVeli_ad(String veli_ad) {
        this.veli_ad = veli_ad;
    }

    public String getVeli_soyad() {
        return veli_soyad;
    }

    public void setVeli_soyad(String veli_soyad) {
        this.veli_soyad = veli_soyad;
    }

    public String getVeli_tel() {
        return veli_tel;
    }

    public void setVeli_tel(String veli_tel) {
        this.veli_tel = veli_tel;
    }

    public String getVeli_tc() {
        return veli_tc;
    }

    public void setVeli_tc(String veli_tc) {
        this.veli_tc = veli_tc;
    }

}
