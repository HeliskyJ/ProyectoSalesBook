<%-- 
    Document   : consBook
    Created on : 10-mar-2019, 20:43:53
    Author     : hely
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleCons.css" type="text/css">
        <title>Libro Ventas</title>
    </head>
    <body>
        <button type="button"> PDF</button>
        <a href="/salesBook/consDate.jsp"> <img id="back" src="images/back.png" width="90px"> </a>
        <table id="cabeza">
            <%
                String nto = (String.valueOf(session.getAttribute("Nto")));
                String ngp = (String.valueOf(session.getAttribute("Ngo")));
                String nt = (String.valueOf(session.getAttribute("nt")));
            %>
            <th colspan="3">Libro de ventas.</th>
            <th><%= nto%> </th>
            <tr>
                <th colspan="3"><%= ngp%></th>
                <th><%= nt%></th>     
            </tr>
        </table>
        <br><br>

        <div class="container">
            <table id="tabl">
                <thead id="h">
                    <tr>
                        <th colspan="3">DOCUMENTO</th>
                        <th colspan="1"></th>
                        <th colspan="1"> TIPO </th>
                        <th colspan="1"></th>
                        <th colspan="1"></th>
                        <th colspan="2">VENTAS</th>
                        <th colspan="1">BIENES</th>
                        <th colspan="1">IVA</th>
                    <tr>

                    <tr>
                        <th>SERIE</th>
                        <th>DEL</th>
                        <th>AL</th>
                        <th>FACTURA</th>
                        <th>DOCUMENTO</th>
                        <th>NIT</th>
                        <th>COMPRADOR</th>
                        <th>EXENTA</th>
                        <th>IVA INCLUIDO</th>
                        <th>(PRECIO NETO)</th>
                        <th>DEBITO FISCAL</th>
                    </tr>  
                </thead>
                <tbody id="tb">
                    <c:forEach items="${lis}" var="book">
                        <tr id="trr">
                            <td>${book.serie}</td>
                            <td>${book.del}</td>
                            <td>${book.al}</td>
                            <td>${book.documentDate}</td>
                            <td>${book.docName}</td>  
                            <td>C/F</td>
                            <td>CLIENTES VARIOS</td>
                            <td id="exe">${book.exempt}</td>              
                            <td>${book.iva}</td>
                            <td>${book.net}</td>
                            <td>${book.total}</td>
                        </tr>
                    </c:forEach>

                    <tr> 
                        <th colspan="7">Totales</th>
                        <td id="x"></td>
                        <td>0</td>
                        <td>0</td>
                        <td>0</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
