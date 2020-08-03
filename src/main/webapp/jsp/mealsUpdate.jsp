<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        label {
            width: 300px;
            height: 35px;
            margin-top: 15px;
            display:inline-block;
            padding:2px;
        }
        input {
            height:40px;
            width:350px;
            padding:5px 5px;
        }
        textarea {padding:8px; width:300px;}
        button {margin-left:156px;}

        input, textarea {
            border:1px solid #aaa;
            box-shadow: 0px 0px 3px #ccc, 0 10px 15px #eee inset;
            border-radius:2px;
        }
        input:focus, textarea:focus {
            background: #fff;
            border:1px solid #555;
            box-shadow: 0 0 3px #aaa;
        }
    </style>
</head>
<body>
<div>
    <form method="post" action="${pageContext.request.contextPath}/meal?id=${meal.id}">
        <label for="dateTime">Дата
            <input class="input-field" type="datetime-local" id="dateTime" name="dateTime", value="${meal.dateTime}" required>
        </label>
        <label for="description">Описание
            <input class="input-field" type="text" id="description" name="description" value="${meal.description}" required>
        </label>
        <label for="calories">Калории
            <input class="input-field" type="number" id="calories" name="calories" value="${meal.calories}" required>
        </label>
        <input type="submit" value="Добавить">
    </form>
</div>
</body>
</html>