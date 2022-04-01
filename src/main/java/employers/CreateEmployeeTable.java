package employers;

import java.io.IOException;
import java.sql.SQLException;

public class CreateEmployeeTable extends CrudRunnable{

    private String sql;
    public CreateEmployeeTable() throws SQLException {
    }

    @Override
    void create() throws IOException, SQLException {
        sql = readProp("sql.properties", "select.brand.revenue");
        getStatement().executeQuery(sql);

    }

    @Override
    void select() throws IOException, SQLException {

    }

    @Override
    void update() {

    }

    @Override
    void insert() {

    }

    @Override
    void delete() {

    }

    @Override
    void selectCount() throws IOException, SQLException {

    }

    @Override
    public void run() {

    }
}
