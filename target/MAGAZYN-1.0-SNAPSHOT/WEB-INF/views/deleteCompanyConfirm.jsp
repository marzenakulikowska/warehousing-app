<%--
  Created by IntelliJ IDEA.
  User: MARZENA
  Date: 04.06.2021
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuwanie firmy</title>
</head>
<body>
<form method="post" action="/warehousing/form/company/delete/${company.id}">
    Czy na pewno usunąć kontrahenta o id: ${company.id} ?
    <button name="confirm" value="true">TAK</button>
    <button name="confirm" value="false">ANULUJ</button>
</form>
</body>
</html>
