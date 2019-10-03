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

<h4>Lista elementów</h4>
<ul>
    <c:forEach begin="${startVal}" end="${endVal}" step="1" varStatus="status">
        <li>${status.index}</li>
    </c:forEach>
</ul>

</body>
</html>
