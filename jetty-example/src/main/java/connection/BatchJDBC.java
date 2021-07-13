package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchJDBC {
    public static void main(String[] args) throws SQLException {
        Connection connection = JBDCConnection.getJBDCConnection();

        String st1 = "INSERT INTO Person(id,name) VALUES (5,'Q')";
        String st2 = "DELETE FROM Person WHERE id = 2";
        String st3 = "UPDATE Person SET name = 'V' WHERE id = 3";

        Statement statement = connection.createStatement();
        statement.addBatch(st1);
        statement.addBatch(st2);
        statement.addBatch(st3);

//        statement.executeBatch();

        String st4 = "INSERT INTO Person(id,name) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(st4);
        preparedStatement.setInt(1, 6);
        preparedStatement.setString(2, "F");
        preparedStatement.addBatch();

        preparedStatement.setInt(1, 7);
        preparedStatement.setString(2, "Z");
        preparedStatement.addBatch();

        preparedStatement.setInt(1, 8);
        preparedStatement.setString(2, "X");
        preparedStatement.addBatch();

        preparedStatement.executeBatch();
    }
}
