package entity;

public class Personeller {

    private int personel_id;
    private String personel_ad;
    private String personel_soyad;
    private String personel_tel;

    public Personeller() {
    }

    public Personeller(int personel_id, String personel_ad, String personel_soyad, String personel_tel) {
        this.personel_id = personel_id;
        this.personel_ad = personel_ad;
        this.personel_soyad = personel_soyad;
        this.personel_tel = personel_tel;
    }

    public int getPersonel_id() {
        return personel_id;
    }

    public void setPersonel_id(int personel_id) {
        this.personel_id = personel_id;
    }

    public String getPersonel_ad() {
        return personel_ad;
    }

    public void setPersonel_ad(String personel_ad) {
        this.personel_ad = personel_ad;
    }

    public String getPersonel_soyad() {
        return personel_soyad;
    }

    public void setPersonel_soyad(String personel_soyad) {
        this.personel_soyad = personel_soyad;
    }

    public String getPersonel_tel() {
        return personel_tel;
    }

    public void setPersonel_tel(String personel_tel) {
        this.personel_tel = personel_tel;
    }

}
