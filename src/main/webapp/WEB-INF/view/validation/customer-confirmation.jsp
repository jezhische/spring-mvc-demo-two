<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>customer-confirmation</title>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />--%>
    <link rel="stylesheet" href=<c:url value="/static/css/customer-confirmationP.css"/>/>
</head>
<body>
<h1 align="center">Customer Confirmation Page</h1>
<br/><hr/><br/><br/>
<h3>
    The customer is confirmed: ${custy.firstName} ${custy.lastName}
    <br/><br/>
    Free passes: ${custy.freePasses}
    <br/><br/>
    Postal Code: ${custy.postalCode}
    <br/><br/>
    Course Code: ${custy.courseCode}
    <br/><br/>
    Alias: ${custy.alias}
    <br/><br/>
</h3>
<h2>
    <a href="${pageContext.request.contextPath}/customer/processForm">back to form page / </a>
    <a href="${pageContext.request.contextPath}">home</a>
</h2>
</body>
</html>
