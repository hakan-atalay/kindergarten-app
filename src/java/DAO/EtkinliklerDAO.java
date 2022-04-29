package DAO;

import entity.Etkinlikler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class EtkinliklerDAO extends DBConnection {

    public void insert(Etkinlikler etkinlik) {
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            st.executeUpdate("insert into etkinlikler (etkinlik_ad, etkinlik_tarih) values ('" + etkinlik.getEtkinlik_ad() + "', '" + etkinlik.getEtkinlik_tarih() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Etkinlikler etkinlik) {
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            st.executeUpdate("update etkinlikler set etkinlik_ad='" + etkinlik.getEtkinlik_ad() + "', etkinlik_tarih='" + etkinlik.getEtkinlik_tarih() + "' where etkinlik_id=" + etkinlik.getEtkinlik_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Etkinlikler etkinlik) {
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            st.executeUpdate("delete from etkinlikler where etkinlik_id='" + etkinlik.getEtkinlik_id() + "'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Etkinlikler> list(int page, int pageSize) {
        List<Etkinlikler> listele = new ArrayList();

        int start = (page - 1) * pageSize;
        try {
            Connection c = this.connect();
            PreparedStatement st = c.prepareStatement("select * from etkinlikler order by etkinlik_id asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Etkinlikler etkinlik = new Etkinlikler(rs.getInt("etkinlik_id"), rs.getString("etkinlik_ad"), rs.getString("etkinlik_tarih"));
                listele.add(etkinlik);
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
            PreparedStatement st = c.prepareStatement("select count(etkinlik_id) etkinlikler_count from etkinlikler");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("etkinlikler_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
}
