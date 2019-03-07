<%-- 
    Document   : records
    Created on : 05-mar-2019, 18:37:58
    Author     : hely
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleRecord.css" type="text/css">
        <title>Registros</title>
    </head>
    <body>
        <header id="head">
            <a href="/salesBook/home.jsp"> <img id="back" src="images/back.png" width="70px">
        </header>
        <div>
            <a href="/salesBook/buyer.jsp"><button> Compradores</button></a><br><br>
            <a href="/salesBook/docType.jsp"><button> Tipo de Documento</button></a>
        </div>
        <br>
        <div id="container_form">
            <form>
                <input id="dat" name="date" type="date" required="true" autofocus="true"/><br>
                <input id="number" name="serial" type="text" required="true" placeholder="No.serie"/>
                <br><br><br><br><br>
                <div id="bol">
                    <label>Es exenta</label>
                    <input id="ex" name="buyer" type="checkbox" value="true"/>
                </div>
                <input id="tot" name="total" type="number" required="true" placeholder="Total"><br>
                <input id="iv" name="iva" type="number" placeholder="IVA"  disabled="true"> <br>
                <input name="buyer" type="text" required="true" placeholder="Comprador"/><br>
                <input name="docType" type="text" required="true" placeholder="Tipo de Documento"/>
                <br>
                <button id="buttonOne">Cancelar</button>
                <button id="buttonTwo">Guardar</button>
            </form>
        </div>
        <img id="log" src="images/logo.png" width="350px">
    </body>
</html>
