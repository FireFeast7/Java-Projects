<%--
  Created by IntelliJ IDEA.
  User: ameya
  Date: 05-10-2023
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application</title>
</head>
<body>
<jsp:useBean id="user" class="com.example.helloworld.User" scope="session"/>
<jsp:setProperty name="user" property="*"/>
First Name : <jsp:getProperty name="user" property="firstName"/>
<br/>
Last Name : <jsp:getProperty name="user" property="lastName"/>

</body>
</html>
