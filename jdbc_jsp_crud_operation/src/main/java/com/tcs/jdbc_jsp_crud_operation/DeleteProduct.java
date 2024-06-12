package com.tcs.jdbc_jsp_crud_operation;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        try {
            
            int count = ProductDao.deleteProduct(productId);

            if(count > 0) {
             
                request.setAttribute("deleteStatus", "success");
            } else {
                
                request.setAttribute("deleteStatus", "failure");
            }
        } catch (Exception e) {
           
            e.printStackTrace();
        }
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }
}
