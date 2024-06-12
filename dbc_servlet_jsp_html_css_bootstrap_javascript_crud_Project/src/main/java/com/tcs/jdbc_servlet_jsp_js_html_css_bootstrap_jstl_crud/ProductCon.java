package com.tcs.jdbc_servlet_jsp_js_html_css_bootstrap_jstl_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductCon {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // Load the driver 
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver loaded successfully");

        // Create connection
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "syed", "azhar");
            System.out.println("Connection created successfully");
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return connection;
    }
}
