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
        <header id="head">
            <a href="/salesBook/home.jsp"> <img id="back" src="images/back.png" width="70px">
        </header>
        <div>
            <a href="/salesBook/docType.jsp"><button> Tipo de Documento</button></a>
        </div>
        <br>
        <div id="container_form">
            <form method="post" action="/salesBook/InDoc">
                <%
                    DocumentTypeDao doc = new DocumentTypeDao();
                    %>
                    <select class="slct" name="item" required="true">
                        <option>Seleccione Documento</option>   
                    <%for(DocumentType fo: doc.getTipoDoc()) {%>
                    <option value="<%= fo.getId()  %>"><%= fo.getDocumentName() %></option>
                    
                    <%}%></select><br><br>
                <input id="dat" name="date" type="date" required="true" autofocus="true"/><br>
                <input id="number" name="serial" type="text" required="true" placeholder="No.serie"/>
                <input id="numero" name="numero" type="text" required="true" placeholder="0000"/>
                <input id="nitc" name="nit" type="text" required="true" placeholder="NIT"/>
                <input id="buyer" name="buyer" type="text" required="true" placeholder="CLIENTE"/>
                <input id="tot" name="total" type="number" required="true" value="" placeholder="Total" step="any" onChange="calculo(this.value,tot.value, iv, ex.checked, exenta)"><br>
                <div id="bol">
                    <label>Es exenta</label>
                    <input class="exOne" id="ex" name="exem" type="radio" value="1" onChange="calculo(this.value,tot.value, ex.checked, ex, exenta)"/>
                    <label>Normal</label>
                    <input class="exTwo" id="ex" name="exem" type="radio" value="2" onChange="calculo(this.value,tot.value, ex.checked, ex, exenta)"/>
                    <label>Anulada</label>
                    <input class="exTwo" id="ex" name="exem" type="radio" value="3" onChange="calculo(this.value,tot.value, ex.checked, ex, exenta)"/>
                </div>
                
                <br><br><br><br>
                <input id="exenta" name="exent" value="0" type="text" readonly=""><br>
                
                <input id="iv" name="iva" type="text" value="0" readonly=""> <br>
                <input id="net" name="neto" type="text" value="0" readonly=""><br>
                
                <br>
                <button id="buttonOne" type="reset">Cancelar</button>
                <button id="buttonTwo">Guardar</button>
            </form>
        </div>
                

        <img id="log" src="images/logo.png" width="350px">
        
        
        <script>
            //var is_exempt[] = 
           // var is_exempt = document.getElementById("ex").value;
            //var x=$("#checkbox").is(":checked");
            // var checkedValue = document.querySelector('.messageCheckbox:checked').value;
  
            
          /*  function funcBool(valor,bool,check){
                var is_exempt = true;
                console.log(valor,bool,check);
                
                if(check===true){
                    function calculo(){
                        console.log("ya va queriendo");
                }
            }
            }*/

            function calculo(valor,total,inputImpuesto,check, inputExempt, exenta){
                
                if(check==false){
                   
                    console.log(check);
                    console.log("NADA");
                    console.log("Buenas noches");
                
            }else{
                 if(valor==1){
                     var t = total;

                           document.getElementById("exenta").value=t;
                           document.getElementById("iv").value=0;
                           document.getElementById("net").value=0;
                    }
                    if(valor==2){
                           
                           var iva = 0.12;
                           var impuesto = total * iva;
                           var neto = total - impuesto;
                           
                           document.getElementById("exenta").value=0;
                           document.getElementById("iv").value=impuesto;
                           document.getElementById("net").value=neto;
                    }
                    if(valor==3){
                           
                           document.getElementById("exenta").value=0;
                           document.getElementById("iv").value=0;
                           document.getElementById("net").value=0;
                           document.getElementById("nitc").value="----";
                           document.getElementById("buyer").value="ANULADA";
                           document.getElementById("tot").value=0;
                    }


                
            }
            }
                
           /* } else{
              function calculo(valor,total,inputImpuesto){
              var iva = 0;
            
               console.log(valor, total, inputImpuesto);
                var impuesto = eval(inputImpuesto);
                inputImpuesto.value = iva;
            }
                    
            }*/

            
            </script>
    </body>
</html>
