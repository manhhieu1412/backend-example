import java.sql.*;
import java.util.ArrayList;

import com.google.gson.Gson;
import model.Categories;
import model.Product;

public class Factory {

    public static String getProduct() {
        ResultSet resultSet = null;
        try {
            resultSet = getrs("select * from products");
            ArrayList<Product> rsProduct = new ArrayList<>();
            while (resultSet.next()) {
                String productID = resultSet.getString("ProductID");
                String productName = resultSet.getString("ProductName");
                String supplierID = resultSet.getString("supplierID");
                String categoryID = resultSet.getString("CategoryID");
                String unit = resultSet.getString("Unit");
                String price = resultSet.getString("Price");
                Product product = new Product(productID, productName, supplierID, categoryID, unit, price);
                rsProduct.add(product);
            }
            Gson gson = new Gson();
            String jison = gson.toJson(rsProduct);
            System.out.println(jison);
            return jison;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static String getCategori() {
        ResultSet resultSet = null;
        try {
            resultSet = getrs("select * from categories");
            ArrayList<Categories> result = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString("CategoryID");
                String name = resultSet.getString("CategoryName");
                String des = resultSet.getString("Description");
                Categories categories = new Categories(id, name, des);
                result.add(categories);
            }
            System.out.println(result.size());
            Gson gson = new Gson();
            String jison = gson.toJson(result);
            System.out.println(jison);
            return jison;
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static ResultSet getrs(String query) throws SQLException, ClassNotFoundException {
        Connection connection;
        ResultSet resultSet;
        Statement statement;

        String url = "jdbc:mysql://localhost:6033/app_db?useSSL=false";
        String user = "root";
        String password = "my_secret_password";

        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
        return resultSet;
    }
}





