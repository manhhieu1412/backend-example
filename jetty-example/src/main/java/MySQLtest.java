import java.sql.*;

public class MySQLtest {
    //
//    public static ResultSet getResult(String query) throws ClassNotFoundException, SQLException {
//        ResultSet r = null;
//        Connection con = null;
//        Statement st = null;
//
//        String url = "jdbc:mysql://192.168.1.44:6033/app_db?useSSL=false";
//        String user = "db_user";
//        String password = "db_user_pass";
//
//        Class.forName("com.mysql.jdbc.Driver");
//        con = DriverManager.getConnection(url, user, password);
//        st = con.createStatement();
//        r = st.executeQuery(query);
//
//        return r;

//    }


//    public static ResultSet getResult(String query) throws ClassNotFoundException, SQLException {
//        ResultSet rs = null;
//        Connection con = null;
//        Statement st = null;
//
//        String url = "jdbc:mysql://192.168.1.44:6033/app_db?useSSL=false";
//        String user = "db_user";
//        String pasword = "db_user_pass";
//
//        Class.forName("com.mysql.jdbc.Driver");
//        con = DriverManager.getConnection(url, user, pasword);
//        st = con.createStatement();
//        rs = st.executeQuery(query);
//
//        return rs;
//
//
//    }
//
//    public static void main(String[] args) {
//        ResultSet rs = null;
//        try {
//
//            rs = getResult("select * from orders");
//            while (rs.next()) {
//                String orderID = rs.getString("OrderID");
//                String customerID = rs.getString("CustomerID");
//                String orderDate = rs.getString("OrderDate");
//                String employeeID = rs.getString("EmployeeID");
//                String shiperID = rs.getString("ShipperID");
//            }
//        } catch (ClassNotFoundException ex) {
//            System.out.println(ex);
//        } catch (SQLException e) {
//            System.out.println(e);
//        }

    public static ResultSet getResult(String query) throws ClassNotFoundException, SQLException {
        Connection con = null;
        Statement st = null;
        ResultSet re = null;

        String url = "jdbc:mysql://localhost:6033/app_db?useSSL=false";
        String user = "root";
        String password = "my_secret_password";

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, user, password);
        st = con.createStatement();
        re = st.executeQuery(query);
        return re;
    }

    public static void main(String[] args) {
        ResultSet re = null;
        try {
            re = getResult("select * from customers");
            while (re.next()) {
                String name = re.getString("CustomerName");
                String address = re.getString("Address");
                String city = re.getString("city");
                System.out.println(name + "-----" + address + "-----" + city);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}




