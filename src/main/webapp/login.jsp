<%--
  Created by IntelliJ IDEA.
  User: ameya
  Date: 04-10-2023
  Time: 02:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/Controller" method="post">
    UserName : <label>
    <input type="text" name="username" required>
</label>
    <br/>
    Password : <label>
    <input type="text" name="password" required>
</label>
    <input type="submit" value="submit">
</form>

</body>
</html>
