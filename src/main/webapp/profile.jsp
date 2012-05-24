<%@page import="javamag.dao.ProfileDaoImpl"%>
<%@page import="javamag.dao.ProfileDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String uriparts[] = request.getRequestURI().split("/");
ProfileDao dao = ProfileDaoImpl.getInstance();
request.setAttribute("login", dao.findByName(uriparts[uriparts.length-1]));
if (request.getAttribute("login")==null) {
	response.sendError(HttpServletResponse.SC_NOT_FOUND);
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profilseite von ${login.name}</title>
</head>
<body>
	<h1>Profilseite von ${login.name}</h1>
	<p>${login.description}</p>
	<p><a href="<c:url value="/profile/edit/${login.login}"/>">Profil bearbeiten</a></p>
</body>
</html>