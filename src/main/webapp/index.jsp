<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nlosada
  Date: 17/05/18
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Curso Spring</title>
  </head>
  <body>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

    <jsp:include page="./WEB-INF/jsp/navbar.jsp"></jsp:include>
  </body>
</html>
