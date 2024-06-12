package jdbc_jsp_servlet_crud_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductCon {
    public static Connection connection() throws SQLException {
        Connection connection = null;
        try {
            // Load the driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle JDBC driver loaded successfully");

            // Create connection
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "syed", "azhar");
            System.out.println("Connection to database established successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC driver not found");
            e.printStackTrace();
        }
        return connection;
    }
}
