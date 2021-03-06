package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdatePrepare {
    public static void insertRecords(int id, String name) {
        Connection connection = JBDCConnection.getJBDCConnection();
        String sql = "INSERT INTO Person(id,name) VALUES(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void updateRecords(int id, String name) {
        Connection connection = JBDCConnection.getJBDCConnection();
        String sql = "UPDATE Person SET name = ? WHERE id = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteRecords(int id) {
        Connection connection = JBDCConnection.getJBDCConnection();
        String sql = "DELETE FROM Person WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        insertRecords(4, "M");
//        updateRecords(1, "W");
//        updateRecords(2,"E");
//        deleteRecords(2);
    }
}
