<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/20 0020
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }../js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }../js/page_common.js"></script>
    <link href="${pageContext.request.contextPath }../css/common_style_blue.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }../css/index_1.css" />
</head>
<body>
<div id="TitleArea">
    <div id="TitleArea_Head"></div>
    <div id="TitleArea_Title">
        <div id="TitleArea_Title_Content">
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath }../images/title_arrow.gif"/> 学生列表
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>


<!-- 过滤条件 -->
<div id="QueryArea">
    <form action="${pageContext.request.contextPath }/food" method="get">
        <input type="hidden" name="method" value="search">
        <input type="text" name="keyword" title="请输入试题名称">
        <input type="submit" value="搜索">
    </form>
</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <td>学生姓名</td>
            <td>学生性别</td>
            <td>学生年龄</td>
            <td>学生电话</td>
            <td>学生邮箱</td>

        </tr>
        </thead>

        <!--显示数据列表 -->
        <tbody id="TableData">
        <c:forEach items="${requestScope.list}" var="food" varStatus="vs">
            <tr class="TableDetail1">
                <td>${vs.count }</td>
                <td>${food.stu_name }</td>
                <td>${food.stu_sex}</td>
                <td>${food.stu_age}</td>
                <td>${food.stu_phone}</td>
                <td>${food.stu_email}</td>

            </tr>

        </c:forEach>
        </tbody>
    </table>

    <!-- 其他功能超链接 -->
    <%--<div id="TableTail" align="center">--%>
    <%--<div class="FunctionButton"><a href="${pageContext.request.contextPath }/food?method=findFoodType">添加</a></div>--%>
    <%--当前${requestScope.pageBean.currentPage }/${requestScope.pageBean.totalPage }页     &nbsp;&nbsp;--%>
    <%--<a href="${pageContext.request.contextPath }/food?method=list&currentPage=1">首页</a>--%>
    <%--<a href="${pageContext.request.contextPath }/food?method=list&currentPage=${requestScope.pageBean.currentPage-1}">上一页 </a>--%>
    <%--<a href="${pageContext.request.contextPath }/food?method=list&currentPage=${requestScope.pageBean.currentPage+1}">下一页 </a>--%>
    <%--<a href="${pageContext.request.contextPath }/food?method=list&currentPage=${requestScope.pageBean.totalPage}">末页</a>--%>
    <%--</div>--%>
    <%--</div>--%>
</body>
</html>
