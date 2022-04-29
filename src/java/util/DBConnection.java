package util;

import java.sql.*;

public abstract class DBConnection {

    public Connection connect() throws SQLException {

        Connection connection = null;
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kresyonetimi", "postgres", "123456");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return connection;
    }

}
