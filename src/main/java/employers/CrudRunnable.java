package employers;

import utils.DBConnection;
import utils.Logger;
import utils.ReadProperties;

import java.io.IOException;
import java.sql.*;

public abstract class CrudRunnable implements Runnable {

    private static ReadProperties readProperties;
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static Logger L = Logger.getInstance();

    public CrudRunnable() throws SQLException {
    }

    abstract void create() throws IOException, SQLException;

    abstract void select() throws IOException, SQLException;

    abstract void update();

    abstract void insert();

    abstract void delete();

    abstract void selectCount() throws IOException, SQLException;

    public void estabilishedConnection() throws SQLException {
        statement = DBConnection.connect();
    }

    public String readProp(String fileName, String key) throws IOException {
        readProperties = new ReadProperties();
        readProperties.read(fileName);
        return readProperties.getProperties().getProperty(key);
    }

//    public void createTable() throws IOException, SQLException {
//        String sql = readProp("sql.properties", "createtable");
//        statement.executeUpdate(sql);
//    }

    public void print() throws SQLException {
        ResultSet resultSet = getStatement().getResultSet();
        ResultSetMetaData md = resultSet.getMetaData();

        while (resultSet.next()) {
            for (int i = 1; i <= md.getColumnCount(); i++) {
                md.getColumnName(i);
                getL().debug(resultSet.getString(i));
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public ReadProperties getReadProperties() {
        return readProperties;
    }

    public Logger getL() {
        return L;
    }
}