package DAO;

import entity.Personeller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class PersonellerDAO extends DBConnection {

    public void insert(Personeller personel) {
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            st.executeUpdate("insert into personeller (personel_ad, personel_soyad, personel_tel) values ('" + personel.getPersonel_ad() + "', '" + personel.getPersonel_soyad() + "', '" + personel.getPersonel_tel() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Personeller personel) {
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            st.executeUpdate("update personeller set personel_ad='" + personel.getPersonel_ad() + "', personel_soyad='" + personel.getPersonel_soyad() + "',  personel_tel='" + personel.getPersonel_tel() + "' where personel_id=" + personel.getPersonel_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Personeller personel) {
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            st.executeUpdate("delete from personeller where personel_id='" + personel.getPersonel_id() + "'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Personeller> list(int page, int pageSize) {
        List<Personeller> listele = new ArrayList();

        int start = (page - 1) * pageSize;
        try {
            Connection c = this.connect();
            PreparedStatement st = c.prepareStatement("select * from personeller order by personel_id asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Personeller personel = new Personeller(rs.getInt("personel_id"), rs.getString("personel_ad"), rs.getString("personel_soyad"), rs.getString("personel_tel"));
                listele.add(personel);
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
            PreparedStatement st = c.prepareStatement("select count(personel_id) personeller_count from personeller");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("personeller_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
}
