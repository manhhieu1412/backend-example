package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

public class Transaction {
    public static void main(String[] args) throws SQLException {
        Connection connection = JBDCConnection.getJBDCConnection();

        Statement st = connection.createStatement();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO Person(id,name) VALUES(1,'O')";
        String sql1 = "DELETE FROM Person WHERE id = 2";

        st.executeUpdate(sql1);
        st.executeUpdate(sql);
        connection.commit();

    }
}
