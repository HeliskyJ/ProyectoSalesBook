<%-- 
    Document   : records
    Created on : 05-mar-2019, 18:37:58
    Author     : hely
--%>


<%@page import="java.util.List"%>
<%@page import="com.dao.DocumentTypeDao"%>
<%@page import="com.conexion.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.models.DocumentType"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleRecord.css" type="text/css">
        <title>Registros</title>
    </head>
    <body>

        <br>
        <div id="container_form">
            <a href="/salesBook/home.jsp"> <img id="back" src="images/back.png" width="90px"> </a>
            <form method="post" action="/salesBook/InDoc" autocomplete="off">
                <%
                    DocumentTypeDao doc = new DocumentTypeDao();
                %>
                <select class="slct" name="item" required="true">
                    <option>Seleccione Documento</option>   
                    <%for (DocumentType fo : doc.getTipoDoc()) {%>
                    <option value="<%= fo.getId()%>"><%= fo.getDocumentName()%></option>

                    <%}%></select><br><br>
                <input id="dat" name="date" type="date" required="true" autofocus="true"/>
                <input id="number" name="serial" type="text" required="true" placeholder="No.serie"/>
                <input id="numero" name="numero" type="text" required="true" placeholder="0000"/>
                <input id="nitc" name="nit" type="text" required="true" placeholder="NIT"/>
                <input id="buyer" name="buyer" type="text" required="true" placeholder="CLIENTE"/>
                <input id="tot" name="total" type="number" required="true" value="" placeholder="Total" step="any" onChange="calculo(this.value, tot.value, iv, ex.checked, exenta)">
                <div id="bol">
                    <label>Es exenta</label>
                    <input class="exOne" id="ex" name="exem" type="hidden" value="0" onChange="calculo(this.value, tot.value, ex.checked, ex, exenta)"/>
                    <input class="exOne" id="ex" name="exem" type="radio" value="1" onChange="calculo(this.value, tot.value, ex.checked, ex, exenta)"/>
                    <label>Normal</label>
                    <input class="exTwo" id="ex" name="exem" type="radio" value="2" checked="" onChange="calculo(this.value, tot.value, ex.checked, ex, exenta)"/>
                    <label>Anulada</label>
                    <input class="exTwo" id="ex" name="exem" type="radio" value="3" onChange="calculo(this.value, tot.value, ex.checked, ex, exenta)"/>
                </div>

                <br><br><br><br>
                <input id="exenta" name="exent" value="" type="text" readonly="" placeholder=" Valor exento" required="true">

                <input id="iv" name="iva" type="text" value="" readonly="" placeholder="IVA" required="true"> 
                <input id="net" name="neto" type="text" value="" readonly="" placeholder="Valor neto" required="true">

                <br>
                <button id="buttonOne" type="reset">Cancelar</button>
                <button id="buttonTwo">Guardar</button>
            </form>
        </div>

        <script>


            function calculo(valor, total, inputImpuesto, check, inputExempt, exenta) {

                if (valor == 1) {
                    var t = total;

                    document.getElementById("exenta").value = t;
                    document.getElementById("iv").value = 0;
                    document.getElementById("net").value = 0;
                } else if (valor == 2) {

                    var iva = 0.12;
                    var impuesto = total * iva;
                    var neto = total - impuesto;

                    document.getElementById("exenta").value = 0;
                    document.getElementById("iv").value = impuesto;
                    document.getElementById("net").value = neto;
                } else if (valor == 3) {

                    document.getElementById("exenta").value = 0;
                    document.getElementById("iv").value = 0;
                    document.getElementById("net").value = 0;
                    document.getElementById("nitc").value = "----";
                    document.getElementById("buyer").value = "ANULADA";
                    document.getElementById("tot").value = 0;
                } else if (valor == 0) {
                    console.log(check + "LOCAPTURA");
                }
            }

        </script>
    </body>
</html>