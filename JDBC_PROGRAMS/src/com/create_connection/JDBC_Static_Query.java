package com.create_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Static_Query {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Load the driver
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver loaded successfully");
        // Create connection
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "syed", "azhar");
        System.out.println("Connection created successfully");
        // Process static query using Statement object
        Statement statement = connection.createStatement();
//        String q1 = "create table student(id number(3) primary key,"
//                + " first_name varchar2(50), last_name varchar2(50),"
//                + " marks number(3), grade varchar2(1))";
//        statement.executeUpdate(q1);
//        System.out.println("Table created successfully");

        // Insert data into student
//        int count = 0;
//        String q2_1 = "insert into student (id, first_name, last_name, marks, grade)"
//                + " values(101, 'Syed', 'Azhar', 99, 'A')";
//        String q2_2 = "insert into student (id, first_name, last_name, marks, grade)"
//                + " values(102, 'Syed', 'Mazhar', 98, 'B')";
//        String q2_3 = "insert into student (id, first_name, last_name, marks, grade)"
//                + " values(103, 'Syed', 'Athar', 60, 'C')";
//
//     count=   statement.executeUpdate(q2_1);
//        statement.executeUpdate(q2_2);
//        statement.executeUpdate(q2_3);
//
//        if (count >= 1) {
//            System.out.println("Values inserted successfully....");
//        } else {
//            System.out.println("Values insertion failed......");
//        }

//        String q0 = "truncate table student";
//        statement.executeUpdate(q0);
//        System.out.println("table truncated successfully");
        
//        String q5 ="select * from student where id=101";
        // get the datafrom database and set the data into resultset object this is for single record
//        ResultSet resultSet = statement.executeQuery(q5);
//        if (resultSet.next()) {
//          
//            int id = resultSet.getInt("id");
//            String firstName = resultSet.getString("first_name");
//            String lastName = resultSet.getString("last_name");
//            int marks = resultSet.getInt("marks");
//            String grade = resultSet.getString("grade");
//            
//       
//            System.out.println("ID: " + id);
//            System.out.println("First Name: " + firstName);
//            System.out.println("Last Name: " + lastName);
//            System.out.println("Marks: " + marks);
//            System.out.println("Grade: " + grade);
//        } else {
//            System.out.println("No record found with ID 101");
//        }
        
        // this loop will fetch all records form the database and store the data to resultset object
        // and print the records one after another
        
        // update the student names to upper case
//        String updateQuery = "UPDATE student SET first_name = UPPER(first_name), last_name = UPPER(last_name)";
//        int rowsAffected = statement.executeUpdate(updateQuery);
//        System.out.println(rowsAffected + " rows updated successfully");
        
        String q5 ="select * from student";
        
        ResultSet resultSet = statement.executeQuery(q5);
        
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int marks = resultSet.getInt("marks");
            String grade = resultSet.getString("grade");

         
            System.out.println("ID: " + id);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Marks: " + marks);
            System.out.println("Grade: " + grade);
            System.out.println(); 
        }
      
        
        connection.close();
        System.out.println("Connection closed successfully");
    }
}
