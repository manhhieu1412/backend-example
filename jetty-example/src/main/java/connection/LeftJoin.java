package connection;

import com.google.gson.Gson;
import com.sun.tools.internal.ws.wsdl.document.jaxws.CustomName;
import model.Left;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LeftJoin {
    public static String Join() {
        Connection connection = JBDCConnection.getJBDCConnection();
        try {
        String query = "SELECT customers.CustomerName, orders.OrderID FROM customers" +
                " LEFT JOIN orders ON customers.CustomerID = orders.CustomerID" +
                " ORDER BY customers.CustomerID";
        ArrayList<Left> array = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println(query);
            while (rs.next()) {
                String name = rs.getString("CustomerName");
                int id = rs.getInt("OrderID");
                Left left = new Left(name, id);
                array.add(left);
            }
            Gson gson = new Gson();
            String jison = gson.toJson(array);
            return jison;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
