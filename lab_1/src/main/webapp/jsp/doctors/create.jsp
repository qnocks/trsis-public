<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/doctors/create">
    <label for="fullName"> Full name
        <input type="text" id="fullName" name="fullName">
    </label>
    <label for="specialty"> Specialty
        <input type="text" id="specialty" name="specialty">
    </label>
    <label for="officeNumber"> OfficeNumber
        <input type="text" id="officeNumber" name="officeNumber">
    </label>
    <label for="schedule"> Schedule
        <input type="text" id="schedule" name="schedule">
    </label>
    <input type="submit" value="Add">
</form>
</body>
</html>