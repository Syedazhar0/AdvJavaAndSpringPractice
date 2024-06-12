package com.tcs.jdbc_jsp_crud_operation;

import java.sql.Connection;
import java.sql.DriverManager;

public class ProductCon {// if u encountering classnotfound exception
	// please goto src folder and webinf folder check the lib folder the jar files are configured
	// or not and check web library folder is available or not if not 
	// go to jar file location copy and paste into lib folder 
    public static Connection connection() throws Exception {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("driver loaded successfully");
        
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "syed", "azhar");
            System.out.println("connection created successfully");
        
        } catch (Exception e) {
            e.printStackTrace();
            throw e; // re-throwing the exception
        }
        return connection;
    }
}
