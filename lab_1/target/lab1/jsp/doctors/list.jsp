<%@ page contentType="text/html;charset=UTF-8" %>
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
            <th>FullName</th>
            <th>Specialty</th>
            <th>Schedule</th>
            <th></th>
        </tr>
        <c:forEach items="${doctors}" var="doctor">
            <tr>
                <td>${doctor.id}</td>
                <td>${doctor.fullName}</td>
                <td>${doctor.specialty}</td>
                <td>${doctor.schedule}</td>
                <td><a href="${pageContext.servletContext.contextPath}/doctors/delete/${doctor.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/doctors/create">Add new doctor</a>
</body>
</html>
