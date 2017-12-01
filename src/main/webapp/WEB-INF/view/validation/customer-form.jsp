<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>customer-form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <spring:url value="/static/css/customer-formP.css" var="cSs"/>
    <link href="${cSs}" rel="stylesheet"/>
    <%--создание .error класса я вынес в css--%>
    <%--<style>--%>
        <%--.error {color: red}--%>
    <%--</style>--%>
</head>
<body>
<h2>Customer Form Page</h2>
<br/><hr/>
<br/>
<h3><i>The fields marked with asterisk (*) are required</i></h3>
<h4><form:form action="${pageContext.request.contextPath}/customer/processForm" modelAttribute="custy">
    <br/><br/>
    Customer first name: <form:input path="firstName"/>
    <br/><br/>
    Customer last name *: <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br/><br/>
    Free passes *: <form:input path="freePasses"/>
    <form:errors path="freePasses" cssClass="error"/>
    <br/><br/>
    Postal code: <form:input path="postalCode"/>
    <form:errors path="postalCode" cssClass="error"/>
    <br/><br/>
    Course Code: <form:input path="courseCode"/>
    <form:errors path="courseCode" cssClass="error"/>
    <br/><br/>
    Alias: <form:input path="alias"/>
    <form:errors path="alias" cssClass="error"/>
    <br/><br/>
    <input type="submit" value="Submit"/>
    <br/><br/>
</form:form></h4>
<h4><a href="${pageContext.request.contextPath}">home</a></h4>
</body>
</html>
