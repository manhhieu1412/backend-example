import java.sql.*;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.sun.tools.internal.xjc.reader.gbind.OneOrMore;
import model.*;
import org.rythmengine.utils.S;

public class Factory {

    public static String getOrder_details() {
        ResultSet resultSet;
        try {
            resultSet = getrs("select * from order_details");
            ArrayList<Order_details> order_details = new ArrayList<>();
            while (resultSet.next()) {
                int orderDetailID = resultSet.getInt("orderDetailID");
                int orderID = resultSet.getInt("orderID");
                int productID = resultSet.getInt("productID");
                int quantity = resultSet.getInt("quantity");
                Order_details order_detail = new Order_details(orderDetailID, orderID, productID, quantity);
                order_details.add(order_detail);
            }
            Gson gson = new Gson();
            String jison = gson.toJson(order_details);
            System.out.println(jison);
            return jison;
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }

    public static String getOrders() {
        ResultSet resultSet;
        try {
            resultSet = getrs("select * from orders");
            ArrayList<Orders> rsOrder = new ArrayList<>();
            while (resultSet.next()) {
                int orderID = resultSet.getInt("OrderID");
                int customerID = resultSet.getInt("CustomerID");
                int employeeID = resultSet.getInt("EmployeeID");
                String orderDate = resultSet.getString("OrderDate");
                int shipperID = resultSet.getInt("ShipperID");
                Orders orders = new Orders(orderID, customerID, employeeID, orderDate, shipperID);
                rsOrder.add(orders);
            }
            Gson gson = new Gson();
            String jison = gson.toJson(rsOrder);
            System.out.println(jison);
            return jison;
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static String getEmployees() {
        ResultSet resultSet;
        try {
            resultSet = getrs("select * from employees");
            ArrayList<Employees> rsEmployee = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString("EmployeeID");
                String lName = resultSet.getString("LastName");
                String fName = resultSet.getString("FirstName");
                String bd = resultSet.getString("Birthdate");
                String photo = resultSet.getString("Photo");
                String notes = resultSet.getString("Notes");
                Employees employee = new Employees(id, lName, fName, bd, photo, notes);
                rsEmployee.add(employee);
            }
            Gson gson = new Gson();
            String jison = gson.toJson(rsEmployee);
            System.out.println(jison);
            return jison;
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }

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

    public static String getCustomers() {
        ResultSet resultSet = null;
        try {
            resultSet = getrs("select * from customers");
            ArrayList<Customers> rsCustomers = new ArrayList<>();
            while (resultSet.next()) {
                String customerID = resultSet.getString("CustomerID");
                String customerName = resultSet.getString("CustomerName");
                String contactName = resultSet.getString("ContactName");
                String address = resultSet.getString("Address");
                String city = resultSet.getString("City");
                String postalCode = resultSet.getString("PostalCode");
                String country = resultSet.getString("Country");
                Customers customers = new Customers(customerID, customerName, contactName, address, city, postalCode, country);
                rsCustomers.add(customers);
            }
            Gson gson = new Gson();
            String jison = gson.toJson(rsCustomers);
            System.out.println(jison);
            return jison;
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
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





