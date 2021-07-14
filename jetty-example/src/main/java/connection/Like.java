package connection;

import com.google.gson.Gson;
import model.Customers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Like {
    public static String getLike() {
        Connection connection = JBDCConnection.getJBDCConnection();
        try {
            ArrayList<Customers> arr = new ArrayList<>();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM customers WHERE CustomerName LIKE 'a%'";
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String customerID = resultSet.getString("customerID");
                String customerName = resultSet.getString("customerName");
                String contactName = resultSet.getString("contactName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String postalCode = resultSet.getString("postalCode");
                String country = resultSet.getString("country");
                Customers customers = new Customers(customerID, customerName, contactName, address, city, postalCode, country);
                arr.add(customers);
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
