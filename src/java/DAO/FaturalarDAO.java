package DAO;

import entity.Faturalar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class FaturalarDAO extends DBConnection {

    public void insert(Faturalar fatura) {
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            st.executeUpdate("insert into faturalar (fatura_turu, fatura_odeme, fatura_tutar) values ('" + fatura.getFatura_turu() + "', '" + fatura.getFatura_odeme() + "', '" + fatura.getFatura_tutar() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Faturalar fatura) {
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            st.executeUpdate("update faturalar set fatura_turu='" + fatura.getFatura_turu() + "', fatura_odeme='" + fatura.getFatura_odeme() + "',  fatura_tutar='" + fatura.getFatura_tutar() + "' where fatura_id=" + fatura.getFatura_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Faturalar fatura) {
        try {
            Connection c = this.connect();
            Statement st = c.createStatement();
            st.executeUpdate("delete from faturalar where fatura_id='" + fatura.getFatura_id() + "'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Faturalar> list(int page, int pageSize) {
        List<Faturalar> listele = new ArrayList();

        int start = (page - 1) * pageSize;
        try {
            Connection c = this.connect();
            PreparedStatement st = c.prepareStatement("select * from faturalar order by fatura_id asc limit " + start + "," + pageSize);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Faturalar fatura = new Faturalar(rs.getInt("fatura_id"), rs.getString("fatura_turu"), rs.getString("fatura_odeme"), rs.getDouble("fatura_tutar"));
                listele.add(fatura);
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
            PreparedStatement st = c.prepareStatement("select count(fatura_id) as faturalar_count from faturalar");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("faturalar_count");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
}
