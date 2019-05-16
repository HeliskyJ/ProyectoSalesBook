<%-- 
    Document   : index
    Created on : 04-mar-2019, 21:59:13
    Author     : hely
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleUser.css" type="text/css">
        <title>Login</title>
    </head>
    <body>

        <div id="formul">
            <a href="/salesBook/register.jsp" id="plus">
                <img src="images/plus.png" width="90px">
            </a>
            <img id="user" src="images/user.png" alt="icono de usuario">
            <br>
            <form autocomplete="off" method="post" action="/salesBook/log" draggable="false" >
                <input id="inputOne" name="user" type="text" required="true" 
                       placeholder="Username" maxlength="35" autofocus/>
                <br>
                <input id="inputTwo" name="password" type="password" 
                       required="true" placeholder="Password" maxlength="35"/>
                <br>
                <button >Ingresar </button>
            </form>
        </div>
        <footer id="foot"></footer>
    </body>
</html>
