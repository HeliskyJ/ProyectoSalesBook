<%-- 
    Document   : detailDoc
    Created on : 17-mar-2019, 17:01:01
    Author     : hely
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${dots.docName} ${dots.serie}${dots.no_doc}</title>
    </head>
    <body>
        <form method="post" action="/salesBook/Change">
            <input name="id" type="hidden" value="${dots.id}">
            <input name="date" type="text" value="${dots.documentDate}" disabled=""><br>
            <input name="serie" type="text" value="${dots.serie}" disabled=""><br>
            <input name="numero" type="text" value="${dots.no_doc}" disabled=""><br>
            <input name="exempt" type="text" value="${dots.exempt}" disabled=""><br>
            <input name="total" type="text" value="${dots.total}" disabled=""><br>
            <input name="iva" type="text" value="${dots.iva}" disabled=""><br>
            <input name="net" type="text" value="${dots.net}" disabled=""><br>
            <input name="nit" type="text" value="${dots.buyNit}" disabled=""><br>
            <input name="buyer" type="text" value="${dots.buyer}" disabled=""><br>
            <input name="doc" type="text" value="${dots.docName}" disabled=""><br>
            <label>Anular</label>
            <input name="status" type="checkbox" >
            <button>Actualizar</button>
        </form>
        <button  onclick="location.href = 'bookList.jsp'">Regresar</button>
    </body>
</html>