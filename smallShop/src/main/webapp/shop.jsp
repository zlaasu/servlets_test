<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/fragment/header.jsp"%>


<table>
    <thead>
        <th>ID</th>
        <th>Nazwa</th>
        <th>Opis</th>
        <th>Cena za szt.</th>
        <th>Akcja</th>
    </thead>
    <tbody>
        <c:forEach items="${products}" var="item">

            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.shortDescription}</td>
                <td>${item.price}</td>
                <td>
                    <form method="post">
                        <input name="id" value="${item.id}" type="hidden"/>
                        <input name="qty" type="number" value="1" step="1"/>
                        <input type="submit" value="+">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/basket">Przejdź do koszyka</a>
<%@include file="/fragment/footer.jsp"%>

