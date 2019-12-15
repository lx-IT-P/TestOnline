<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>My JSP 'score.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="../layui/css/layui.css"  media="all">

  </head>
  <style>
  .score{
  text-align:center;
  }
  </style>
  
  <body>
  <ul class="layui-nav">
  <li class="layui-nav-item">
    <a href="">控制台<span class="layui-badge"></span></a>
  </li>
  <li class="layui-nav-item">
    <a href="">个人中心<span class="layui-badge-dot"></span></a>
  </li>
  <li class="layui-nav-item" lay-unselect="">
    <a href="javascript:;"><img src="http://t.cn/RCzsdCq" class="layui-nav-img">我</a>
    <dl class="layui-nav-child">
      <dd><a href="javascript:;">修改信息</a></dd>
      <dd><a href="javascript:;">安全管理</a></dd>
      <dd><a href="javascript:;">退了</a></dd>
    </dl>
  </li>
</ul>
<div style="margin-top: 15px;">
 
   <div class="score">
   <h1>您&nbsp好&nbsp同&nbsp学</h1>
       <c:forEach items="${requestScope.list}" var="food" varStatus="vs" begin="0" end="0">
   <h2>您的得分是${food.score}</h2>
</c:forEach>
   <a href="${pageContext.request.contextPath }/AnswerServlet?method=selectAnswer"/>查看答案</a>
   </div>
   <script src="${pageContext.request.contextPath }/app/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use('element', function(){
  var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
  
  //监听导航点击
  element.on('nav(demo)', function(elem){
    //console.log(elem)
    layer.msg(elem.text());
  });
});
</script>
  </body>
  
</html>
