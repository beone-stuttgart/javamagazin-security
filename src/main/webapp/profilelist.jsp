<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="javamag.dao.ProfileDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
ProfileDao dao = (ProfileDao)ctx.getBean("profileDao");
request.setAttribute("logins", dao.getAllLogins());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profilliste</title>
</head>
<body>
	<h1>Profilliste</h1>
	<ul>
	<c:forEach items="${logins}" var="login"> 
		<li><a href="<c:url value="/profile/${login}"/>">${login}</a></li>
	</c:forEach>
	</ul>
</body>
</html>
