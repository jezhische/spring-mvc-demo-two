<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>student-confirmation</title>
    <link rel="stylesheet" href=<c:url value="/static/css/helloP.css"/>/>
</head>
<body>
    <h3>Student first name: ${student.name}
    <br/><br/>
    Student last name: ${student.surname}
    <br/><br/>
        Student country: ${student.country}
    <br/><br/>
    Student favorite rock band: ${student.favoriteRockBand}
    <br/><br/>
    Student favorite dish: ${student.favoriteDish}
    </h3>
    <br/><br/><hr/><br/><br/>
    <h2 align="center"><a href="${pageContext.request.contextPath}/stud/showForm">back to submit page \ </a>
        <a href="${pageContext.request.contextPath}">home</a>
    </h2>
</body>
</html>