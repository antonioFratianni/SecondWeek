package olympic;

import utils.DBConnection;
import utils.ReadProperties;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws SQLException, IOException {

         ReadProperties readProperties = new ReadProperties();
        AthleteOperations athlete = new AthleteOperations();

        DBConnection.connect();
        readProperties.read("sql.properties");

        String sql1 = (readProperties.getProperties().getProperty("create.athlete.table"));
        athlete.persistence(sql1);

//        String sql2 = (readProperties.getProperties().getProperty("insert.athlete"));
//        athlete.persistence(sql2);

        athlete.findByPk(1);

        List rows = athlete.findAthletesTallerThan(1.9);
        System.out.println(rows.isEmpty());
        rows.forEach(System.out::println);

        DBConnection.close();
    }
}
