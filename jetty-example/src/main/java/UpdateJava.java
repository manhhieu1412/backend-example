import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateJava {
    public static void main(String[] args) {
        try {
//            String update = "insert into employees (EmployeeID, LastName, FirstName, BirthDate, Photo, Notes)" + "values ('12', 'Hung', 'vu', '1991-09-09', 'co', 'co')";
//            Update(update);
            String delete = "delete from employees " + "where EmployeeID = 12";
            Update(delete);
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }

    }

    public static void Update(String update) throws ClassNotFoundException, SQLException {
        Connection con;
        Statement st;

        String url = "jdbc:mysql://localhost:6033/app_db?useSSL=false";
        String user = "root";
        String password = "my_secret_password";

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, user, password);
        st = con.createStatement();
        st.executeUpdate(update);
    }
////    public static void delete(String delete)throws ClassNotFoundException, SQLException{
////        Connection con;
////        Statement st;
////
////        String url = "jdbc:mysql://localhost:6033/app_db?useSSL=false";
////        String user = "root";
////        String password = "my_secret_password";
////
////        Class.forName("com.mysql.jdbc.Driver");
////        con = DriverManager.getConnection(url, user, password);
////        st = con.createStatement();
////        st.executeUpdate(delete);
//    }
}
