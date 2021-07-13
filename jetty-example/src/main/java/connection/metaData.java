package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class metaData {
    public static void main(String[] args) {
        Connection connection = JBDCConnection.getJBDCConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM customers";
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println(metaData.getClass());
            System.out.println(metaData.getColumnTypeName(2));
            System.out.println(metaData.getCatalogName(2));
            System.out.println(metaData.getColumnLabel(2));
        } catch (Exception e){
            System.out.println(e);
        }

    }
}
