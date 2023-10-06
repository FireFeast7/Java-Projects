<%@ page import="jdk.jfr.Frequency" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "First Application!" %></h1>
It's Home Page<br/>
<a href="<%= request.getContextPath()%>/Controller?page=login">Login</a><br/>
<a href="<%= request.getContextPath()%>/Controller?page=signup">Signup</a><br/>
<a href="<%= request.getContextPath()%>/Controller?page=about-us">AboutUs</a><br/>
<a href="<%= request.getContextPath()%>/newFile.jsp">NewFile</a>
<a href="<%= request.getContextPath()%>/getApplication.jsp">Get</a>
<a href="<%= request.getContextPath()%>/setApplication.jsp">Set</a>

</body>
</html>
