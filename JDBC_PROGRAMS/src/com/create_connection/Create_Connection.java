package com.create_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Create_Connection {
	public static void main(String [] args) throws ClassNotFoundException, SQLException {
		 // Load the driver
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver loaded successfully");
		 // Create the connection
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "syed", "azhar");
        System.out.println("Connection created successfully");
        connection.close();
        System.out.println(" connection released successfully");
	}

}
