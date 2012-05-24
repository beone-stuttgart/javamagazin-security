<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Startseite</title>
</head>
<body>
<ul>
	<li><a href="<c:url value="/spring_security_login"/>">Login</a></li>
	<li><a href="<c:url value="/profile"/>">Mitgliederliste</a></li>
	<li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
</ul>
</body>
</html>
