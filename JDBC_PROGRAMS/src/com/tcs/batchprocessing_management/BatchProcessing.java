package com.tcs.batchprocessing_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class BatchProcessing {
	public static void main(String [] args)throws Exception {
		Connection connection=null;
		try {
			//load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("connection created successfully");
			
			// created the connection 
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","syed","azhar");
			System.out.println("connection created successfully");
			
			// process the queries 
			String q ="insert into Product_Management values(101,'Apple',50.00,'13-05-2024')";
			
			// batch processing with single query
			Statement statement = connection.createStatement();
			// execute batch
			statement.execute(q);
			System.out.println("record inserted successfully");
			
			// adding multiple record at runtime
			String q1 = "insert into Product_Management values(?,?,?,?)";
//			
			PreparedStatement preparedStatement = connection.prepareStatement(q1);
			
			try (Scanner scanner = new Scanner(System.in)) {
				while (true) {
					System.out.println("enter id");
					int id = scanner.nextInt();
					System.out.println("enter name");
					String name = scanner.next();
					System.out.println("enter price");
					double price = scanner.nextDouble();
					System.out.println("enter date");
					String date = scanner.next();
				
					preparedStatement.setInt(1, id);
					preparedStatement.setString(2, name);
					preparedStatement.setDouble(3, price);
					preparedStatement.setString(4, date);
					
					preparedStatement.addBatch();
					
					// Execute the batch
					 int[] result = preparedStatement.executeBatch(); 
					    
					    // loop to check records are inserted successfully or not
					    for (int i : result) {
					        System.out.println("records inserted successfully: " + i);
					    }
					
					System.out.println("do you want to continue.....y/n");
					char answer = scanner.next().charAt(0);
					
					if(answer=='n') {
						break;
					}else {
						
					}
				}
			}
		    String q2 ="insert into Product_Management values(111,'scale',10.00,'18-05-2024')";
		    String q3 ="insert into Product_Management values(112,'slateboard',52.00,'16-05-2024')";
		    String q4 ="delete from Product_Management where proid=101";
		    
		    Statement  statement1  = connection.createStatement();
		    statement1.addBatch(q2);
		    statement1.addBatch(q3);
		    statement1.addBatch(q4);
		    
		    int [] result = statement.executeBatch();
		    // for loop to check all queries are executed or not
		    
		    for (int i : result) {
				System.out.println("batch execution successful..."+i);
			}
		    
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// release the connection
						connection.close();
		}

	}

}
