<%-- 
    Document   : register
    Created on : 05-mar-2019, 14:40:53
    Author     : hely
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/styleRegis.css" type="text/css">
        <title>Log up</title>
    </head>
    <body>
        <div class="container">
        <form autocomplete="off" method="post" action="/salesBook/up">
            <br><br><br><br><br><br>
            <input name="fullName" type="text" placeholder="Nombre completo" 
                   autofocus="true" required="true" maxlength="35" minlength="4"/>
            <br><br>
            <input name="username" type="text" placeholder="Nombre de usuario" 
                   required="true" draggable="false" maxlength="35" minlength="3" />
            <br><br>
            <input name="password" type="password" placeholder="Contraseña" 
                   required="true" draggable="false" minlength="8" />
            <br><br>
            <input name="businessName" type="text" 
                   placeholder="Nombre del negocio" required="true" 
                   draggable="false" maxlength="35"/>
            <br><br>
            <input name="nit" type="text" placeholder="Nit"required="true" 
                   draggable="false" minlength="3" maxlength="10"/>
            <br><br>
            <button>Registrarme</button>
        </form>
            <a href="/salesBook/index.jsp" id="back">
                <img src="images/back.png" width="40px">
            </a>
             <img id="user" src="images/user.png" alt="icono de usuario"
                 width=""/> 
        </div>
        <img id="logo" src="images/logo.png" />
    </body>
</html>
