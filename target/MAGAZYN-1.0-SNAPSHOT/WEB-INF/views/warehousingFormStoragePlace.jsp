<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz dodawania miejsca paletowego</title>
    <style>
        .error {
            background-color: red;
        }
        .form-style-5{
            max-width: 500px;
            padding: 10px 20px;
            background: #f4f7f8;
            margin: 10px auto;
            padding: 20px;
            background: #f4f7f8;
            border-radius: 8px;
            font-family: Georgia, "Times New Roman", Times, serif;
        }
        .form-style-5 fieldset{
            border: none;
        }
        .form-style-5 legend {
            font-size: 1.4em;
            margin-bottom: 10px;
        }
        .form-style-5 label {
            display: block;
            margin-bottom: 8px;
        }
        .form-style-5 input[type="text"],
        .form-style-5 input[type="date"],
        .form-style-5 input[type="datetime"],
        .form-style-5 input[type="email"],
        .form-style-5 input[type="number"],
        .form-style-5 input[type="search"],
        .form-style-5 input[type="time"],
        .form-style-5 input[type="url"],
        .form-style-5 textarea,
        .form-style-5 select {
            font-family: Georgia, "Times New Roman", Times, serif;
            background: rgba(255,255,255,.1);
            border: none;
            border-radius: 4px;
            font-size: 15px;
            margin: 0;
            outline: 0;
            padding: 10px;
            width: 100%;
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            background-color: #e8eeef;
            color:#8a97a0;
            -webkit-box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
            box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
            margin-bottom: 30px;
        }
        .form-style-5 input[type="text"]:focus,
        .form-style-5 input[type="date"]:focus,
        .form-style-5 input[type="datetime"]:focus,
        .form-style-5 input[type="email"]:focus,
        .form-style-5 input[type="number"]:focus,
        .form-style-5 input[type="search"]:focus,
        .form-style-5 input[type="time"]:focus,
        .form-style-5 input[type="url"]:focus,
        .form-style-5 textarea:focus,
        .form-style-5 select:focus{
            background: #d2d9dd;
        }
        .form-style-5 select{
            -webkit-appearance: menulist-button;
            height:35px;
        }
        .form-style-5 .number {
            background: #1abc9c;
            color: #fff;
            height: 30px;
            width: 30px;
            display: inline-block;
            font-size: 0.8em;
            margin-right: 4px;
            line-height: 30px;
            text-align: center;
            text-shadow: 0 1px 0 rgba(255,255,255,0.2);
            border-radius: 15px 15px 15px 0px;
        }

        .form-style-5 input[type="submit"],
        .form-style-5 input[type="button"]
        {
            position: relative;
            display: block;
            padding: 19px 39px 18px 39px;
            color: #FFF;
            margin: 0 auto;
            background: #1abc9c;
            font-size: 18px;
            text-align: center;
            font-style: normal;
            width: 100%;
            border: 1px solid #16a085;
            border-width: 1px 1px 3px;
            margin-bottom: 10px;
        }
        .form-style-5 input[type="submit"]:hover,
        .form-style-5 input[type="button"]:hover
        {
            background: #109177;
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
<div class="form-style-5">
    <legend> Formularz magazynowania</legend>
    <form:form method="post" modelAttribute="storagePlace" action="/warehousing/form/storagePlace">
        <legend><span class="number">3</span>Dane miejsca paletowego</legend>
        <label for="column">Wybierz rząd</label>
        <form:errors path="column" cssClass="error"/>
        <form:input path="column" id="column"/>
        <label for="level">Wybierz poziom</label>
        <form:errors path="level" cssClass="error"/>
        <form:input path="level" id="level"/>
        <label for="place">Wybierz miejsce paletowe</label>
        <form:errors path="place" cssClass="error"/>
        <form:input path="place" id="place"/>
        <input type="submit" value="Zatwierdź i przejdź dalej">
    </form:form>
</div>
<div class="btn-container">
    <a href="/" class="button" style="background-color:#42cc8c;">Wróć do strony głównej</a>
</div>
</body>
</html>