import utils.DBConnection;

import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws SQLException {
        Statement statement = DBConnection.connect();
    }
}
