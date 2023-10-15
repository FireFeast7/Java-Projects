<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="container mtb">
    <div class="row">
        <div class="col-lg-6">
            <form action="${pageContext.request.contextPath}/operation" method="post">
                <p>Are you sure you want to delete this user?</p>
                <input type="hidden" name="user_id" value="${param.user_id}">
                <input type="hidden" name="form" value="delete-userops">
                <button type="submit" name="confirmation" value="yes">Yes</button>
                <button type="submit" name="confirmation" value="no">No</button>
            </form>
            <hr/>
            <table>
            </table>
        </div>
    </div>
</div>
<%@ include file="include/header.jsp"%>
