<%--
  Created by IntelliJ IDEA.
  User: ameya
  Date: 05-10-2023
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo Form</title>
</head>
<body>
<form
    action = "submit.jsp" method="get">
    Full Name : <label>
    <input type="text" name="Name" required/>
</label><br/>
    Gender : <label>
    <input name="gender" type="radio" value="male" required/>
</label> Male
    <label>
        <input name="gender" type="radio" value="Female" required/>
    </label> Female
    Languages Know : <label>
    <input type="checkbox" name="languages" value="English"/>
</label> English
    <label>
        <input type="checkbox" name="languages" value="Hindi"/>
    </label> Hindi
    <label>
        <input type="checkbox" name="languages" value="Marathi"/>
    </label> Marathi
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
