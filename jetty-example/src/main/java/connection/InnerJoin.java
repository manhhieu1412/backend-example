package connection;

import com.google.gson.Gson;
import model.InnerTest;
import org.rythmengine.utils.S;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class InnerJoin {
    public static String innerJoin() {
        Connection connection = JBDCConnection.getJBDCConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT orders.OrderID, customers.CustomerName, shippers.ShipperName " +
                    "FROM ((orders " +
                    "INNER JOIN customers ON orders.CustomerID = customers.CustomerID) " +
                    "INNER JOIN shippers ON orders.ShipperID = shippers.ShipperID)";
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);
            ArrayList<InnerTest> array = new ArrayList<>();
            System.out.println("OrderID-----CustomerName-----ShipperName");
            while (resultSet.next()) {
                int OrderID = resultSet.getInt("OrderID");
                String CustomerName = resultSet.getString("CustomerName");
                String ShipperName = resultSet.getString("ShipperName");
                InnerTest innerTest = new InnerTest(OrderID, CustomerName, ShipperName);
                array.add(innerTest);
                System.out.println(OrderID + "-----" + CustomerName + "-----" + ShipperName);
            }
            Gson gson = new Gson();
            String jison = gson.toJson(array);
            System.out.println(jison);
            return jison;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}