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
            <a href="${contextPath}/professor/new" class="btn btn-outline-primary" style="margin: 10px 10px 10px 0px;" >Nuevo</a>
        </div>
    </div>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <td scope="col">ID</td>
            <td scope="col">NOMBRE</td>
            <td scope="col">APELLIDO</td>
            <td scope="col">NACIMIENTO</td>
            <td scope="col">TITULO</td>
            <td scope="col"></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach  items="${professors}" var="professor">
            <tr>
                <th scope="row">${professor.id}</th>
                <td>${professor.firstName}</td>
                <td>${professor.lastName}</td>
                <td><fmt:formatDate value="${professor.birthday}" pattern="dd-MM-yyyy" /></td>
                <td>${professor.jobTitle}</td>
                <td><button id="btnShowCourses" type="button" class="btn btn-outline-secondary" data-toggle="modal" data-id="${professor.id}" data-target="#mdlShowStudents" >Cursos</button>
                    <a href="${contextPath}/professor/update/${professor.id}" class="btn btn-outline-primary" style="margin: 10px 10px 10px 0px;" >Editar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<hr />



<!-- Modal CONFIRM DELETE STUDENT -->
<div class="modal fade" id="mdlShowStudents" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Cursos que dicta el profesor</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Volver</button>
            </div>
        </div>
    </div>
</div>



<script src="https://code.jquery.com/jquery-3.3.1.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

<script>
    $(document).on("click", "#btnShowCourses", function () {
        var professorId = $(this).data('id');
        $(".modal-body").html("");
        getStudentsByCourse(professorId);
    });


    function getStudentsByCourse(id){
        $.ajax({
            url: "http://localhost:8080/pruebas/api/course/byProfessor/" + id,
            type: 'GET',
            ContentType: "application/json",
            success: function(result) {
                if(result != undefined || result != null) {
                    for (var i = 0; i < result.length; i++) {
                        addNewCardWithCourse(result[i]);
                    }
                }
            },
            error: function(e){
                debugger;
                console.log(e);
            }
        });}


        function addNewCardWithCourse(course) {
            var card = '<div class="card" style="width: 18rem;">' +
                            '<div class="card-body"> ' +
                                '<h5 class="card-title"> ' +
                                    '(' + course.id + ') ' + course.signature + ' ' + course.place+
                                '</h5>' +
                                /*'<p class="card-text">' +
                                    formatDate(new Date(course.birthday)) +
                                '</p>' +*/
                            '</div>' +
                        '</div>';


            $('.modal-body').append(card);
        }

</script>


</body>
</html>
