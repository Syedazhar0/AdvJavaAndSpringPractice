package com.User_Registration_From;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/User_Registration_From")
public class User_Registration_From extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generating HTML response with Bootstrap CSS
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Form Data</title>");
        out.println("<link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
        out.println("<style>");
        out.println(".container {");
        out.println("    margin-top: 50px;");
        out.println("}");
        out.println("h2 {");
        out.println("    color: #007bff;");
        out.println("}");
        out.println("p {");
        out.println("    font-size: 18px;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        // Retrieving form parameters
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String[] qualifications = request.getParameterValues("qualification");
        String gmail = request.getParameter("gmail");
        String mobile = request.getParameter("mobile");
        String dob = request.getParameter("dob");
        String country = request.getParameter("country");
        String[] languages = request.getParameterValues("languages");
        String comments = request.getParameter("comments");

        // Displaying received data
        out.println("<div class=\"container\">");
        out.println("<h2>Received Form Data:</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Password: " + password + "</p>");
        out.println("<p>Gender: " + gender + "</p>");
        out.println("<p>Qualifications: ");
        for (String qualification : qualifications) {
            out.println(qualification + " ");
        }
        out.println("</p>");
        out.println("<p>Gmail: " + gmail + "</p>");
        out.println("<p>Mobile: " + mobile + "</p>");
        out.println("<p>Date of Birth: " + dob + "</p>");
        out.println("<p>Country: " + country + "</p>");
        out.println("<p>Languages: ");
        for (String language : languages) {
            out.println(language + " ");
        }
        out.println("</p>");
        out.println("<p>Comments: " + comments + "</p>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}
