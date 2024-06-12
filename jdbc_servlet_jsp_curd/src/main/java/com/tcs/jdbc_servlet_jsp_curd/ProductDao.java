package com.tcs.jdbc_servlet_jsp_curd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDao {
	public static void createTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ProductCon.connection();
            if (connection != null) {
                statement = connection.createStatement();

                // Process the query
                String query = "CREATE TABLE product_management_1 (pid NUMBER(3) PRIMARY KEY, pname VARCHAR2(50), pprice NUMBER, pbrand VARCHAR2(50), pmadein VARCHAR2(50), pmkddate DATE, pexpdate DATE, pimage BLOB, paudio BLOB, pvideo BLOB)";
                statement.executeUpdate(query);

                System.out.println("Table created successfully");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while creating table");
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error occurred while closing resources");
                e.printStackTrace();
            }
        }
    }
}
