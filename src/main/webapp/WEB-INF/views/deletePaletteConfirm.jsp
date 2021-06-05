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
    <title>Usuwanie palety</title>
</head>
<body>
<form method="post" action="/warehousing/form/palette/delete/${palette.id}">
    Czy na pewno usunąć paletę o id: ${palette.id} ?
    <button type="submit" name="confirm" value="true">TAK</button>
    <button type="submit" name="confirm" value="false">ANULUJ</button>
</form>
</body>
</html>
