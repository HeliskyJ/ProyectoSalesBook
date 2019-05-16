<%-- 
    Document   : consDate
    Created on : 17-mar-2019, 18:11:32
    Author     : hely
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/dteListStyle.css" type="text/css">
        <title>Fechas</title>
    </head>
    <body>
        <header id="he">
        </header>
        <div id="container">
            <a href="/salesBook/home.jsp"> <img id="back" src="images/back.png" width="70px"> </a>
            <form method="get" action="/salesBook/DoctCons">
                <select class="slct" name="year" id="year" autofocus="">
                    <option value="">Año</option>
                </select>

                <select class="slct" name="month" id="month" >
                    <option value="" >Mes</option>
                </select>     

                <button class="but"> Detalle</button>
            </form>
        </div>
    </body>

    <script type="text/javascript">
        for (y = 2015; y <= 2050; y++) {
            var optn = document.createElement("OPTION");
            optn.text = y;
            optn.value = y;

            // if year is 2019 selected
            if (y == 2019) {
                optn.selected = true;
            }

            document.getElementById('year').options.add(optn);
        }
    </script>

    <script type="text/javascript">
        var d = new Date();
        var monthArray = new Array();
        monthArray[0] = "Enero";
        monthArray[1] = "Febrero";
        monthArray[2] = "Marzo";
        monthArray[3] = "Abril";
        monthArray[4] = "Mayo";
        monthArray[5] = "Junio";
        monthArray[6] = "Julio";
        monthArray[7] = "Agosto";
        monthArray[8] = "Septiembre";
        monthArray[9] = "Octubre";
        monthArray[10] = "Noviembre";
        monthArray[11] = "Diciembre";
        for (m = 0; m <= 11; m++) {
            var optn = document.createElement("OPTION");
            optn.text = monthArray[m];
            // server side month start from one
            optn.value = (m + 1);

            // if june selected
            if (m == 0) {
                optn.selected = true;
            }

            document.getElementById('month').options.add(optn);
        }
    </script>

</html>

