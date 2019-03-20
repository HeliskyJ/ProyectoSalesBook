<%-- 
    Document   : ConsulBook
    Created on : 10-mar-2019, 20:43:53
    Author     : hely
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Enero</h1>
        <table>
    <tr>
    <th> Negocio</th>
    <th> NIt </th>
    </tr>
    <tr>
        <th value="${sle.business}"></th>
        <th value="${sle.userNit}"></th>
    </tr>
    </table>
    </body>
</html>
