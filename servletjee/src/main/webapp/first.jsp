<%--
  Created by IntelliJ IDEA.
  User: zlasu
  Date: 10/3/2019
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>KM: ${empty param.km ? "nie podano parametru": param.km}</h1>
<h2>Przeliczenie na mile ${ empty param.km ? "": param.km / 1.609344} mil</h2>

</body>
</html>
