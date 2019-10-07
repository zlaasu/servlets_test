<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/fragment/header.jsp"%>
<%@include file="/fragment/menu.jsp"%>

<%@include file="/fragment/errorMessage.jsp" %>

<table border="1" class="table table-dark">
    <thead>
    <th>ID</th>
    <th>Name</th>
    <th>Action</th>
    </thead>

    <c:forEach items="${userGroups}" var="userGroup" varStatus="var">
        <tr>
            <td>${userGroup.id}</td>
            <td>${userGroup.name}</td>
            <td>
            </td>
        </tr>
    </c:forEach>
</table>

<%@include file="/fragment/footer.jsp"%>