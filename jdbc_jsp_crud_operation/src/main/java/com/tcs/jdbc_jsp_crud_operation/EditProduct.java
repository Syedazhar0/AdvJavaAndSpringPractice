package com.tcs.jdbc_jsp_crud_operation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@MultipartConfig
@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	String productIdString = request.getParameter("productId");
        if (productIdString != null && !productIdString.isEmpty()) {
            int productId = Integer.parseInt(productIdString);

        try {
           
            ProductData product = ProductDao.findById(productId);

          
            request.setAttribute("product", product);

            
            request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
        } catch (Exception e) {
        
            e.printStackTrace();
           
            response.sendRedirect("display.jsp");
        }
    }
    }

}
