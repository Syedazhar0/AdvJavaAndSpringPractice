package com.tcs.jdbc_servlet_jsp_curd;


	import oracle.jdbc.driver.OracleSQLException;

	public class ProductCon {
	    public static <Connection> Connection connection() throws OracleSQLException {
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
