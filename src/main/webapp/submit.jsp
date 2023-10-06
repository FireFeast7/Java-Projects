<%--
  Created by IntelliJ IDEA.
  User: ameya
  Date: 05-10-2023
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info of the form</title>
</head>
<body>
Name = <%= request.getParameter("Name")%> <br/>
Gender = <%=request.getParameter("gender")%><br/>
Languages Known :   <%
    String[] language = request.getParameterValues("languages");
    if(language.length!=0){
        for(int i = 0; language.length > i; i++) {
            out.println(language[i]);
            out.println("<br/>");
        }
    }
    else {
        out.println("None Selected");
    }

%>


</body>
</html>
