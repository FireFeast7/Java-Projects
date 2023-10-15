<%@ page import="com.example.helloworld.User"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="container mtb">
    <div class="row">
        <div class="col-lg-6">
            <form action="${pageContext.request.contextPath}/operation" method="post">
                Username : <input type="text" name="username" required = "required" value="${param.username}"/><br/>
                Email : <input type="email" name="email" required = "required" value="${param.email}"><br/>
                <input type="hidden" name="form" value="add-userops">
                <input type="submit" value="Submit"/>
            </form>
            <hr/>
            <table>

            </table>
        </div>
    </div>
</div>
<%@ include file="include/header.jsp"%>