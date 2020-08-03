<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border-spacing: 0 0;
            font-family: 'Open Sans', sans-serif;
            font-weight: bold;
        }
        th {
            padding: 10px 20px;
            background: #56433D;
            color: #F9C941;
            border-right: 2px solid;
            font-size: 0.9em;
        }
        th:first-child {
            text-align: left;
        }
        th:last-child {
            border-right: none;
        }
        td {
            vertical-align: middle;
            padding: 10px;
            font-size: 14px;
            text-align: center;
            border-bottom: 2px solid #56433D;
            border-right: 2px solid #56433D;
        }
        td:first-child {
            border-left: 2px solid #56433D;
        }
        td:nth-child(2){
            text-align: left;
        }
        button {
            font-weight: 700;
            color: white;
            text-decoration: none;
            padding: .8em 1em calc(.8em + 3px);
            border-radius: 3px;
            background: rgb(64,199,129);
            box-shadow: 0 -3px rgb(53,167,110) inset;
            transition: 0.2s;
        }
        button { background: rgb(53, 167, 110); }
        button {
            background: rgb(33,147,90);
            box-shadow: 0 3px rgb(33,147,90) inset;
        }
    </style>
</head>
<body>
<div>
    <div>
        <h1>Meals</h1>
    </div>
    <table>
        <tr>
            <th>Дата</th>
            <th>Описание</th>
            <th>Калории</th>
        </tr>
        <c:forEach items="${meals}" var="meal">
            <c:choose>
                <c:when test="${meal.excess}">
                    <tr style="background-color: darkred">
                </c:when>
                <c:otherwise>
                    <tr style="background-color: green">
                </c:otherwise>
            </c:choose>
                <td>${meal.date} ${meal.time}</td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <form method="post" action="${pageContext.request.contextPath}/meals?id=${meal.id}">
                    <td><button name="change">Изменить</button></td>
                    <td><button name="delete">Удалить</button></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</div>

<a href="${pageContext.request.contextPath}/meal"><button>Добавить товар</button></a>
</body>
</html>