package com.tcs.transaction_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Transaction_Processing {
	public static void main(String [] args)throws Exception {
		// load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("driver loaded successfully");
		
		// create connection
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","syed","azhar");
		System.out.println("connection created successfully ");
		connection.setAutoCommit(false);
		try {
			String q = "insert into Product_Management values(101,'Apples',54.00,'13-05-2024')";
			String q1 = "insert into Product_Management values(113,'ScoolBag',450.00,'14-05-2024')";
			String q2 = "delete from Product_Management where proid=110";
		    
			Statement statement = connection.createStatement();
			statement.addBatch(q);
			statement.addBatch(q1);
			statement.addBatch(q2);
			
			int [] result = statement.executeBatch();
			
			for (int i : result) {
				System.out.println("records inserted successfully..."+i);
			}
		
			connection.commit();
			System.out.println("transactions commited successfully");
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			System.out.println("transactions rollbacked successfully");
		}finally {
			connection.close();
		}
		
	}

}
