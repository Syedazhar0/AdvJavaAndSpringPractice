package com.create_connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Product_Con {

	public static Connection connection() {
		Connection connection =null;
		try {
			// load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loaded successfully");
			
			// create the connection 
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","syed","azhar");
			System.out.println("connection created successfully");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
