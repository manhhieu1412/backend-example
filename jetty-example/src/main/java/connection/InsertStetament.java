package connection;

import java.sql.Connection;
import java.sql.Statement;

public class InsertStetament {
    public static void insertRecords(int id, String name) {
        Connection connection = JBDCConnection.getJBDCConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO Person(id, name) VALUES (" + id + "," + "'" + name + "')";
            System.out.println(sql);
            int rs = statement.executeUpdate(sql);
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateRecords(int id, String newName) {
        Connection connection = JBDCConnection.getJBDCConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "UPDATE Person SET name = " + "'" + newName + "'" + "WHERE id = " + id;
            System.out.println(sql);
            int rs = statement.executeUpdate(sql);
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteRecord(int id) {
        Connection connection = JBDCConnection.getJBDCConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM Person WHERE id = " + id;
            int rs = statement.executeUpdate(sql);
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        insertRecords(2, "H");
//        insertRecords(3, "I");
//        updateRecords(1, "K");
//        deleteRecord(2);

    }
}
