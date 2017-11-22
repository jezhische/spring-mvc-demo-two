<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title>student-form</title>
<spring:url value="/static/css/hello-formP.css" var="cSs"/>
    <link href="${cSs}" rel="stylesheet">
</head>
    <body>
    <h1 align="center">Student-form version 2</h1>

    <form:form action="${pageContext.request.contextPath}/stud/processFormi" modelAttribute="student">
        Student name:       <form:input path="name"/>
        <br/><br/>
        Student surname:    <form:input path="surname"/>
        <br/><br/>
        Country:
        <%--value -значение, которое будет передано модели; label - то, что показывается в списке--%>
        <form:select path="country">
            <form:option value="Brazil" label="BR"/>
            <form:option value="France" label="FR"/>
            <form:option value="Germany" label="DE"/>
            <form:option value="India" label="IN"/>
        </form:select>
        <br/><br/>
        Favorite Rock Band:
        <form:select path="favoriteRockBand">
            <form:options items="${student.favoriteRockBandOptions}"/>
        </form:select>
        <br/><br/>
        <%--здесь заполняем поле String favoriteDish объекта student одним из значений из выпадающего списка:--%>
        Favorite dish:
            <form:select path="favoriteDish">
                <%--а здесь для наполнения выпадающего списка обращаемся к атрибуту модели, причем значения берутся из
                проперти файла - см. CStudentController:--%>
                <form:options items="${theFavDishOptions}"/>
            </form:select>
        <br/><br/>
        <input type="submit" value="SUBMIT"/>
        <br/><br/>
    </form:form>
    <hr/><br/><br/>
    <a href="${pageContext.request.contextPath}"><h3>home</h3></a>
    </body>
</html>
