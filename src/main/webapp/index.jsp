<%--
  Created by IntelliJ IDEA.
  User: 丁信丽
  Date: 2018/7/22
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/crowd.css"/>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<header>
    <div class="bg">
        <canvas id="display"></canvas>
        <div id="blachole"></div>
    </div>
</header>
<div class="divside">
    <div class="divlogin">
        <form method="post" class="formlogin">

            <img src="images/icon.png" alt="logo" class="imgs">

            <div class="username">
                <span class="glyphicon glyphicon-user"></span>
                <div> | </div>
                <input type="text" placeholder="账号" id="username" class="inputusername" name="username"/>
            </div>
            <div class="password">
                <span class="glyphicon glyphicon-lock"></span>
                <div> | </div>
                <input type="password" placeholder="密码" id="userpwd" class="inputpwd"/>
                <% String username = request.getParameter("username");
                session.setAttribute("username",username);%>
            </div>
            <div class="rememberdiv">
                <a href="#" class="forgeta">忘记密码</a>
            </div>
            <%--<button class="btn btn-login btn-primary" id="loginbtn">登录</button>--%>
            <input class="btn btn-login btn-primary" type="button" value="登录" id="loginbtn" />
            <i id="iwechat" class="layui-icon layui-icon-login-wechat" ></i>
            <i id="iqq" class="layui-icon layui-icon-login-qq"></i>
            <i id="iblog" class="layui-icon layui-icon-login-weibo"></i>
            <a href="register.jsp" class="registera">注册账号</a>
        </form>
    </div>
</div>

<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/constellation.js"></script>
<script type="text/javascript">
    $("#loginbtn").click(function () {
        var id=$("#username").val();
        var pwd=$("#userpwd").val();
        // alert(id+" "+pwd);
        $.post("${pageContext.request.contextPath}/UserServlet?method=select",{userid:id,userpwd:pwd},function (data) {

            console.log(data);
            console.log(data[0].identity);
            if(data[0].identity=="教师"){
                // alert("教师登录");
               window.location.href="/teacherPage/index.jsp" ;
            }else if (data[0].identity=="学生") {

                window.location.href="/studentPage/index.jsp";
            }

        },"json")
    })
</script>
</body>
</html>
