<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/fragment/header.jsp"%>

<h1>Twój koszyk</h1>
<table>
    <thead>
        <th>ID</th>
        <th>Nazwa</th>
        <th>Opis</th>
        <th>Cena za szt.</th>
        <th>Liczba kupionych</th>
        <th>Cena sumaryczna</th>
    </thead>
    <tbody>
        <c:forEach items="${basket}" var="cartItem">
            <tr>
                <td>${cartItem.product.id}</td>
                <td>${cartItem.product.name}</td>
                <td>${cartItem.product.shortDescription}</td>
                <td>${cartItem.product.price}</td>
                <td>${cartItem.qty}</td>
                <td>${cartItem.qty * cartItem.product.price}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<h3>Do zapłaty: ${totalPrice}</h3>
<a href="/shop">Wróć do sklepu</a>


<%@include file="/fragment/footer.jsp"%>