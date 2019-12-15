<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线答题系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" media="screen" type="text/css" />

</head>
  <body>
<style>
body{background-image:url("${pageContext.request.contextPath }/app/detail/img/bj.jpg");}
</style>
  <div style="text-align:center;clear:both;">
<script src="${pageContext.request.contextPath }/app/detail/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/app/detail/follow.js" type="text/javascript"></script>
</div>
  <div class="wrapper">
    <div class="border-circle" id="one1"></div>
    <div class="border-circle" id="two1"></div>
    <div class="background-circle">
      <div class="triangle-light"></div>
      <div class="body"></div>
      <span class="shirt-text">页</span>
      <span class="shirt-text">面</span>
      <span class="shirt-text">错</span>
      <span class="shirt-text">误</span>
      <span class="shirt-text">啦</span>
      <div class="triangle-dark"></div>
    </div>
    <div class="head">
      <div class="ear" id="left1"></div>
      <div class="ear" id="right1"></div>
      <div class="hair-main">
        <div class="sideburn" id="left"></div>
        <div class="sideburn" id="right"></div>
        <div class="hair-top"></div>
      </div>
      <div class="face">
        <div class="hair-bottom"></div>
        <div class="nose"></div>
        <div class="eye-shadow" id="left2">
          <div class="eyebrow"></div>
          <div class="eye"></div>
        </div>
        <div class="eye-shadow" id="right2">
          <div class="eyebrow"></div>
          <div class="eye"></div>
        </div>
        <div class="mouth"></div>
        <div class="shadow-wrapper">
          <div class="shadow"></div>
        </div>
      </div>
    </div>
    <span class="music-note" id="one">&#9835;</span>
    <span class="music-note" id="two">&#9834;</span>
  </div>
</body>
</html>

</body>

</html>