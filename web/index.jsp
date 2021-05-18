<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           <h4 align="right"> <a href="login.jsp">Salir</a></h4>
        <h1 align="center">Blog de salud</h1>
        <a href="Controlador?action=add">Nueva entrada</a>    
        <br>
    <c:forEach var="item" items="${posts}">
       
        <p>
           ${item.fecha}
        </p>
        <p>
           <h2>${item.titulo}</h2> 
        </p>
        <p>
           ${item.contenido}
        </p>
        <a href="Controlador?action=edit&id=${item.id}">Editar</a>
        <a href="Controlador?action=delete&id=${item.id}">Eliminar</a>
        <hr>
    </c:forEach>
    </body>
</html>
