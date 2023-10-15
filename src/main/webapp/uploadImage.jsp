<%--
  Created by IntelliJ IDEA.
  User: ameya
  Date: 15-10-2023
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Image Upload Form</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/imageUpload" enctype="multipart/form-data">
    <input type="file" name="file" multiple/>
    <input type="submit" value="Upload" />
</form>
</body>
</html>
