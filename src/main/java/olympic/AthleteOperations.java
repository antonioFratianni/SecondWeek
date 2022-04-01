package olympic;

import utils.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.DBConnection.getConnection;
import static utils.DBConnection.getStatement;

public class AthleteOperations implements Repository<String> {

    @Override
    public void persistence(String sql) throws SQLException {
        getStatement().executeUpdate(sql);
    }

    @Override
    public void delete(String sql) {

    }

    @Override
    public void update(String sql) {

    }

    @Override
    public void findByPk(int id) throws SQLException {
        PreparedStatement pstmt = getConnection().prepareStatement("SELECT * from olympic.athlete where id = ?");
        {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            print(rs);
        }
    }

    @Override
    public List<String> findAll() {
        return null;
    }
    public List findAthletesTallerThan(double h) throws SQLException {
        ResultSet rs;
        PreparedStatement pstmt = getConnection().prepareStatement("SELECT * from olympic.athlete where height >?");
        {
            pstmt.setDouble(1, h);
             rs = pstmt.executeQuery();
            print(rs);
        }
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<Map<String, Object>> rows = new ArrayList<>();
        while (rs.next()){
            Map<String, Object> row = new HashMap<>(columns);
            for(int i = 1; i <= columns; ++i){
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            rows.add(row);
        }
        return rows;
    }

    @Override
    public void close() throws SQLException {
        DBConnection.close();

    }

    public void print(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(" | ");
                System.out.print(rs.getString(i));
            }
            System.out.println("");
        }
    }
}
