package connection;

import org.rythmengine.utils.S;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InnerJoin {
    public static void innerJoin() {
        Connection connection = JBDCConnection.getJBDCConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT orders.OrderID, customers.CustomerName, shippers.ShipperName " +
                    "FROM ((orders " +
                    "INNER JOIN customers ON orders.CustomerID = customers.CustomerID) " +
                    "INNER JOIN shippers ON orders.ShipperID = shippers.ShipperID)";
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("OrderID-----CustomerName-----ShipperName");
            while (resultSet.next()) {
                int OrderID = resultSet.getInt("OrderID");
                String CustomerName = resultSet.getString("CustomerName");
                String ShipperName = resultSet.getString("ShipperName");

                System.out.println(OrderID + "-----" + CustomerName + "-----" + ShipperName);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        innerJoin();
    }
}