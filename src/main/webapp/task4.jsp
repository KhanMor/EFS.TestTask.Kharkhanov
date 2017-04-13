<%--
  Created by IntelliJ IDEA.
  User: Mordr
  Date: 13.04.2017
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="common.head.jsp"></jsp:include>
    <title>Здание №4</title>
</head>
<body>
<div class="container">
    <div class="well">
        <h3>Задание №4</h3>
        <p>
            Есть два отсортированных массива разной длины (100 и 200 например).
            Нужно их объединить в 3-ий массив, который также будет отсортирован.
            Понятно что без сортировки 3-его массива.
        </p>
    </div>
    <div>
        <h4>Массив №1</h4>
        <div>
            <c:out value="${array1Str}" />
        </div>
        <hr>
        <h4>Массив №2</h4>
        <div>
            <c:out value="${array2Str}" />
        </div>
        <hr>
        <h4>Массив №3</h4>
        <div>
            <c:out value="${array3Str}" />
        </div>
    </div>
</div>
</body>
</html>
