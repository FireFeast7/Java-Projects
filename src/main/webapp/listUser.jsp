<%--
  Created by IntelliJ IDEA.
  User: ameya
  Date: 13-10-2023
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="java.util.List" %>
<%@ page import="com.example.helloworld.User"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:import url="include/header.jsp">

    <c:param name="title" value="Demo Page"/></c:import>
<div class="container mtb">
    <div class="row">
        <div class="col-lg-6">
            <strong>Listing Users</strong>
            <hr/>
            <table>
                <thead>
                <th>User Id</th>
                <th>Username</th>
                <th>Email</th>
                </thead>
                <%
                    List<User> listUs = (List<User>) request.getAttribute("listUsers");
                    for(int i = 0;i<listUs.size();i++){
                        out.print("<tr>");
                        out.println("<td>"+listUs.get(i).getUsers_id()+"</td>");
                        out.println("<td>"+listUs.get(i).getEmail()+"</td>");
                        out.println("<td>"+listUs.get(i).getUsername()+"</td>");
                        out.print("</tr>");
                    }

                %>
            </table>
        </div>
    </div>
</div>
<c:import url="include/footer.jsp">
</c:import>