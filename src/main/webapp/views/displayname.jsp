<%--
  Created by IntelliJ IDEA.
  User: ameya
  Date: 25-10-2023
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Name View</title>
</head>
<body>
Hello ${firstname}
The time is ${dateRN}
The message is <c:forEach var="temp" items="${names}">
    ${temp}<br/>
</c:forEach>
</body>
</html>
