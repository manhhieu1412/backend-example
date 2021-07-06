import org.rythmengine.Rythm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RythmApplication extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException {
        String name = request.getParameter("name");

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        if(name != null)
            write(response, Rythm.render("hello.html", name));
        else
            write(response, Rythm.render("warn.html", "Please provide the parameter name"));

    }

    private void write(HttpServletResponse resp, String message) throws IOException {
        resp.getWriter().write(message);
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
}
