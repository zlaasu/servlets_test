<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/fragment/header.jsp"%>
<%@include file="/fragment/menu.jsp" %>

<%@include file="/fragment/errorMessage.jsp" %>

<table border="1" class="table table-dark">
    <thead>
    <th>ID</th>
    <th>Username</th>
    <th>Email</th>
    <th>Group</th>
    <th>Action</th>
    </thead>

    <c:forEach items="${users}" var="user" varStatus="var">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.userGroup.name}</td>
            <td>
            </td>
        </tr>
    </c:forEach>
</table>

<%@include file="/fragment/footer.jsp"%>