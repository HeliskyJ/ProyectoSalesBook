<%-- 
    Document   : newBuyer
    Created on : 06-mar-2019, 17:15:42
    Author     : hely
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleBuy.css" type="text/css">
        <title>Ingresando Comprador</title>
    </head>
    <body>
        <header id="head"></header>
        <div id="container_form">
            <a href="/salesBook/records.jsp"><img src="images/back.png" alt="REGRESAR" width="60px"> </a>
            <form method="post" action="/salesBook/InBuy" autocomplete="false">
                <img id="comp" src="images/buy.png" alt="Comprador">
                <input type="text" name="name" placeholder="Nombre completo" 
                       autofocus="true" requerid="true" autocomplete="false">
                <br>
                <br>
                <input type="text" name="nit" placeholder="NIT" required="true"> 
                <button>Guardar</button>
            </form>
        </div>
        <img id="logo" src="images/logo.png" alt="LOGO">
    </body>
</html>
