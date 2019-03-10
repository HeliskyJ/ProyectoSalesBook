<%-- 
    Document   : records
    Created on : 05-mar-2019, 18:37:58
    Author     : hely
--%>


<%@page import="com.models.Buyer"%>
<%@page import="com.dao.BuyerDao"%>
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
            <a href="/salesBook/buyer.jsp"><button> Compradores</button></a><br><br>
            <a href="/salesBook/docType.jsp"><button> Tipo de Documento</button></a>
        </div>
        <br>
        <div id="container_form">
            <form method="post" action="/salesBook/InDoc">
                <input id="dat" name="date" type="date" required="true" autofocus="true"/><br>
                <input id="number" name="serial" type="text" required="true" placeholder="No.serie"/>
                <br><br><br><br><br>
                <div id="bol">
                    <label>Es exenta</label>
                    <input class="exOne" id="ex" name="exem" type="checkbox"
                           checked="false"
                           value="0" onChange="calculo(this.val,ex.value, ex.checked, ex)"/>Si
                </div>
                <input id="tot" name="total" type="number" 
                       required="true" value="" placeholder="Total" step="any"
                       onChange="calculo(this.value,tot.value, iv, ex.checked)"><br>
                
                <input id="iv" name="iva" type="text" value="0"> <br>
                <%
                    BuyerDao buy = new BuyerDao();
                    %> 
                    <select name="buy">
                        <% for(Buyer compr: buy.getBuyers()) {%>
                        
                        <option value="<%= compr.getId()  %>"><%= compr.getFullName() %></option>

                <% }%></select>
               
                <hr>
                
                <%
                    DocumentTypeDao doc = new DocumentTypeDao();
                    %>
                    <select name="item">
                    <%for(DocumentType fo: doc.getTipoDoc()) {%>
                       
                    <option value="<%= fo.getId()  %>"><%= fo.getDocumentName() %></option>
                <%}%></select>
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
    function display(field)
{
   for (var i=0; i < field.length; i++)
   if (field[i].checked)
   alert('Check '+i+' with value of '+field[i].value);
      
}
            
            function calculo(valor,total,inputImpuesto,check, inputExempt){
                
                if(check==true){
            
                    console.log(check);
      console.log("NADA");
                
            }else{
          
              var iva = 0.12;
              var totl = total * iva;
               
                var impuesto = eval(inputImpuesto);
                inputImpuesto.value = totl;
                
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
