<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/twitters.css">
	<title>Favourite Twitts</title>
</head>
<body>
<nav id="nav">
	<ul>
		<li><a href="/all">Twitters</a></li>
		<li><a href="/create">Create Tweet</a></li>
		<li><a href="/logout">Logout</a></li>
	</ul>
</nav>
<h1>Favourite twitts list : </h1>
<c:forEach items="${favouriteTwitts}" var="twitt">
	<p style="overflow: auto">${twitt.message}</p>
	<p>Created by ${twitt.userName}  on ${twitt.dateOfCreation}</p>
	<div class="line-separator"></div>
</c:forEach>
</body>
</html>