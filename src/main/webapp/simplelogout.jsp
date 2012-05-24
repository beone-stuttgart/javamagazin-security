<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logout</title>
</head>
<body>
<h1>Logout</h1>
<% SecurityUtils.getSubject().logout();%>
Erfolgreich abgemeldet. <a href="<c:url value="/"/>">Zurück zur Startseite</a>.
</body>
</html>