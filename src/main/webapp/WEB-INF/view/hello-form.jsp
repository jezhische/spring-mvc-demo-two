<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form</title>
<%--todo: ${pageContext.request.contextPath} - это обращение к задеплоенному в томкат приложению, к контейнеру в томкат,
следовательно, его значение "localhost:8083/mvc/"--%>
    <link href="${pageContext.request.contextPath}/static/css/hello-formP.css" rel="stylesheet">
</head>
<body>
<%--todo: NB: должно быть "processForm", а не "/processForm", поскольку "/" делает path АБСОЛЮТНЫМ, а НЕ ОТНОСИТЕЛЬНЫМ
к @RequestMapping("/hell") перед КЛАССОМ контроллера и к корневому "/mvc", как это нам нужно. В результате получаем запрос
не http://localhost:8083/mvc/hell/processForm?name=fffdfd
а  http://localhost:8083/processForm?name=fffdfd
todo: однако, если в приложении больше одного метода с именем "processForm", то "${pageContext.request.contextPath}/hell/processForm"
Здесь используется form из html, если я не ошибаюсь--%>
<form action="processForm" method="get">
    <input type="text" name="name" placeholder="name"/> <br/>
    <input type="text" name="surname" placeholder="surname"/>
    <input type="submit" value="Try And Go!"/>
    <br/><br/><hr/>
</form>
<%--А вот здесь используется спринговский тег form
todo:NB: модель и ее атрибут "student" УЖЕ СОЗДАНЫ в методе "showForm", который возвращает эту страничку "hello-form"--%>
<form:form action="${pageContext.request.contextPath}/hell/processForm" modelAttribute="student">
    <%--здесь path="name" и "surname" - это property (поля) класса StudentImpl - т.е. туда отправляем value этих input--%>
<%--todo: начальное (дефолтное) значение полей атрибута модели "student" спринг здесь получает через ГЕТТЕРЫ, а заполняет
поля с помощью СЕТТЕРОВ--%>
    First name: <form:input path="name"/>
    <br><br>
    Last name: <form:input path="surname"/>
    <br><br>
    <input type="submit" value="Submit">

</form:form>

<h3><a href="${pageContext.request.contextPath}">home</a></h3>
</body>
</html>
