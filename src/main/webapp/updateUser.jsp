<%@ page import="com.example.helloworld.User"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="container mtb">
    <div class="row">
        <div class="col-lg-6">
    <form action="${pageContext.request.contextPath}/operation" method="post">
        Username : <input type="text" name="username" value="${param.username}" required = "required"/><br/>
        Email : <input type="email" name="email" value="${param.email}" required = "required"><br/>
        <input type="hidden" name="user_id" value="${param.user_id}">
        <input type="hidden" name="form"  value="update-userops">
        <input type="submit" value="Update User"/>
    </form>
            <hr/>
            <table>

            </table>
        </div>
    </div>
</div>
<%@ include file="include/header.jsp"%>