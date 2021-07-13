package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PrepareStatement {
    public static void main(String[] args) {
        Connection connection = JBDCConnection.getJBDCConnection();
        String sql = "SELECT * FROM Person WHERE id = ? and name = ?";
        try {
            PreparedStatement prepare = connection.prepareStatement(sql);
            prepare.setInt(1, 2);
            prepare.setString(2, "H");
            ResultSet rs = prepare.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
