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

<h1>Witaj, ${empty attribRole ? "quest" : attribRole}</h1>

<br><br>

<c:if test="${not empty attribRole}">
    <h1>Witaj, ${attribRole}</h1>
</c:if>
<c:if test="${empty attribRole}">
    <h1>Witaj, gosciu.</h1>
</c:if>

</body>
</html>
