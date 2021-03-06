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

    <h4>
        <%--The fields marked with asterisk (*) are required--%>
        <br/><br/>
    <form:form action="${pageContext.request.contextPath}/stud/processFormi" modelAttribute="student">
        First name:       <form:input path="name"/>
        <br/><br/>
        Last name(*):    <form:input path="surname"/>
        <%--<form:errors path="surname" cssClass="error"/>--%>
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
            <%--здесь для наполнения выпадающего списка обращаемся к map, созданной в объекте student--%>
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
        Favorite language:
        <%--поле private String favoriteLanguage бина student будет назначено через сеттер--%>
        <%--мы можем прописать каждую radiobutton вот так:--%>
        <%--Java<form:radiobutton path="favoriteLanguage" value="Java 8 the best!"/>--%>
        <%--или добавить все кнопки списком, обратившись к атрибуту модели:--%>
        <form:radiobuttons path="favoriteLanguage" items="${theFavLangOptions}"/>
        <br/><br/>
        Favorite OS:
        <%--здесь обращаемся к атрибуту класса student и передаем все кнопки списком--%>
        <form:checkboxes path="favoriteOpSystems" items="${student.favOSOptions}"/>
        <br/><br/>
        <input type="submit" value="SUBMIT"/>
        <br/><br/>
    </form:form>
    </h4>
    <hr/><br/><br/>
    <a href="${pageContext.request.contextPath}"><h3>home</h3></a>
    </body>
</html>
