package entity;

import java.sql.Date;

public class Etkinlikler {

    private int etkinlik_id;
    private String etkinlik_ad;
    private String etkinlik_tarih;

    public Etkinlikler() {
    }

    public Etkinlikler(int etkinlik_id, String etkinlik_ad, String etkinlik_tarih) {
        this.etkinlik_id = etkinlik_id;
        this.etkinlik_ad = etkinlik_ad;
        this.etkinlik_tarih = etkinlik_tarih;
    }

    public int getEtkinlik_id() {
        return etkinlik_id;
    }

    public void setEtkinlik_id(int etkinlik_id) {
        this.etkinlik_id = etkinlik_id;
    }

    public String getEtkinlik_ad() {
        return etkinlik_ad;
    }

    public void setEtkinlik_ad(String etkinlik_ad) {
        this.etkinlik_ad = etkinlik_ad;
    }

    public String getEtkinlik_tarih() {
        return etkinlik_tarih;
    }

    public void setEtkinlik_tarih(String etkinlik_tarih) {
        this.etkinlik_tarih = etkinlik_tarih;
    }

}
