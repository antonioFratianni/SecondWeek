import hibernate.HibernateUtilTest;


import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        HibernateUtilTest hibernateUtilTest = new HibernateUtilTest();
        HibernateUtilTest.setup();
        hibernateUtilTest.testCreate();
        hibernateUtilTest.closeSession();
        HibernateUtilTest.tearDown();
    }
}
