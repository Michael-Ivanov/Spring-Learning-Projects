package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class TestJdbc {

    public static void main(String[] args) {


        try {
            String jdbcUrl = "jdbc:postgresql://localhost/hb_one_to_one";
            Properties properties = new Properties();
            properties.setProperty("user", "hbstudent");
            properties.setProperty("password", "hbstudent");
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl, properties);
            System.out.println("Connection successful: " + connection.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
