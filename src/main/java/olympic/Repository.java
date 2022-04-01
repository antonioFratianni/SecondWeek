package olympic;

import java.sql.SQLException;
import java.util.List;

public interface Repository <T>{

     void persistence(T o) throws SQLException;

     void delete(T o);

     void update(T o);

     void findByPk (int id) throws SQLException;

     List<T> findAll ();

     void close() throws SQLException;
}
