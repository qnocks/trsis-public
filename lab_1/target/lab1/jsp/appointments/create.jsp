<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/appointments/create">
        <label for="patientId"> Patient id
            <input type="text" id="patientId" name="patientId">
        </label>
        <label for="doctorId"> Doctor id
            <input type="text" id="doctorId" name="doctorId">
        </label>
        <label for="date"> Appointment Date
            <input type="text" id="date" name="date">
        </label>
        <label for="time"> Appointment Time
            <input type="text" id="time" name="time">
        </label>
        <input type="submit" value="Add">
    </form>
</body>
</html>
