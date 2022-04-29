package entity;

public class Faturalar {

    private int fatura_id;
    private String fatura_turu;
    private String fatura_odeme;
    private double fatura_tutar;

    public Faturalar() {
    }

    public Faturalar(int fatura_id, String fatura_turu, String fatura_odeme, double fatura_tutar) {
        this.fatura_id = fatura_id;
        this.fatura_turu = fatura_turu;
        this.fatura_odeme = fatura_odeme;
        this.fatura_tutar = fatura_tutar;
    }

    public int getFatura_id() {
        return fatura_id;
    }

    public void setFatura_id(int fatura_id) {
        this.fatura_id = fatura_id;
    }

    public String getFatura_turu() {
        return fatura_turu;
    }

    public void setFatura_turu(String fatura_turu) {
        this.fatura_turu = fatura_turu;
    }

    public String getFatura_odeme() {
        return fatura_odeme;
    }

    public void setFatura_odeme(String fatura_odeme) {
        this.fatura_odeme = fatura_odeme;
    }

    public double getFatura_tutar() {
        return fatura_tutar;
    }

    public void setFatura_tutar(double fatura_tutar) {
        this.fatura_tutar = fatura_tutar;
    }

}
