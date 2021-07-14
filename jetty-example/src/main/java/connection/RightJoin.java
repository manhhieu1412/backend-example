package connection;

import com.google.gson.Gson;
import model.Right;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RightJoin {
    public static String rightJoin() {
        Connection connection = JBDCConnection.getJBDCConnection();
        ArrayList<Right> arr = new ArrayList<>();
        try {
            String query = "SELECT orders.OrderID, employees.LastName, employees.FirstName" +
                    " FROM orders RIGHT JOIN employees ON orders.EmployeeID = employees.EmployeeID" +
                    " ORDER BY orders.OrderID";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println(query);
            while (rs.next()) {
                int id = rs.getInt("OrderID");
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                Right rJoin = new Right(id, lastName, firstName);
                arr.add(rJoin);
            }
            Gson gson = new Gson();
            String jison = gson.toJson(arr);
            System.out.println(jison);
            return jison;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
