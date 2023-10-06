<%--
  Created by IntelliJ IDEA.
  User: ameya
  Date: 05-10-2023
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>get and set properties Example</title>
</head>

<body>
<jsp:useBean id = "students" class = "com.example.helloworld.User" scope="application">
    <jsp:setProperty name = "students" property = "firstName" value = "Zara"/>
    <jsp:setProperty name = "students" property = "lastName" value = "Ali"/>

</jsp:useBean>

<p>Student First Name:
    <jsp:getProperty name = "students" property = "firstName"/>
</p>

<p>Student Last Name:
    <jsp:getProperty name = "students" property = "lastName"/>
</p>


</body>
</html>

