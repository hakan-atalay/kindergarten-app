package DAO;

import entity.Ogretmenler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class OgretmenlerDAO extends DBConnection {

    public Ogretmenler getById(int id) {
        Ogretmenler ogr = null;
        try {
            PreparedStatement st = this.connect().prepareStatement("select * from ogretmenler where ogretmen_id = " + id);
            ResultSet rs = st.executeQuery();
            rs.next();
            ogr = new Ogretmenler();

            ogr.setOgretmen_id(rs.getInt("ogretmen_id"));
            ogr.setOgretmen_ad(rs.getString("ogretmen_ad"));
            ogr.setOgretmen_soyad(rs.getString("ogretmen_soyad"));
            ogr.setOgretmen_tel(rs.getString("ogretmen_tel"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ogr;
    }

    public void insert(Ogretmenler ogretmen) {
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            st.executeUpdate("insert into ogretmenler (ogretmen_ad, ogretmen_soyad, ogretmen_tel) values ('" + ogretmen.getOgretmen_ad() + "', '" + ogretmen.getOgretmen_soyad() + "', '" + ogretmen.getOgretmen_tel() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Ogretmenler ogretmen) {
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            st.executeUpdate("update ogretmenler set ogretmen_ad='" + ogretmen.getOgretmen_ad() + "', ogretmen_soyad='" + ogretmen.getOgretmen_soyad() + "',  ogretmen_tel='" + ogretmen.getOgretmen_tel() + "' where ogretmen_id=" + ogretmen.getOgretmen_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Ogretmenler ogretmen) {
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            st.executeUpdate("delete from ogretmenler where ogretmen_id='" + ogretmen.getOgretmen_id() + "'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Ogretmenler> list(int page, int pageSize) {
        List<Ogretmenler> listele = new ArrayList();

        int start = (page - 1) * pageSize;
        try {
            Connection c = this.connect();
            PreparedStatement st = c.prepareStatement("select * from ogretmenler order by ogretmen_id asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Ogretmenler ogretmen = new Ogretmenler(rs.getInt("ogretmen_id"), rs.getString("ogretmen_ad"), rs.getString("ogretmen_soyad"), rs.getString("ogretmen_tel"));
                listele.add(ogretmen);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listele;
    }

    public List<Ogretmenler> list() {
        List<Ogretmenler> listele = new ArrayList();

        try {
            Connection c = this.connect();
            PreparedStatement st = c.prepareStatement("select * from ogretmenler");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Ogretmenler ogretmen = new Ogretmenler(rs.getInt("ogretmen_id"), rs.getString("ogretmen_ad"), rs.getString("ogretmen_soyad"), rs.getString("ogretmen_tel"));
                listele.add(ogretmen);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listele;
    }

    public int count() {

        int count = 0;

        try {
            Connection c = this.connect();
            PreparedStatement st = c.prepareStatement("select count(ogretmen_id) ogretmenler_count from ogretmenler");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("ogretmenler_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
}
