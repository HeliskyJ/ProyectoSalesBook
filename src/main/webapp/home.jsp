<%-- 
    Document   : home
    Created on : 05-mar-2019, 16:24:05
    Author     : hely
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleHome.css" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <header id="head"> 
            <a href="#" id="logout"><img src="images/logOut.png" width="60px"></a></header>
        <div>
            <button onClick="location.href='records.jsp'">Ingresar Datos</button><br>
            <button onclick="location.href='bookList.jsp'"> Libros</button><br>
            <button onclick="location.href='consDate.jsp'"> Consolidado </button>
            </div>
            <img id="logo" src="images/logo.png" alt="logo empresarial">
        
        
    </body>
</html>
