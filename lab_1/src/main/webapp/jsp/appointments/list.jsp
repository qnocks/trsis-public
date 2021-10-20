<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/">Home</a>
    <table>
        <tr>
            <th>Id</th>
            <th>Patient id</th>
            <th>Doctor id</th>
            <th>Appointment Date</th>
            <th>Appointment Time</th>
            <th></th>
        </tr>
        <c:forEach items="${appointments}" var="appointment">
            <tr>
                <td>${appointment.id}</td>
                <td>${appointment.doctorId}</td>
                <td>${appointment.patientId}</td>
                <td>${appointment.date}</td>
                <td>${appointment.time}</td>
                <td><a href="${pageContext.request.contextPath}/appointments/delete/${appointment.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/appointments/create">Add new appointments</a>
</body>
</html>
