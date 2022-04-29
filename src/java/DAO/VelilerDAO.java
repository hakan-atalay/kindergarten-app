package DAO;

import entity.Veliler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class VelilerDAO extends DBConnection {

    public void insert(Veliler veli) {
        try {
            Connection c = this.connect();
            PreparedStatement st = c.prepareStatement("insert into veliler (veli_ad, veli_soyad, veli_tel, veli_tc) values (?,?,?,?)");
            st.setString(1, veli.getVeli_ad());
            st.setString(2, veli.getVeli_soyad());
            st.setString(3, veli.getVeli_tel());
            st.setString(4, veli.getVeli_tc());
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Veliler veli) {
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            st.executeUpdate("update veliler set veli_ad='" + veli.getVeli_ad() + "', veli_soyad='" + veli.getVeli_soyad() + "',  veli_tel='" + veli.getVeli_tel() + "', veli_tc='" + veli.getVeli_tc() + "' where veli_id=" + veli.getVeli_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Veliler veli) {
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            st.executeUpdate("delete from veliler where veli_id='" + veli.getVeli_id() + "'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Veliler> list(int page, int pageSize) {
        List<Veliler> listele = new ArrayList();

        int start = (page - 1) * pageSize;
        try {
            Connection c = this.connect();
            PreparedStatement st = c.prepareStatement("select * from veliler order by veli_id asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Veliler veli = new Veliler(rs.getInt("veli_id"), rs.getString("veli_ad"), rs.getString("veli_soyad"), rs.getString("veli_tel"), rs.getString("veli_tc"));
                listele.add(veli);
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
            PreparedStatement st = c.prepareStatement("select count(veli_id) as veliler_count from veliler");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("veliler_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
}
