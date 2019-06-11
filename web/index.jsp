<%-- 
    Document   : index
    Created on : 10-jun-2019, 18:56:01
    Author     : Informatica
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="javax.naming.InitialContext"%>
<%@page import="beans.ServicioLocal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! private ServicioLocal servicio; %>
        <%
            InitialContext ctx=new InitialContext();
            servicio=(ServicioLocal)
                ctx.lookup("java:global/pets_3331/Servicio!beans.ServicioLocal");
            %>
            
            <c:set var="productos" scope="page" value="<%=servicio.getProductos()%>"/>
        <h1>Productos</h1>
        <c:forEach items="${pageScope.productos}" var="p">
            ${p.nombreProducto}, ${p.precioProducto}
        </c:forEach>
    </body>
</html>
