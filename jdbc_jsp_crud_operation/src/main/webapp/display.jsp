<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tcs.jdbc_jsp_crud_operation.ProductData" %>
<%@ page import="com.tcs.jdbc_jsp_crud_operation.ProductDao" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.beans.Statement" %>

<!-- Note if u imported the package  page import="org.apache.commons.codec.binary.Base64" 
use the below syntax while working with files ex:img,audio video  -->
<!--source src="data:audio/mpeg;base64,$ Base64.encodeBase64String(product.pimage) -->

<!-- if u imported the package page import="java.util.Base64" use the below syntax while working with files ex:img,audio video  -->
<%--  jsp comment 
    <img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.pimage)}" width="100" height="100" />
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product List</title>
  
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
      
        body {
            background-color: #f2f2f2;
            margin: 20px;
            padding: 20px;
        }
        .alert-success {
            color: #155724;
            background-color: #d4edda;
            border-color: #c3e6cb;
            margin-bottom: 20px;
        }
        .alert-danger {
            color: #721c24;
            background-color: #f8d7da;
            border-color: #f5c6cb;
            margin-bottom: 20px;
        }
        table {
            background-color: #fff;
        }
        table thead th {
            background-color: #343a40;
            color: #fff;
        }
        table tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        table tbody tr:nth-child(odd) {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
 <div class="container mt-4"></div>
        
        <div class="mb-3">
            <a href="saveproduct.html" class="btn btn-success">Add Product</a>
        </div>
    <div class="container mt-4">
        <h2>List of Available Products</h2>
        </div>
       
        <c:if test="${datasaved == 1}">
            <div class="alert alert-success" role="alert">
                Data saved successfully!
            </div>
        </c:if>
        <c:if test="${datasaved != 1}">
            <div class="alert alert-danger" role="alert">
                Data insertion failed!
            </div>
        </c:if>
        
        <c:if test="${deleteStatus eq 'success'}"><%--here eq is nothing but EqualTo u can use == insted of eq  --%> 
            <div class="alert alert-success" role="alert">
                Data deleted successfully!
            </div>
        </c:if>
        <c:if test="${deleteStatus eq 'failure'}">
            <div class="alert alert-danger" role="alert">
                Data deletion failed! Please try again.
            </div>
        </c:if>
        
        <table class="table table-bordered mt-3">
            <thead class="thead-dark">
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Brand</th>
                    <th>Made In</th>
                    <th>Manufacture Date</th>
                    <th>Expiration Date</th>
                    <th>Image</th>
                    <th>Audio</th>
                    <th>Video</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
               <c:forEach var="product" items="<%= new ProductDao().findAllProducts()%>">
        <tr>
        <td>${product.getPid()}</td>
        <td>${product.getPname()}</td>
        <td>${product.getPprice()}</td>
        <td>${product.getPbrand()}</td>
        <td>${product.getPmadein()}</td>
        <td>${product.getPmfddate()}</td>
        <td>${product.getPexpDate()}</td>
        <td>
            <c:if test="${not empty product.pimage}">
                <img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.pimage)}" width="100" height="100" />
            </c:if>
        </td>
        <td>
            <c:if test="${not empty product.paudio}">
                <audio controls>
                    <source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(product.paudio)}" type="audio/mpeg">
                </audio>
            </c:if>
        </td>
        <td>
            <c:if test="${not empty product.pvideo}">
                <video width="100" height="100" controls loop>
                    <source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(product.pvideo)}" type="video/mp4">
                </video>
            </c:if>
        </td>
        <td><a href="./EditProduct?productId=${product.getPid()}" class="btn btn-warning">Edit</a></td>
        <td><a href="./DeleteProduct?productId=${product.getPid()}" class="btn btn-danger">Delete</a></td>
    </tr>
</c:forEach>
            </tbody>
        </table>
   
</body>
</html>
