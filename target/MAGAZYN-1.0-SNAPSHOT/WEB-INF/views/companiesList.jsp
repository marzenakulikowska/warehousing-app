<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

Kontrahenci:
<table>
    <th>ID</th>
    <th>Nazwa</th>
    <th>NIP</th>
    <th>E-mail</th>
    <th>Ulica</th>
    <th>Kod pocztowy</th>
    <th>Miejscowość</th>
    <c:forEach items="${companies}" var="company">
        <tr>
            <td>${company.id}</td>
            <td>${company.name}</td>
            <td>${company.nip}</td>
            <td>${company.email}</td>
            <td>${company.street}</td>
            <td>${company.postcode}</td>
            <td>${bcompany.city}</td>
<%--            <td><a href="form/delete/${company.id}">Delete company</a></td>--%>
<%--            <td><a href="form/edit/${company.id}">Edit company</a></td>--%>
        </tr>

    </c:forEach>
</table>

<a href="form">Add book</a>

</body>
</html>
>
