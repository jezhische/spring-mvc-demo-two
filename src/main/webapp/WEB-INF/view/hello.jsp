<%--
  Created by IntelliJ IDEA.
  User: Элеонора
  Date: 16.11.2017
  Time: 6:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>hello page</title>
    <spring:url value="/static/css/helloP.css" var="csS"/>
    <link href="${csS}" rel="stylesheet">
</head>
<body>
<p>Message from jsp Map param.: Hello, ${param.name} ${param.surname}</p>
<p>Message from HttpServletRequest + Model: ${message}</p>
<p>Message from @RequestParam + Model: ${fromRequestParam}</p>
<%--todo: доступ к полям атрибута модели "student" спринг получает через ГЕТТЕРЫ--%>
<p>Message from autowired Student bean: Yo, man! ${student.name} ${student.surname}, bro!</p>
<p></p>
<%--либо пишем просто "showForm", если в приложении только один метод с таким названием--%>
<h3 align="left"><a href="${pageContext.request.contextPath}/hell/showForm">back to submit page</a>
    <p align="right"><a href="${pageContext.request.contextPath}">home</a></p></h3>
<%--<h3 align="right"><a href="${pageContext.request.contextPath}">home</a> </h3>--%>
</body>
</html>
