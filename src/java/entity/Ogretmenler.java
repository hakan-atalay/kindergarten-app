package entity;

public class Ogretmenler {

    private int ogretmen_id;
    private String ogretmen_ad;
    private String ogretmen_soyad;
    private String ogretmen_tel;

    public Ogretmenler() {
    }

    public Ogretmenler(int ogretmen_id, String ogretmen_ad, String ogretmen_soyad, String ogretmen_tel) {
        this.ogretmen_id = ogretmen_id;
        this.ogretmen_ad = ogretmen_ad;
        this.ogretmen_soyad = ogretmen_soyad;
        this.ogretmen_tel = ogretmen_tel;
    }

    public int getOgretmen_id() {
        return ogretmen_id;
    }

    public void setOgretmen_id(int ogretmen_id) {
        this.ogretmen_id = ogretmen_id;
    }

    public String getOgretmen_ad() {
        return ogretmen_ad;
    }

    public void setOgretmen_ad(String ogretmen_ad) {
        this.ogretmen_ad = ogretmen_ad;
    }

    public String getOgretmen_soyad() {
        return ogretmen_soyad;
    }

    public void setOgretmen_soyad(String ogretmen_soyad) {
        this.ogretmen_soyad = ogretmen_soyad;
    }

    public String getOgretmen_tel() {
        return ogretmen_tel;
    }

    public void setOgretmen_tel(String ogretmen_tel) {
        this.ogretmen_tel = ogretmen_tel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.ogretmen_id;
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
        final Ogretmenler other = (Ogretmenler) obj;
        if (this.ogretmen_id != other.ogretmen_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ogretmenler{" + "ogretmen_id=" + ogretmen_id + ", ogretmen_ad=" + ogretmen_ad + ", ogretmen_soyad=" + ogretmen_soyad + ", ogretmen_tel=" + ogretmen_tel + '}';
    }

}
