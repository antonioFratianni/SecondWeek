package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnector {
    private static DBConnector connector;
    private Connection connection;
    public static final String DB_USER = "root",
            DB_PWD = "frateseven",
            DB_URL = "jdbc:mysql://localhost/JDBC?",
            DB_CLASS = "com.mysql.cj.jdbc.Driver";

    private DBConnector() {
        createConnection();
        connector = this;
    }

    private void createConnection() {
        if (connection == null) {
            try {
                Class.forName(DB_CLASS).getDeclaredConstructor().newInstance();
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static DBConnector getIstance() {
        if (connector == null)
            connector = new DBConnector();
        return connector;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public PreparedStatement getPreparedStatement(String s) throws SQLException {
        return connection.prepareStatement(s);
    }

    public static void main(String[] args) {
        DBConnector dbConnector = new DBConnector();
        dbConnector.createConnection();
    }
}
