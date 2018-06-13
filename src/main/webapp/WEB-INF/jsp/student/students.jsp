<%--
  Created by IntelliJ IDEA.
  User: nlosada
  Date: 24/05/18
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Students List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/jsp/navbar.jsp"></jsp:include>

<div class="container" style="margin-left: 50px; max-width: 50%;">
    <div class="row">
        <div class="col align-self-end">
            <a href="${contextPath}/student/new" class="btn btn-outline-primary" style="margin: 10px 10px 10px 0px;" >Nuevo</a>
        </div>
    </div>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <td scope="col">ID</td>
            <td scope="col">NOMBRE</td>
            <td scope="col">APELLIDO</td>
            <td scope="col">NACIMIENTO</td>
            <td scope="col"></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach  items="${students}" var="student">
            <tr>
                <th scope="row">${student.id}</th>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td><fmt:formatDate value="${student.birthday}" pattern="dd-MM-yyyy" /></td>
                <td><button id="btnConfirmDelete" type="button" class="btn btn-outline-danger" data-toggle="modal" data-id="${student.id}" data-target="#mdlConfirmDelete">Delete</button>
                    <a href="${contextPath}/student/update/${student.id}" class="btn btn-outline-primary" style="margin: 10px 10px 10px 0px;" >Editar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<hr />



<!-- Modal CONFIRM DELETE STUDENT -->
<div class="modal fade" id="mdlConfirmDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Eliminar Estudiante</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Confirma eliminar el estudiante
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Volver</button>
                <button id="btnDeleteStudent" type="button" class="btn btn-danger" >Aceptar</button>
            </div>
        </div>
    </div>
</div>



<script src="https://code.jquery.com/jquery-3.3.1.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

<script>
    $(document).on("click", "#btnConfirmDelete", function () {
        var studentId = $(this).data('id');
        $(".modal-body").append(" " + studentId + "?");
        $("#btnDeleteStudent").click(function(){deleteStudent(studentId)});
    });


    function deleteStudent(id){
        $.ajax({
            url: "http://localhost:8080/pruebas/student/" + id,
            type: 'DELETE',

            success: function(result) {
                // Do something with the result
            }
        });
    }
</script>


</body>
</html>
