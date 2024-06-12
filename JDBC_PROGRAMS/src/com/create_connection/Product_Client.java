package com.create_connection;

import java.util.ArrayList;
import java.util.List;
//table
//Name                                                  Null?    Type
//----------------------------------------------------- -------- ------------------------------------
//PROID                                                 NOT NULL NUMBER(3)
//PRONAME                                                        VARCHAR2(50)
//PROPRICE                                                       NUMBER(10)
//PROMKDDATE                                                     DATE
//
//SQL> select * from Product_Management;
//
//    PROID PRONAME                                              PROPRICE PROMKDDAT
//---------- -------------------------------------------------- ---------- ---------
//      102 Banana                                                     54 12-MAY-24
//      103 Grapes                                                     60 13-MAY-24
//      104 Mango                                                      75 14-MAY-24
//      105 Papaya                                                     65 15-MAY-24
//      106 Kiwi                                                      100 16-MAY-24

public class Product_Client {
    public static void main(String[] args)throws Exception {
    	// these are static methods no need to create object called by class name and method name
    	// called create table method into main class
    	
        Product_Dao.createTable();
    	
//         called save method 
       int count = Product_Dao.save();
       if (count>0) {
    	   System.out.println("data inserted successfully");
	}else {
		System.out.println("data insertion failed please try again");
	}
      // creating object of Product_Management and initializing the values 
    	
    	// here you can use the setter methods by creating object of Product_Management ex:
    	// Product_Management management = new Product_Management();
    	// management.setProid(102);
    	
      int count1 = Product_Dao.saveAll(new Product_Management(102, "Banana", 54.00, "12-05-2024"));
      
      int count2 = Product_Dao.saveAll(new Product_Management(103, "Grapes", 60.00, "13-05-2024"));
      
      System.out.println("products inserted into database successfully........"+count1+" "+count2);
    	
    	// create a Array list  to add list of products
    	
            List<Product_Management> products = new ArrayList<>();
            products.add(new Product_Management(104,"Mango",75.00, "14-05-2024"));
            products.add(new Product_Management(105, "Papaya", 65.00, "15-05-2024"));
            products.add(new Product_Management(106, "Kiwi", 100.00, "16-05-2024"));
            try {
                int count3 = Product_Dao.SaveList(products);
                if (count3 <=0) {
                    System.out.println("List of products added to the database successfully"+count3);
//                    //List of products added to the database successfully-6-> 3 records success values -2+-2+-2=-6
                } else {
                    System.out.println("Insertion failed. Please try again later.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    	
    	int count4 = Product_Dao.findById(101);
    	if(count4>0) {
    		System.out.println("record fetched successfully :"+count4);
    	}else {
			System.out.println("no record fetched :"+count4);
		}
    	
    	// call the find all method
    	
    	Product_Dao.findAll();
    	
    	Product_Dao.findByName("Apple");
    	
    	Product_Dao.updateById("Apple");
    	
    	int count5 = Product_Dao.deleteById(101);
    	if (count5>0) {
    		System.out.println("record deleted suuccessfully............"+count5);
			
		}else {
			System.out.println("deletion failed please try again later ......"+count5);
		}
    	
    	
//    	Product_Dao.drop();
    	
    }
}