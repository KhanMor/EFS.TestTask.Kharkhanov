<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="common.head.jsp"></jsp:include>
    <title>Задание №1</title>
</head>
<body>
    <div class="container">
        <div class="well">
            <h3>Задание №1</h3>
            <p>
                Попробовать очень быстро отсортировать массив из 10 млн. записей (числа от 1 до 100млн).
                На входе случайным образом создаем массив, на выходе каждый 500 тыс. элемент, включая 1-ый и последний выводим на экран.
            </p>
        </div>
        <div>
            <h4>Сортировка в один поток</h4>
            <div>
                <b>Затраченное время: </b> <c:out value="${sortSimpleTimeS}" />
            </div>
            <div>
                <b>Каждый 500 тыс. элемент: </b> <c:out value="${sortSimpleOutputString}" />
            </div>
            <hr>
            <h4>Многопоточная сортировка:</h4>
            <div>
                <b>Затраченное время: </b> <c:out value="${sortParallelTimeS}" />
            </div>
            <div>
                <b>Каждый 500 тыс. элемент: </b> <c:out value="${sortParallelOutputString}" />
            </div>
        </div>
    </div>
</body>
</html>
