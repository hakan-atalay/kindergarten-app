package entity;

public class Ogrenciler {

    private int ogrenci_id;
    private String ogrenci_tc;
    private String ogrenci_ad;
    private String ogrenci_soyad;
    private String ogrenci_adres;
    private int ogrenci_yas;
    private Ogretmenler ogretmen;

    public Ogrenciler() {
    }

    public Ogrenciler(int ogrenci_id, String ogrenci_tc, String ogrenci_ad, String ogrenci_soyad, String ogrenci_adres, int ogrenci_yas) {
        this.ogrenci_id = ogrenci_id;
        this.ogrenci_tc = ogrenci_tc;
        this.ogrenci_ad = ogrenci_ad;
        this.ogrenci_soyad = ogrenci_soyad;
        this.ogrenci_adres = ogrenci_adres;
        this.ogrenci_yas = ogrenci_yas;

    }

    public int getOgrenci_id() {
        return ogrenci_id;
    }

    public void setOgrenci_id(int ogrenci_id) {
        this.ogrenci_id = ogrenci_id;
    }

    public String getOgrenci_tc() {
        return ogrenci_tc;
    }

    public void setOgrenci_tc(String ogrenci_tc) {
        this.ogrenci_tc = ogrenci_tc;
    }

    public String getOgrenci_ad() {
        return ogrenci_ad;
    }

    public void setOgrenci_ad(String ogrenci_ad) {
        this.ogrenci_ad = ogrenci_ad;
    }

    public String getOgrenci_soyad() {
        return ogrenci_soyad;
    }

    public void setOgrenci_soyad(String ogrenci_soyad) {
        this.ogrenci_soyad = ogrenci_soyad;
    }

    public String getOgrenci_adres() {
        return ogrenci_adres;
    }

    public void setOgrenci_adres(String ogrenci_adres) {
        this.ogrenci_adres = ogrenci_adres;
    }

    public int getOgrenci_yas() {
        return ogrenci_yas;
    }

    public void setOgrenci_yas(int ogrenci_yas) {
        this.ogrenci_yas = ogrenci_yas;
    }

    public Ogretmenler getOgretmen() {
        return ogretmen;
    }

    public void setOgretmen(Ogretmenler ogretmen) {
        this.ogretmen = ogretmen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.ogrenci_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ogrenciler other = (Ogrenciler) obj;
        if (this.ogrenci_id != other.ogrenci_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ogrenciler{" + "ogrenci_id=" + ogrenci_id + ", ogrenci_tc=" + ogrenci_tc + ", ogrenci_ad=" + ogrenci_ad + ", ogrenci_soyad=" + ogrenci_soyad + ", ogrenci_adres=" + ogrenci_adres + ", ogrenci_yas=" + ogrenci_yas + ", ogretmen=" + ogretmen + '}';
    }

}
