package com.create_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;



public class Product_Dao {
    // create the database named Product_Management;

    public static void createTable() throws Exception {
        Connection con = null;
        try {
            con = Product_Con.connection();

            // create table
            String q1 = "create table Product_Management (proid number(3) primary key,"
                    + "proname varchar2(50),proprice number(10),promkddate date)";

            // create the statement object to execute the static query
            Statement statement = con.createStatement();
            // execute the query
            statement.executeUpdate(q1);
            System.out.println("table create successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	// close the connection
            con.close();
        }
    }
    
    public static int save()throws Exception {
    	int count=0;
    	Connection connection =null;
    	try {
    		// create connection
    	connection= Product_Con.connection();
          // create insert query
    	// please follow the date format if u are working with oracle sql plus ->dd-mm-yyyy
    	                                                                           // mysql ->YYYY-MM-DD
    	 String insert = "insert into Product_Management values(101,'Apple',50.00, '11-05-2024')";
    	// create Statement object
    	Statement statement = connection.createStatement();
    	// execute the query
    	count = statement.executeUpdate(insert);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// close the connection
			connection.close();
		}
		return count;
    }
    
    public static int saveAll(Product_Management management) throws Exception {
    	int count1=0;
    	Connection connection =null;
    	try {
    		connection=Product_Con.connection();
			String q = "insert into Product_Management values(?,?,?,?)";
			//create prepared statement object to execute dynamic query
			PreparedStatement preparedStatement = connection.prepareStatement(q);
			preparedStatement.setInt(1,management.getProid());
			preparedStatement.setString(2, management.getProname());
			preparedStatement.setDouble(3, management.getProprice());
			preparedStatement.setString(4, management.getPromkddate());
			//execute the query
			count1 = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count1;
    	
    }
    
    // add list of employees
    public static int  SaveList(List<Product_Management>  management) throws Exception {
    	int  count =0 ;
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	try {
			connection =Product_Con.connection();
			String q = "insert into Product_Management values (?,?,?,?) ";
			 preparedStatement=connection.prepareStatement(q);
			for (Product_Management product_Management : management) {
				   preparedStatement.setInt(1, product_Management.getProid());
				   preparedStatement.setString(2, product_Management.getProname());
				   preparedStatement.setDouble(3, product_Management.getProprice());
				   preparedStatement.setString(4,product_Management.getPromkddate());
				   preparedStatement.addBatch();
			}
			// count the number of records inserted into database the return will be negative -2 is success
			int[] result = preparedStatement.executeBatch();
	        for (int i : result) {
	            count += i;
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return count;
		
	}
    
    //find by id 
    public static int  findById(int id) throws Exception {
    	int count =0;
    	Connection connection = null;
    	try {
    		connection= Product_Con.connection();
    		String q = "SELECT * FROM Product_Management WHERE proid = " + id;
			
		   Statement statement = connection.createStatement();
		               
		   ResultSet resultSet = statement.executeQuery(q);
		   if(resultSet.next()) {
			   count+=1;
			   int id1 = resultSet.getInt(1);
			   String name = resultSet.getString(2);
			   double price = resultSet.getDouble(3);
			   String date = resultSet.getNString(4);
			   
			   System.out.println("product id :"+id1);
			   System.out.println("product name :"+name);
			   System.out.println("product price :"+price);
			   System.out.println("product date :"+date);
			   
			   System.out.println("number of records fetched is :"+count);
			   
		   }
    		
    		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return count;
		
	}
    
    // find all 
    public static void findAll()throws Exception {
    	Connection connection = null;
    	try {
    		connection= Product_Con.connection();
    		String q = "select * from Product_Management";
    		PreparedStatement preparedStatement = connection.prepareStatement(q);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		
    		while (resultSet.next()) {
    			  int id1 = resultSet.getInt(1);
   			   String name = resultSet.getString(2);
   			   double price = resultSet.getDouble(3);
   			   String date = resultSet.getNString(4);
   			   
   			   System.out.println("product id :"+id1);
   			   System.out.println("product name :"+name);
   			   System.out.println("product price :"+price);
   			   System.out.println("product date :"+date);
   			   System.out.println("**********************************");
			}
			
		} catch (Exception e) {
			e.getMessage();
		}finally {
			connection.close();
		}
    }
    
    // find by name 
    public static void findByName(String name)throws Exception {
    	Connection connection= null;
    	try {
    		connection=Product_Con.connection();
    		 String q = "SELECT * FROM Product_Management WHERE proname = '" + name + "'";
    		PreparedStatement preparedStatement = connection.prepareStatement(q);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		
    		if(resultSet.next()) {
    			  int id1 = resultSet.getInt(1);
      			   String names = resultSet.getString(2);
      			   double price = resultSet.getDouble(3);
      			   String date = resultSet.getNString(4);
      			   
      			   System.out.println("product id :"+id1);
       			   System.out.println("product name :"+names);
       			   System.out.println("product price :"+price);
       			   System.out.println("product date :"+date);
       			   System.out.println("**********************************");
    		}
			
		} catch (Exception e) {
			e.getMessage();
		}finally {
			connection.close();
		}
    	
    }
    
    // update by id 
    public static void updateById(String updateName)throws Exception {
    	Connection connection = null;
    	try {
			connection= Product_Con.connection();
			 String q = "UPDATE Product_Management SET proname='Apples' WHERE proname='" + updateName + "'";// please avoid spaces here else use updateName.trim();
			Statement  statement = connection.createStatement();
			statement.executeUpdate(q);
			System.out.println("updated successfully");
			}
		 catch (Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}

		
	}
    
    // delete by id 
    
    public static int deleteById(int delById)throws Exception{
    	int count =0;
    	Connection connection = null;
    	try {
    		connection = Product_Con.connection();
    		String q = "delete from Product_Management where proid= "+delById;
    		Statement statement = connection.createStatement();
    		count=statement.executeUpdate(q);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return count;
    	
    }
    
    
    public static void  drop ()throws Exception {
    	Connection  connection = null;
    	try {
    		connection= Product_Con.connection();
    		String q = "drop table Product_Management ";
    		Statement statement = connection.createStatement();
    		statement.executeUpdate(q);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
    }
    
}
