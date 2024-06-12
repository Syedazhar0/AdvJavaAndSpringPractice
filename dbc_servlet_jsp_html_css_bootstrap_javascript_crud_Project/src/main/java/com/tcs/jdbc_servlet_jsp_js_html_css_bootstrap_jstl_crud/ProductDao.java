package com.tcs.jdbc_servlet_jsp_js_html_css_bootstrap_jstl_crud;

import java.sql.Connection;
import java.sql.Statement;

public class ProductDao {
    public static void createTable() throws Exception {
        //create connection
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ProductCon.getConnection();
            //process the query
            String q = "create table product_management_1(pid number(3) primary key, pname varchar2(50), pprice number, pbrand varchar2(50), pmadein varchar2(50), pmkddate date, pexpdate date, pimage blob, paudio blob, pvideo blob)";
            statement = connection.createStatement();
            statement.execute(q);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
