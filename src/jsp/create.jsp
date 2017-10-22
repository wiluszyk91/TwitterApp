<%@ page language="java" contentType="text/html;" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="wrapper">
    <div class="container">
<h1>Post Twitter</h1>

<jsp:include page="hello.jsp">
    <jsp:param value="1" name="pageNumber"/>
</jsp:include>

<c:if test="${not empty errors}">
    <c:forEach items="${errors}" var="error">
        <p><b>${error}</b></p>
    </c:forEach>
</c:if>

<form method="post" action="create">
    <p>Fill message</p>
    <input type="text" name="message" value="<c:out value="${message}" />">


    <p>Fill username</p>
    <input type="text" name="userName" value="<c:out value="${userName}"/>">

    <input class="btn btn-defuault" type="submit">

</form>
    </div>
    <ul class="bg-bubbles">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>

</body>


</html>