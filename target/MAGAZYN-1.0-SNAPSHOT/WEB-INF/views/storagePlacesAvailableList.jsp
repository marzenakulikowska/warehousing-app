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
            justify-content: space-between;
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
            flex-basis: 5%;
        }
        .col-2,.col-3, .col-3 {
            flex-basis: 32%;
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
    <h2>Lista miejsc paletowych na regałach</h2>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">ID</div>
            <div class="col col-2">Rząd</div>
            <div class="col col-3">Poziom</div>
            <div class="col col-4">Miejsce</div>
        </li>
        <c:forEach items="${storagePlaces}" var="storagePlace">
            <li class="table-row">
                <div class="col col-1">${storagePlace.id}</div>
                <div class="col col-2">${storagePlace.column}</div>
                <div class="col col-3">${storagePlace.level}</div>
                <div class="col col-4">${storagePlace.place}</div>
            </li>
        </c:forEach>
    </ul>
</div>
<div class="btn-container">
    <a href="/warehousing/form/storagePlace" class="button" style="background-color:#42cc8c;">Dodaj nowe miejsce paletowe</a>
    <a href="/" class="button" style="background-color:#42cc8c;">Wróć do strony głównej</a>
</div>
</body>
</html>

