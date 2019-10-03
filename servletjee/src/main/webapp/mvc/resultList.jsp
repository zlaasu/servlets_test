<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zlasu
  Date: 10/3/2019
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>Result</h4>
<c:forEach items="${books}" var="book" varStatus="var">
    <h4>Result ${var.index}</h4>
    <ul>
        <li>${book.title}</li>
        <li>${book.author}</li>
        <li>${book.isbn}</li>
    </ul>
</c:forEach>

</body>
</html>
