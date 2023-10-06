<%--
  Created by IntelliJ IDEA.
  User: ameya
  Date: 05-10-2023
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Set Application</title>
</head>
<body>
<jsp:useBean id="user" class="com.example.helloworld.User" scope="session"/>

<form action="getApplication.jsp" method="post">
    First Name : <label>
    <input type="text" name="firstName" value='<jsp:getProperty property="firstName" name="user"/>'>
</label>
    <br/>
    Last Name : <label>
    <input type="text" name="lastName" value='<jsp:getProperty property="lastName" name="user"/>'>
</label>
    <input type="submit" value="Submit">
</form>
</body>
</html>
