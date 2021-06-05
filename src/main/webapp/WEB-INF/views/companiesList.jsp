<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista kontrahentów</title>
    <style>
        body {
            font-family: 'lato', sans-serif;
        }
        .container {
            max-width: 1500px;
            margin-left: auto;
            margin-right: auto;
            padding-left: 10px;
            padding-right: 10px;
        }

        h2 {
            font-size: 26px;
            margin: 20px 0;
            text-align: center;
        }
        h2.small {
            font-size: 0.5em;
        }
        .responsive-table li{
            border-radius: 3px;
            padding: 25px 30px;
            display: flex;
            margin-bottom: 25px;
        }
        .table-header {
            background-color: #95A5A6;
            font-size: 14px;
            text-transform: uppercase;
            letter-spacing: 0.03em;
        }
        .table-row {
            background-color: #ffffff;
            box-shadow: 0px 0px 9px 0px rgba(0,0,0,0.1);
        }
        .col-1 {
            flex-basis: 4%;
        }
        .col-2 {
            flex-basis: 15%;
        }
        .col-3 {
            flex-basis: 11%;
        }
        .col-4 {
            flex-basis: 20%;
        }
        .col-5 {
            flex-basis: 10%;
        }
        .col-6 {
            flex-basis: 8%;
        }
        .col-7 {
            flex-basis: 20%;
        }

        @media all and (max-width: 767px) {
            .table-header {
                display: none;
            }
            .table-row{

            }
            li {
                display: block;
            }
            .col {
                flex-basis: 100%;

            }
            .col {
                display: flex;
                padding: 10px 0;
            }
            .col:before {
                color: #6C7A89;
                padding-right: 10px;
                content: attr(data-label);
                flex-basis: 50%;
                text-align: right;
            }
        }
        a.button{
            display:inline-block;
            padding:0.46em 1.6em;
            border:0.1em solid #000000;
            margin:0 0.2em 0.2em 0;
            border-radius:0.12em;
            box-sizing: border-box;
            text-decoration:none;
            font-family:'Roboto',sans-serif;
            font-weight:300;
            color:#000000;
            text-shadow: 0 0.04em 0.04em rgba(0,0,0,0.35);
            background-color:#FFFFFF;
            text-align:center;
            transition: all 0.15s;
        }
        a.button:hover{
            text-shadow: 0 0 2em rgba(255,255,255,1);
            color:#FFFFFF;
            border-color:#FFFFFF;
        }
        @media all and (max-width:30em){
            a.button{
                display:block;
                margin:0.4em auto;
            }
        }
        .btn-container {
            width: 1000px;
            margin: auto;
            display: flex;
            justify-content: center;
            align-items: center;

        }
    </style>
</head>
<body>
<div class="container">
    <h2>Lista kontrahentów</h2>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">ID</div>
            <div class="col col-2">Nazwa firmy</div>
            <div class="col col-3">NIP</div>
            <div class="col col-4">E-mail</div>
            <div class="col col-5">Ulica</div>
            <div class="col col-6">Kod pocztowy</div>
            <div class="col col-7">Miejscowość</div>
            <div class="col col-8">Akcje:</div>
        </li>
        <c:forEach items="${companies}" var="company">
            <li class="table-row">
                <div class="col col-1">${company.id}</div>
                <div class="col col-2">${company.name}</div>
                <div class="col col-3">${company.nip}</div>
                <div class="col col-4">${company.email}</div>
                <div class="col col-5">${company.street}</div>
                <div class="col col-6">${company.postcode}</div>
                <div class="col col-7">${company.city}</div>
                <div class="col-8"><a href="/warehousing/form/company/edit/${company.id}" class="button" style="background-color:#42cc8c;">Edytuj</a></div>
                <div class="col-8"><a href="/warehousing/form/company/delete/${company.id}" class="button" style="background-color:#42cc8c;">Usuń</a></div>
            </li>
        </c:forEach>
    </ul>
</div>
<div class="btn-container">
    <a href="/warehousing/form/company" class="button" style="background-color:#42cc8c;">Dodaj nowego kontrahenta</a>
    <a href="/" class="button" style="background-color:#42cc8c;">Wróć do strony głównej</a>
</div>
</body>
</html>

