<%--
  Created by IntelliJ IDEA.
  User: MARZENA
  Date: 31.05.2021
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona główna</title>
    <style>
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
        .container {
            width: 1000px;
            margin: auto;
            display: flex;
            justify-content: center;
            align-items: center;

        }

    </style>
</head>
<body>
<div class="container"> </div>
    <div><a href="/warehousing/form/company" class="button" style="background-color:#42cc8c;">Dodaj kontrahenta!</a></div>
    <div><a href="/warehousing/form/palette" class="button" style="background-color:#42cc8c;">Dodaj paletę!</a></div>
    <div><a href="/warehousing/form/storagePlace" class="button" style="background-color:#42cc8c;">Dodaj miejsce paletowe!</a></div>
    <div><a href="/warehousing/form/cargo" class="button" style="background-color:#42cc8c;">Dodaj magazynowany ładunek!</a></div>
    <br>
    <div><a href="/company/list" class="button" style="background-color:#42cc8c;">Lista kontrahentów</a></div>
    <div><a href="/palette/list" class="button" style="background-color:#42cc8c;">Lista palet</a></div>
    <div><a href="/storagePlace/available/list" class="button" style="background-color:#42cc8c;">Lista dostępnych miejsc paletowych</a></div>
    <br>
    <div><a href="/palette/list" class="button" style="background-color:#42cc8c;">Zakończenie magazynowania ładunku</a></div>
</div>
</body>
</html>
