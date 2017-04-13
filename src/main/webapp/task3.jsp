<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="common.head.jsp"></jsp:include>
    <link href="<c:url value="${pageContext.request.contextPath}/css/task3.css"/>" rel="stylesheet">
    <title>Задание №3</title>
</head>
<body>
    <div class="container">
        <div class="well">
            <h3>Задание №3</h3>
            <p>
                Написать SQL скрипт который сортирует таблицу и делает из нее дерево.

                На входе таблица
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>ID_parent</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1000</td>
                            <td>NULL</td>
                        </tr>
                        <tr>
                            <td>364</td>
                            <td>1000</td>
                        </tr>
                        <tr>
                            <td>1200</td>
                            <td>364</td>
                        </tr>
                    </tbody>
                </table>

                Ну ит.д.
                Главных узлов может быть много.
                На выходе
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>LEVEL</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1000</td>
                        <td>1</td>
                    </tr>
                    <tr>
                        <td>364</td>
                        <td>2</td>
                    </tr>
                    <tr>
                        <td>1200</td>
                        <td>3</td>
                    </tr>
                    </tbody>
                </table>
            </p>
        </div>
        <p>Решение на MySQL.</p>
            <b>1) Создаем функцию.</b>
            <div class="padder">
                CREATE FUNCTION `row_level`(_var int) RETURNS int(11)<br>
                BEGIN<br>
                    <div class="padder">
                        declare temp int;<br>
                        declare level_value int;<br>
                        <br>
                        set temp = _var;<br>
                        set level_value = 0;
                        <br>
                        while temp is not null do<br>
                            <div class="padder">
                                select id_parent, level_value + 1<br>
                                into temp, level_value<br>
                                from table2 where id = temp;<br>
                            </div>
                        end while;<br>
                        <br>
                        return level_value;<br>
                    </div>
                END<br>
            </div>

            <b>2) Делаем запрос с нашей новой функцией.</b>
            <div class="padder">
                select * from (<br>
                    <div class="padder">
                        select id,row_level(id)level from table2<br>
                    </div>
                )a<br>
                order by level;<br>
            </div>
        </p>
    </div>
</body>
</html>
