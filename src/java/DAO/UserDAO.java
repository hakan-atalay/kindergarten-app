package DAO;

import entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class UserDAO {

    private DBConnection db;

    public DBConnection getDb() {
        return db;
    }

    public void username() {
        User u1 = new User();
        try {
            Connection c = this.getDb().connect();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from kullanicilar");

            while (rs.next()) {
                String tmp = rs.getString("username");
                u1.setUsername(tmp);
                tmp = rs.getString("user_password");
                u1.setUser_password(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
