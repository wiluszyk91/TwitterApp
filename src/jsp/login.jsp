<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="css/style.css">

<title>Login page</title>
</head>
<body>

<%
    if(session.getAttribute("wrong_uname_pass") != null){
%>
<script>
    alert("Invalid username or password");
</script>
<%
        session.removeAttribute("wrong_uname_pass");
    }
%>

<div class="wrapper">
    <div class="container">
        <jsp:include page="hello.jsp"></jsp:include>
        <h1>Welcome</h1>

        <form method="post" action="/login" class="form">
            <p>Login</p>
            <input type="text" name="login">
            <p>Password</p>
            <input type="password" name="password">

            <input type="submit" value="Login">

            <input type="hidden" name="backUrl" value="${param.backUrl}"/>

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