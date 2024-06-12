package com.create_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Dynamic_Queries {
	public static void main(String [] args)throws ClassNotFoundException,SQLException {
		// load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("driver loaded successfully");
		//create connection 
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","syed","azhar");
		System.out.println("connection created successfully");
		//process the query
		// dynamic queries using preparedstatement object
//		String q1="insert into student values(?,?,?,?,?)";
//		PreparedStatement preparedStatement = connection.prepareStatement(q1);
//		preparedStatement.setInt(1, 104);
//		preparedStatement.setString(2, "Hello");
//		preparedStatement.setString(3, "World");
//		preparedStatement.setInt(4, 88);
//		preparedStatement.setString(5, "A");
//
//       int count = preparedStatement.executeUpdate();
//       System.out.println(count+"record inserted successfully");
		
       // close the connection
       
       //update name of the student belongs to 104 id
       
//       String q2 ="update student set first_name=? where id=?";
       // create PreparedStatement 
//       PreparedStatement preparedStatement2 = connection.prepareStatement(q2);
//       preparedStatement2.setString(1, "SYED");
//       preparedStatement2.setInt(2, 104);
//       
//       int count2 = preparedStatement2.executeUpdate();       
//       if(count2>0) {
//    	   System.out.println(count2+"rowes effected successfully");
//       }else {
//    	   System.out.println(count2+"no rowes effected please try again...........");
//	}
       // delete specific record from the database
//       String q3 ="delete from student where id=?";
       // create preparedstatement
//       PreparedStatement preparedStatement3 = connection.prepareStatement(q3);
//       preparedStatement.setInt(1, 104);
//       
//       int count3 =preparedStatemen3t.executeUpdate();
//       if(count3>0) {
//    	   System.out.println(count3+"record deleted successfully");
//       }else {
//    	   System.out.println(count3+"record deletion failed please try again later.....");
//       }
       
       // get specific record form the database
       String q4 ="select * from student";
       PreparedStatement preparedStatement4 = connection.prepareStatement(q4);
       // to store the data which is coming from database use resultset object
       
       //set the id to preparedstatement which you want to retrive from database
       
       // this is for if condition
//      preparedStatement4.setInt(1,101);
       
       ResultSet resultSet = preparedStatement4.executeQuery();
//       if(resultSet.next()) {
//    	   int id =resultSet.getInt(1);
//    	   String first_name = resultSet.getString(2);
//    	   String last_name = resultSet.getString(3);
//    	   int marks =resultSet.getInt(4);
//    	   String grade= resultSet.getString(5);
//    	   
//    	   System.out.println("student Id :"+id);
//    	   System.out.println("student First_Name :"+first_name);
//    	   System.out.println("student Last_Name :"+last_name);
//    	   System.out.println("student Marks :"+marks);
//    	   System.out.println("student Grade :"+grade);
//    	   System.out.println("----------------------------------------------------------");
//       }
       
       // get all records form the database using the while loop
       
       while(resultSet.next()) {
    	    int id = resultSet.getInt(1);
    	    String first_name = resultSet.getString(2);
    	    String last_name = resultSet.getString(3);
    	    int marks = resultSet.getInt(4);
    	    String grade = resultSet.getString(5);
    	    
    	    System.out.println("student Id: " + id);
    	    System.out.println("student First_Name: " + first_name);
    	    System.out.println("student Last_Name: " + last_name);
    	    System.out.println("student Marks: " + marks);
    	    System.out.println("student Grade: " + grade);
    	    System.out.println("----------------------------------------------------------");
    	}
       
       
       
       
       
       connection.close();
       System.out.println("connection closed successfully");
       }

}
