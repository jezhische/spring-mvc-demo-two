<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>

    <%--todo: ИСПОЛЬЗОВАНИЕ БИБЛИОТЕКИ ТЕГОВ SPRING:--%>
    <spring:url value="/static/css/homeP.css" var="hmP"/>
    <link href="${hmP}" rel="stylesheet">

    <%--todo: ИСПОЛЬЗОВАНИЕ БИБЛИОТЕКИ ТЕГОВ JSTL:--%>
    <script src="<c:url value="/static/js/alert.js"/>"></script>

</head>
<body>
    <h1>spring-mvc-demo-two home page</h1>
<br/><hr/><br/>
    <input type="button" value="Push me" onclick="doSomething()"/>

    <%--todo: ИСПОЛЬЗОВАНИЕ ОБЪЕКТОВ СОБСТВЕННО JSP:--%>
    <img src="${pageContext.request.contextPath}/static/spring-logo.png"
         width="200" height="100"
         alt="Иллюстрация" align="right"
         vspace="5" hspace="100"/>
    <%--здесь обращение к маппингу метода контролллера, а не к маппингу ресурсов--%>
    <h2><a href="${pageContext.request.contextPath}/hell/showForm">hell form</a></h2>
<h3><a href="${pageContext.request.contextPath}/stud/showForm">student-form</a> </h3>

</body>
</html>
