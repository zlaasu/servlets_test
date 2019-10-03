<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zlasu
  Date: 10/3/2019
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post">
    <c:forEach begin="1" end="5" varStatus="var">
        <p>Rekord ${var.index}</p>
        <input type="text" name="title" placeholder="title"/><br>
        <input type="text" name="author" placeholder="author"/><br>
        <input type="text" name="isbn" placeholder="isbn"/><br>
    </c:forEach>
    <input type="submit" value="Wysli"/>
</form>

</body>
</html>
