<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Member Area</title>
</head>
<body>
<%
    String username = null, sessionId = null;
    if(request.getSession().getAttribute("username") == null){
        response.sendRedirect("login.jsp");
    }
    else{
        username = request.getSession().getAttribute("username").toString();
        sessionId = request.getSession().getId();
    }

%>
<%=username%>
<br/>
<%= sessionId %>
<br/>
<form action="<%=request.getContextPath()%>/MethodController" method="get">
    <input type="hidden" name="action" value="destroy">
    <input type="submit" value="logout">
</form>
</body>
</html>
