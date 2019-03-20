<%-- 
    Document   : salesBookComplete
    Created on : 11-mar-2019, 14:11:58
    Author     : hely
--%>
<%@page import="java.util.List"%>
<%@page import="com.models.Documents"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ENERO</title>
    </head>
    <body>
        <header> </header>
        <input type="button" value="PDF"> 
            <%
                String nto =(String.valueOf(session.getAttribute("Nto")));
                String ngp =(String.valueOf(session.getAttribute("Ngo")));
                String nt =(String.valueOf(session.getAttribute("nt")));
            %>
            <h1>Libro de ventas contribuyente ordinario.</h1>
            <h1><%= nto %> </h1>
            <h1><%= ngp %></h1>
            <h1><%= nt %></h1>
    
        <table border='10'>
    <tr>
        <th>Serie</th>
        <th>No.</th>
        <th>Fecha</th>
        <th>Documento</th>
        <th>Nit</th>
        <th>Nombre o razón social/ del cliente</th>
         <th>Es exenta</th>
        <th>IVA</th>
        <th>Valor neto</th>
        <th>Total</th>
    </tr>
        
             <c:forEach items="${lis}" var="book">
                  <tr>
                 <td>${book.serie}</td>
                 <td>${book.no_doc}</td>
                 <td>${book.documentDate}</td>
                 <td>${book.docName}</td>                                 
                 <td>${book.buyNit}</td>
                 <td>${book.buyer}</td>
                 <td>${book.exempt}</td>              
                 <td>${book.iva}</td>
                 <td>${book.net}</td>
                 <td>${book.total}</td>
                 <td><a href="/salesBook/Doctos?id=${book.id}"> Detalles</a></td>
                 </tr>
             </c:forEach>
         
    </table>

    </body>
</html>
