<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="javamag.model.Profile"%>
<%@page import="javamag.dao.ProfileDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String uriparts[] = request.getRequestURI().split("/");
WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
ProfileDao dao = (ProfileDao)ctx.getBean("profileDao");
Profile profile = dao.findByName(uriparts[uriparts.length-1]);
if (profile==null) {
	response.sendError(HttpServletResponse.SC_NOT_FOUND);
}
request.setAttribute("login", profile);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profil bearbeiten</title>
</head>
<body>
	<h1>Profil bearbeiten: ${login.name}</h1>
	<p>Simuliere Bearbeitung...</p>
<%
profile.setDescription(profile.getDescription() + " Diese Beschreibung wurde bearbeitet.");
dao.store(profile);
%>	
</body>
</html>
