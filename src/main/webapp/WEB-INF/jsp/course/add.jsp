<%--
  Created by IntelliJ IDEA.
  User: nlosada
  Date: 05/06/18
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <title>New Student</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/jsp/navbar.jsp"></jsp:include>

<div class="container" style="margin-left: 50px; max-width: 50%;">
    <form:form action="./addCourse" method="post" modelAttribute="course" >
        <form:hidden path="id"/>
        <div class="form-group row">
            <label for="ipt_signature" class="col-2 col-form-label">Nombre</label>
            <div class="col-10">
                <form:input id="ipt_signature" path="signature"/>
            </div>
        </div>

        <div class="form-group row">
            <label for="ipt_place" class="col-2 col-form-label">Lugar</label>
            <div class="col-10">
                <form:input id="ipt_place" path="place"/>
            </div>
        </div>


        <div class="form-group row">
            <div class="col-4">
                <a href="${contextPath}/course" class="btn btn-outline-primary"  >Volver</a>
            </div>
            <div class="col-8">
                <button type="submit" class="btn btn-outline-primary">Guardar</button>
            </div>
        </div>

    </form:form>
</div>


</body>
</html>
