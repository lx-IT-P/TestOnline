<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/26 0026
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${requestScope.list}" var="food" varStatus="vs" begin="0" end="0">
    <h2>您的答案是${food.answer}</h2>
</c:forEach>
</body>
</html>
