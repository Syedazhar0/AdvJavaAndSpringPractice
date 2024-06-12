package CallableStatements_procedure_and_functions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
// open oracle or mysql in which data is stored and run the command below code
//CREATE OR REPLACE FUNCTION get_product_pricess (
//p_pro_id IN NUMBER
//)
//RETURN NUMBER
//IS
//v_price NUMBER;
//BEGIN
//SELECT proprice INTO v_price
//FROM Product_Management
//WHERE proid = p_pro_id;
//
//RETURN v_price;
//EXCEPTION
//WHEN NO_DATA_FOUND THEN
//    RETURN NULL;
//END;
///


public class Function {
public static void main(String [] args) throws Exception{
	// load the driver 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("driver loaded successfully");
	// create connection
	Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","syed","azhar");
	System.out.println("connection created successfully");
	//process the query
	String qString = "{?=call get_product_pricess(?)}";
	try {
		// create callable statement
		CallableStatement callableStatement = connection.prepareCall(qString);
		
		callableStatement.setInt(2, 101);
		
		callableStatement.registerOutParameter(1, Types.DOUBLE);
		
		// execute statement
		callableStatement.execute();
		
		// Retrieve the data
		
		double price = callableStatement.getDouble(1);
		
		if(price!=0) {
			System.out.println("Price of product with PROID 101:"+price);
		}else {
			System.out.println("No such Record Found Try Again");
		}
		connection.close();
		callableStatement.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	//out put
	// driver loaded successfully
//	connection created successfully
//	Price of product with PROID 101:54.0
}
}
