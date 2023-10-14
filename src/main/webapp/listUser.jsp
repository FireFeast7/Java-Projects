<%--
  Created by IntelliJ IDEA.
  User: ameya
  Date: 13-10-2023
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="include/header.jsp"%>
<%@ page import ="java.util.List" %>
<%@ page import="com.example.helloworld.User"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                <th>Update</th>
                </thead>
                <%
                    List<User> listUs = (List<User>) request.getAttribute("listUsers");
                    String tempURL;
                    for(int i = 0;i<listUs.size();i++){
                        out.print("<tr>");
                        out.println("<td>"+listUs.get(i).getUsers_id()+"</td>");
                        out.println("<td>"+listUs.get(i).getEmail()+"</td>");
                        out.println("<td>"+listUs.get(i).getUsername()+"</td>");
                        tempURL = request.getContextPath()+"/operation?page=update-user" +
                                "&user_id="+listUs.get(i).getUsers_id()+
                                "&username="+listUs.get(i).getUsername()+
                                "&email="+listUs.get(i).getEmail();
                        out.println("<td><a href="+tempURL+">Update</a></td>");

                        out.print("</tr>");
                    }

                %>
            </table>
        </div>
    </div>
</div>
<%@ include file="include/footer.jsp"%>