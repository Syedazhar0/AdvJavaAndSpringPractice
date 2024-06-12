package com.tcs.jdbc_jsp_crud_operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.p;

public class ProductDao {
public static void createTable()throws Exception {
	 
	try {
		Connection connection=ProductCon.connection();
		//create statement
		Statement statement = connection.createStatement();
		//process the query
		String sql = "CREATE TABLE products ("
		           + "    pid NUMBER PRIMARY KEY, "
		           + "    pname VARCHAR2(100), "
		           + "    pprice NUMBER, "
		           + "    pbrand VARCHAR2(50), "
		           + "    pmadein VARCHAR2(50), "
		           + "    pmfddate DATE, "
		           + "    pexpDate DATE, "
		           + "    pimage BLOB, "
		           + "    paudio BLOB, "
		           + "    pvideo BLOB "
		           + ")";

		 statement.executeUpdate(sql);
         System.out.println("Product table created successfully.");
         connection.close();
         
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public static boolean saveProduct(ProductData productData) throws Exception {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    boolean success = false;
    try {
        connection = ProductCon.connection();
        String query = "INSERT INTO products VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, productData.getPid());
        preparedStatement.setString(2, productData.getPname());
        preparedStatement.setInt(3, productData.getPprice());
        preparedStatement.setString(4, productData.getPbrand());
        preparedStatement.setString(5, productData.getPmadein());
        preparedStatement.setDate(6, productData.getPmfddate());
        preparedStatement.setDate(7, productData.getPexpDate());
        preparedStatement.setBytes(8, productData.getPimage());
        preparedStatement.setBytes(9, productData.getPaudio());
        preparedStatement.setBytes(10, productData.getPvideo());
        
        // Execute the update operation
        int rowsAffected = preparedStatement.executeUpdate();
        success = (rowsAffected > 0);
    } catch (SQLException e) {
        // Handle the exception gracefully
        e.printStackTrace();
    } finally {
        // Close PreparedStatement and Connection
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return success;
}

public static List<ProductData> findAllProducts() {
    List<ProductData> datas = new ArrayList<>();
    Connection connection = null;
    Statement statement = null;
    try {
        connection = ProductCon.connection();
        String q = "SELECT * FROM products";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(q);
        while (resultSet.next()) {
            ProductData product = new ProductData();
            product.setPid(resultSet.getInt("pid"));
            product.setPname(resultSet.getString("pname"));
            product.setPprice(resultSet.getInt("pprice"));
            product.setPbrand(resultSet.getString("pbrand"));
            product.setPmadein(resultSet.getString("pmadein"));
            product.setPmfddate(resultSet.getDate("pmfddate"));
            product.setPexpDate(resultSet.getDate("pexpDate"));
            product.setPimage(resultSet.getBytes("pimage"));
            product.setPaudio(resultSet.getBytes("paudio"));
            product.setPvideo(resultSet.getBytes("pvideo"));
            datas.add(product);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return datas;
}

public static ProductData findById(int id) throws Exception {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ProductData productData = null;
    try {
        connection = ProductCon.connection();
        String q = "SELECT * FROM products WHERE pid=?";
        preparedStatement = connection.prepareStatement(q);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            productData = new ProductData();
            productData.setPid(resultSet.getInt("pid"));
            productData.setPname(resultSet.getString("pname"));
            productData.setPprice(resultSet.getInt("pprice"));
            productData.setPbrand(resultSet.getString("pbrand"));
            productData.setPmadein(resultSet.getString("pmadein"));
            productData.setPmfddate(resultSet.getDate("pmfddate"));
            productData.setPexpDate(resultSet.getDate("pexpDate"));
            productData.setPimage(resultSet.getBytes("pimage"));
            productData.setPaudio(resultSet.getBytes("paudio"));
            productData.setPvideo(resultSet.getBytes("pvideo"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return productData;
}

public static int updateProduct(ProductData productData) throws Exception {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    int count = 0;
    try {
        connection = ProductCon.connection();
        String q = "UPDATE products SET pname=?, pprice=?, pbrand=?, pmadein=?, pmfddate=?, pexpDate=?, pimage=?, paudio=?, pvideo=? WHERE pid=?";
        preparedStatement = connection.prepareStatement(q);
    
        preparedStatement.setString(1, productData.getPname());
        preparedStatement.setInt(2, productData.getPprice());
        preparedStatement.setString(3, productData.getPbrand());
        preparedStatement.setString(4, productData.getPmadein());
        preparedStatement.setDate(5, productData.getPmfddate());
        preparedStatement.setDate(6, productData.getPexpDate());
        preparedStatement.setBytes(7, productData.getPimage());
        preparedStatement.setBytes(8, productData.getPaudio());
        preparedStatement.setBytes(9, productData.getPvideo());
        preparedStatement.setInt(10, productData.getPid());
       
        
        
        count = preparedStatement.executeUpdate();
    } catch (SQLException e) {
       
        e.printStackTrace();
    } finally {
        
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return count;
}

public static int deleteProduct(int productId) throws Exception {
    int count = 0;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
        connection = ProductCon.connection();
        String query = "DELETE FROM products WHERE pid = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, productId);
        count = preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return count;
}

}
