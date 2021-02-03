package miv.study.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // setup connection variables
        String user = "hbstudent";
        String pass = "hbstudent";
        String jdbcUrl = "miv.study.jdbc:postgresql://localhost/web_customer_tracker";
        String driver = "org.postgresql.Driver";

        // get connection to database
        try {
            PrintWriter out = resp.getWriter();
            out.println("Connecting to database: " + jdbcUrl);

            Class.forName(driver);
            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
            out.println("Connection successful");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
