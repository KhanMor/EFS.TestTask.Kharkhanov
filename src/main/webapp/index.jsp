<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="common.head.jsp"></jsp:include>
  <title>Выберите задачу</title>
</head>
<body>
  <div class="container">
    <h3>Харханов Андрей.</h3>
    <h3>Выберите задачу</h3>
    <div class="well well-sm">
      <div class="list-group">
        <a href="<c:url value="${pageContext.request.contextPath}/task1"/>" class="list-group-item">Задание №1</a>
        <a href="<c:url value="${pageContext.request.contextPath}/task2"/>" class="list-group-item">Задание №2</a>
        <a href="<c:url value="${pageContext.request.contextPath}/task3"/>" class="list-group-item">Задание №3</a>
      </div>
    </div>
  </div>
</body>
</html>