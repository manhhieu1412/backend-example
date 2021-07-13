package connection;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class JBDCConnection {
    public static Connection getJBDCConnection() {
        final String url = "jdbc:mysql://localhost:6033/app_db?useSSL=false";
        final String user = "root";
        final String password = "my_secret_password";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        Connection connection = getJBDCConnection();
        if (connection != null) {
            System.out.println("ok");
        } else {
            System.out.println("not ok");
        }
    }
}
