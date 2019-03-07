<%-- 
    Document   : DocType
    Created on : 06-mar-2019, 11:54:37
    Author     : hely
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleDoc.css" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <header id="head"> </header>
        <div id="contenedor">
            <a href="/salesBook/records.jsp"> <img src="images/back.png" alt="Regresar" width="60px"></a>
            <form method="post" action="/salesBook/InDocType">
                <img id="doc" src="images/doc.png" alt="documento">
                <input name="type" type="text" placeholder="Nombre del documento"
                       required="true" minlength="5" maxlength="35" 
                       autofocus="true">
                <button>Guardar</button>
            </form>
        </div>
        <img id="logo" src="images/logo.png">
    </body>
</html>
