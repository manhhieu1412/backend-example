package connection;

import java.sql.Connection;
import java.sql.Statement;

public class CreateStatement {
    public static void createTable() {
        Connection connection = JBDCConnection.getJBDCConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "create table Person(id INT, name CHAR)";
            int rs = statement.executeUpdate(sql);
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteTabale(){
        Connection connection = JBDCConnection.getJBDCConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "drop table Person";
            int rs = statement.executeUpdate(sql);
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        createTable();
//        deleteTabale();
    }
}
