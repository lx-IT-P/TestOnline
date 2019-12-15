<%--
  Created by IntelliJ IDEA.
  User: 丁信丽
  Date: 2018/7/26
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>在线考试系统</title>
</head>
<frameset rows="100px,*,19px" framespacing="0" border="0" frameborder="0">
    <frame src="${pageContext.request.contextPath }../studentPage/top.jsp" scrolling="no" noresize />
    <frameset cols="178px,*">
        <frame noresize src="${pageContext.request.contextPath }../studentPage/left.jsp" scrolling="yes" />
        <frame noresize name="right" src="${pageContext.request.contextPath }../studentPage/right.jsp" scrolling="yes" />
    </frameset>
    <frame noresize name="status_bar" scrolling="no" src="${pageContext.request.contextPath }../studentPage/bottom.jsp" />
</frameset>
<noframes>
<body>
你的浏览器不支持框架布局，推荐你使用<a href="http://www.firefox.com.cn/download/" style="text-decoration: none;">火狐浏览器</a>,
<a href="http://www.google.cn/intl/zh-CN/chrome/" style="text-decoration: none;">谷歌浏览器</a>
</body>
</noframes>
</html>
