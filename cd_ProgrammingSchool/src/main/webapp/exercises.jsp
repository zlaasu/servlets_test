<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/fragment/header.jsp" %>
<%@include file="/fragment/menu.jsp" %>
<%@include file="/fragment/errorMessage.jsp" %>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<table border="1" class="table table-dark">
    <thead>
    <th>ID</th>
    <th>Title</th>
    <th>Description</th>
    <th>Action</th>
    </thead>

    <c:forEach items="${exercises}" var="exercise" varStatus="var">
        <tr>
            <td>${exercise.id}</td>
            <td>${exercise.title}</td>
            <td>${exercise.description}</td>
            <td>
                <jsp:include page="fragment/tableActions.jsp">
                    <jsp:param name="id" value="${exercise.id}"/>
                    <jsp:param name="path" value="/exercise"/>
                </jsp:include>
                    ${pageContext.servletContext.contextPath}
                    ${pageContext.request.contextPath}
                    ${context}
                    ${request.contentPath}
                    ${pageContext.request.contextPath}
                <% request.getContextPath();%>
            </td>
        </tr>
    </c:forEach>
</table>

<%@include file="/fragment/footer.jsp" %>