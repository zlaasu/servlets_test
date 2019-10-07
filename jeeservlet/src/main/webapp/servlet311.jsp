<%--
  Created by IntelliJ IDEA.
  User: zlasu
  Date: 10/3/2019
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

${welcome}

<form method="post" action="/servlet312">
    <select name="lang">
        <option value="en">en</option>
        <option value="pl">pl</option>
        <option value="de">de</option>
        <option value="es">es</option>
        <option value="fr">fr</option>
    </select>
    <input type="submit" value="PICK">
</form>

</body>
</html>
