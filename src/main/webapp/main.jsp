<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Startseite</title>
</head>
<body>
<ul>
	<shiro:notAuthenticated><li><a href="<c:url value="/simplelogin.jsp"/>">Login</a></li></shiro:notAuthenticated>
	<shiro:hasAnyRoles name="member,admin"><li><a href="<c:url value="/profile"/>">Mitgliederliste</a></li></shiro:hasAnyRoles>
	<shiro:authenticated><a href="<c:url value="/simplelogout.jsp"/>">Logout</a></shiro:authenticated>
</ul>
</body>
</html>
