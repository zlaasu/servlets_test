<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/fragment/header.jsp"%>
<%@include file="/fragment/menu.jsp"%>

<%@include file="/fragment/errorMessage.jsp" %>

<table border="1" class="table table-dark">
    <thead>
    <th>ID</th>
    <th>Created</th>
    <th>Updated</th>
    <th>Description</th>
    <th>Action</th>
    </thead>

    <c:forEach items="${solutions}" var="solution" varStatus="var">
        <tr>
            <td>${solution.id}</td>
            <td>${solution.created}</td>
            <td>${solution.updated}</td>
            <td>${solution.description}</td>
            <td>
            </td>
        </tr>
    </c:forEach>
</table>

<%@include file="/fragment/footer.jsp"%>