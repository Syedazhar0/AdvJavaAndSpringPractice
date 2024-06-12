package CallableStatements_procedure_and_functions;

import java.sql.*;


// prepare plsql procedure in sql plus or mysql where the data is stored
// procedure format  : ->  CREATE OR REPLACE PROCEDURE get_product_price (
//2      p_pro_id IN NUMBER,
//3      p_price OUT NUMBER
//4  )
//5  AS
//6  BEGIN
//7      SELECT proprice INTO p_price
//8      FROM Product_Management
//9      WHERE  proid= p_pro_id;
//10  EXCEPTION
//11      WHEN NO_DATA_FOUND THEN
//12          p_price := NULL;
//13  END;
//14  /
//
//Procedure created.

public class Procedure {
    public static void main(String[] args) throws Exception{
    	//load the driver
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	System.out.println("driver loaded successfully ");
        //create connection
    	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","syed","azhar");
      System.out.println("connection created successfully");

        // SQL query for CallableStatement
        String query = "{CALL get_product_price(?, ?)}";

        try {
        
            // Prepare CallableStatement
            CallableStatement cstmt = conn.prepareCall(query);

            // Set input parameter
            cstmt.setInt(1, 101);

            // Register output parameter
            cstmt.registerOutParameter(2, Types.DOUBLE);// the data will be stored in registerOutParameter

            // Execute CallableStatement
            cstmt.execute();

            // Retrieve output parameter
            double price = cstmt.getDouble(2);
            if (price != 0) {
                System.out.println("Price of product with PROID 101: $" + price);
            } else {
                System.out.println("Product with PROID 101 not found.");
            }

            // Close resources
            cstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
      //out put
    	// driver loaded successfully
//    	connection created successfully
//    	Price of product with PROID 101:54.0
    }
}
