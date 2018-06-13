<%--
  Created by IntelliJ IDEA.
  User: nlosada
  Date: 17/05/18
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

    <jsp:include page="./navbar.jsp"></jsp:include>
    Hola soy la pagina Hello
    <a href="${contextPath}/student">Ir a Estudiantes</a>
</body>
</html>
