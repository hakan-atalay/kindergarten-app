package DAO;

import DAO.OgretmenlerDAO;
import entity.Ogrenciler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class OgrencilerDAO extends DBConnection {

    private DBConnection db;
    private OgretmenlerDAO ogrDao;

    public OgretmenlerDAO getOgrDao() {
        if (ogrDao == null) {
            this.ogrDao = new OgretmenlerDAO();
        }
        return ogrDao;
    }

    public void setOgrDao(OgretmenlerDAO ogrDao) {
        this.ogrDao = ogrDao;
    }

    public void insert(Ogrenciler ogrenci) {
        try {
            Connection c = this.connect();
            PreparedStatement st = c.prepareStatement("insert into ogrenciler (ogrenci_tc, ogrenci_ad, ogrenci_soyad, ogrenci_adres, ogrenci_yas, ogretmen_id) values (?,?,?,?,?,?)");
            st.setString(1, ogrenci.getOgrenci_tc());
            st.setString(2, ogrenci.getOgrenci_ad());
            st.setString(3, ogrenci.getOgrenci_soyad());
            st.setString(4, ogrenci.getOgrenci_adres());
            st.setInt(5, ogrenci.getOgrenci_yas());
            st.setInt(6, ogrenci.getOgretmen().getOgretmen_id());
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Ogrenciler ogrenci) {
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            st.executeUpdate("update ogrenciler set ogrenci_tc='" + ogrenci.getOgrenci_tc() + "', ogrenci_ad='" + ogrenci.getOgrenci_ad() + "', ogrenci_soyad='" + ogrenci.getOgrenci_soyad() + "', ogrenci_adres='" + ogrenci.getOgrenci_adres() + "', ogrenci_yas=" + ogrenci.getOgrenci_yas() + ", ogretmen_id='" + ogrenci.getOgretmen().getOgretmen_id() + "' where ogrenci_id=" + ogrenci.getOgrenci_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Ogrenciler ogrenci) {
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            st.executeUpdate("delete from ogrenciler where ogrenci_id='" + ogrenci.getOgrenci_id() + "'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Ogrenciler> list(int page, int pageSize) {
        List<Ogrenciler> listele = new ArrayList();

        int start = (page - 1) * pageSize;

        try {
            Connection c = this.connect();
            PreparedStatement st = c.prepareStatement("select * from ogrenciler order by ogrenci_id asc limit ? offset ?");
            st.setInt(1, pageSize);
            st.setInt(2, start);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Ogrenciler ogrenci = new Ogrenciler();
                ogrenci.setOgrenci_id(rs.getInt("ogrenci_id"));
                ogrenci.setOgrenci_tc(rs.getString("ogrenci_tc"));
                ogrenci.setOgrenci_ad(rs.getString("ogrenci_ad"));
                ogrenci.setOgrenci_soyad(rs.getString("ogrenci_soyad"));
                ogrenci.setOgrenci_adres(rs.getString("ogrenci_adres"));
                ogrenci.setOgrenci_yas(rs.getInt("ogrenci_yas"));
                ogrenci.setOgretmen(this.getOgrDao().getById(rs.getInt("ogretmen_id")));
                listele.add(ogrenci);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listele;
    }

    /*
    public List<Ogrenciler> list(){
        List<Ogrenciler> listele = new ArrayList();
        
        
        
       
        try{
            Connection c = this.getDb().connect();
            PreparedStatement st = c.prepareStatement("select * from ogrenciler");   
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Ogrenciler ogrenci = new Ogrenciler();
                ogrenci.setOgrenci_id(rs.getInt("ogrenci_id"));
                ogrenci.setOgrenci_tc(rs.getString("ogrenci_tc"));
                ogrenci.setOgrenci_ad(rs.getString("ogrenci_ad"));
                ogrenci.setOgrenci_soyad(rs.getString("ogrenci_soyad"));
                ogrenci.setOgrenci_adres(rs.getString("ogrenci_adres"));
                ogrenci.setOgrenci_yas(rs.getInt("ogrenci_yas"));
                ogrenci.setOgretmen(this.getOgrDao().getById(rs.getInt("ogretmen_id")));
                listele.add(ogrenci);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listele;
    }
     */
    public int count() {
        int count = 0;

        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select count(ogrenci_id) as ogrenci_count from ogrenciler ");
            rs.next();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return count;

    }

}
