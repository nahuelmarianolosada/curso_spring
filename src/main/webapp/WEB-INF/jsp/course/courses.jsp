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
            <a href="${contextPath}/course/new" class="btn btn-outline-primary" style="margin: 10px 10px 10px 0px;" >Nuevo</a>
        </div>
    </div>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <td scope="col">ID</td>
            <td scope="col">NOMBRE</td>
            <td scope="col">LUGAR</td>
            <td scope="col"></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach  items="${courses}" var="course">
            <tr>
                <th scope="row">${course.id}</th>
                <td>${course.signature}</td>
                <td>${course.place}</td>
                <td><button id="btnShowStudents" type="button" class="btn btn-outline-danger" data-toggle="modal" data-id="${course.id}" data-target="#mdlShowStudents">Inscriptos</button>
                    <a href="${contextPath}/course/update/${course.id}" class="btn btn-outline-primary" style="margin: 10px 10px 10px 0px;" >Editar</a>
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
                <h5 class="modal-title" id="exampleModalLongTitle">Inscriptos</h5>
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
    $(document).on("click", "#btnShowStudents", function () {
        var courseId = $(this).data('id');
        $(".modal-body").html("");
        getStudentsByCourse(courseId);
    });


    function getStudentsByCourse(id){
        $.ajax({
            url: "http://localhost:8080/pruebas/api/student/byCourse/" + id,
            type: 'GET',
            ContentType: "application/json",
            success: function(result) {
                if(result != undefined || result != null){
                    for (var i = 0; i<result.length ; i++){
                        addNewCardWithStudent(result[i]);
                    };
                }
                var cantidadResultados = result === undefined || result === null ? 0 : result.length;
                $('.modal-title').html("Cantidad de inscriptos: " + cantidadResultados);
            },
            error: function(e){
                debugger;
                console.log(e);
            }
        });}


        function addNewCardWithStudent(student) {
            var card = '<div class="card" style="width: 18rem;">' +
                            '<div class="card-body"> ' +
                                '<h5 class="card-title"> ' +
                                    '(' + student.id + ') ' + student.firstName + ' ' + student.lastName +
                                '</h5>' +
                                '<p class="card-text">' +
                                    formatDate(new Date(student.birthday)) +
                                '</p>' +
                            '</div>' +
                        '</div>';

            /*var content = $('.modal-body');*/

            $('.modal-body').append(card);

            /* return
                'div class="card" style="width: 18rem;">' +
                    '<div class="card-body"> ' +
                        '<h5 class="card-title">' +
                        student.id +
                        '</h5>' +
                    '<p class="card-text">' +
                        student.firstName
                    '</p>' +
                    '<a href="#" class="btn btn-primary">Go somewhere</a>' +
                    '</div>' +
                '</div>';*/
           /* return student.id + ' ' + student.firstName+ ' ' + student.lastName + ' ' + formatDate(new Date(student.birthday));*/
        }


    function formatDate(date) {
        var monthNames = [
            "Enero", "Febrero", "Marzo",
            "Abril", "Mayo", "Junio", "Julio",
            "Agosto", "Septiembre", "Octubre",
            "Noviembre", "Diciembre"
        ];

        var day = date.getDate();
        var monthIndex = date.getMonth();
        var year = date.getFullYear();

        return day + ' ' + monthNames[monthIndex] + ' ' + year;
    }

</script>


</body>
</html>
