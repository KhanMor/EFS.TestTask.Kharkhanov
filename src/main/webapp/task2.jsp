<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="common.head.jsp"></jsp:include>
    <script src="${pageContext.request.contextPath}/js/task2.js" type="text/javascript"></script>
    <link href="<c:url value="${pageContext.request.contextPath}/css/task2.css"/>" rel="stylesheet">
    <title>Задание №2</title>
</head>
<body>
    <div class="container">
        <h3>Задание №2</h3>
        <p>
            Есть xml в котором список из 10 человек, поля (№, ФИО, Дата Рождения, рост, вес, пол)
            Подтянуть на web СТРАНИЦУ ФАЙЛ.
            Сделать на JS сортировки по всем столбцам, кнопку при нажатии на которую на форму выводится в поле средний рост всех.
            При  нажатии на другую кнопку (кнопка «М») выводится диалоговое окно в котором список мужчин, аналогично женщин по другой кнопке.
            Также сделать возможность при наведении на ДР – показывать возраст в годах.
        </p>
    </div>
    <p>XML-файл парсим с помощью JAXB на сервере, выдаем в jsp коллекцию людей</p>
    <h4>Для сортировки намите на заголовок столбца.</h4>
    <table class="table table-bordered" id="table1">
        <thead>
            <tr>
                <th>№</th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Отчество</th>
                <th>Дата рождения (Наведите курсор)</th>
                <th>Рост</th>
                <th>Вес</th>
                <th>Пол</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${humans}" var="human">
                <tr>
                    <td><c:out value="${human.number}" /></td>
                    <td><c:out value="${human.surname}" /></td>
                    <td><c:out value="${human.firstName}" /></td>
                    <td><c:out value="${human.patronymic}" /></td>
                    <td class = "birthDayCell"><fmt:formatDate value="${human.birthDay}" pattern="dd.MM.yyyy"/></td>
                    <td><c:out value="${human.height}" /></td>
                    <td><c:out value="${human.weight}" /></td>
                    <td><c:out value="${human.sex}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="well">
        <h4>Средний рост людей</h4>
        <div class="input-group">
            <span class="input-group-btn">
                <button class="btn btn-primary" type="button" id="countMediumHeightBtn"> Подсчитать</button>
            </span>
            <input type="text" class="form-control" id="countMediumHeight" placeholder="Средний рост будет выведен сюда..." readonly>
        </div>
        <h4>Открыть диалоговое окно по половому признаку: </h4>
        <div class="btn-group">
            <button class="btn btn-default" id="showOnlyMalesBtn">М</button>
            <button class="btn btn-default" id="showOnlyFemaleBtn">Ж</button>
        </div>
    </div>

    <div id="humansModal" class="modal fade" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title"></h4>
                </div>
                <div class="modal-body">
                    <table class="table table-bordered" id="table2">
                        <thead>
                        <tr>
                            <th>№</th>
                            <th>Фамилия</th>
                            <th>Имя</th>
                            <th>Отчество</th>
                            <th>Дата рождения</th>
                            <th>Рост</th>
                            <th>Вес</th>
                            <th>Пол</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
