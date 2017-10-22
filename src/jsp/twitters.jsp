<%@ page language="java" contentType="text/html;" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <link rel="stylesheet" href="css/twitters.css">
</head>
<body>
    <nav id="nav">
        <ul>
            <li><a href="/favourite_tweets">Favourite Twitts</a></li>
            <li><a href="/create">Create Tweet</a></li>
            <li><a href="/logout">Logout</a></li>
        </ul>
    </nav>


<jsp:include page="message.jsp"></jsp:include>

<jsp:include page="hello.jsp">
    <jsp:param value="2" name="pageNumber"/>
</jsp:include>

<h1>Twitter List : </h1>
<c:forEach items="${twitters}" var="twitt">


    <p style="overflow: auto">${twitt.message}</p>
    <p>Created by ${twitt.userName}  on ${twitt.dateOfCreation}</p>
    </div>
    <c:if test="${twitt.favouriteTweet == false}">
        <form method="post" action="/favourite_tweets">
            <input type="hidden" name="twitt_id" value="${twitt.id}"/>
            <input type="submit" value="Add to favourites" >
        </form>
    </c:if>
</c:forEach>

</body>


</html>