<%--
  Created by IntelliJ IDEA.
  User: qnocks
  Date: 1/3/21
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/patients/update/${patient.id}">
        <label for="registrationNumber"> Registration Number
            <input type="text" id="registrationNumber" name="registrationNumber" value="${patient.registrationNumber}">
        </label>
        <label for="fullName"> Full name
            <input type="text" id="fullName" name="fullName" value="${patient.fullName}">
        </label>
        <label for="birthDate"> BirthDate
            <input type="text" id="birthDate" name="birthDate" value="${patient.birthDate}">
        </label>
        <label for="address"> Address
            <input type="text" id="address" name="address" value="${patient.address}">
        </label>
        <label for="job"> Job
            <input type="text" id="job" name="job" value="${patient.job}">
        </label>
        <input type="submit" value="Add">
    </form>
</body>
</html>
