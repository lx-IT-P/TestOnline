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
    <title>注册</title>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/crowd.css"/>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>

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
                <div> |</div>
                <input type="text" placeholder="账号" id="inputusername" class="inputusername"/>
            </div>
            <div class="password">
                <span class="glyphicon glyphicon-lock"></span>
                <div> |</div>
                <input type="password" placeholder="密码" id="inputpwd" class="inputpwd"/>
            </div>
            <div class="rememberdiv">
                <a href="#" class="forgeta">忘记密码</a>
            </div>
            <input class="btn btn-login btn-primary" value="注册" type="button" id="registerbtn" />
            <%--<button class="btn btn-login btn-primary" id="registerbtn">注册</button>--%>
        </form>
    </div>
</div>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/constellation.js"></script>
<script type="text/javascript">
    $("#registerbtn").click(function () {
        // window.location.href="index.jsp";
        var id = $("#inputusername").val();
        var pwd = document.getElementById("inputpwd").value;
        // alert(id+" "+pwd);
        $.post("${pageContext.request.contextPath}/TeacherServlet?method=addTeacher", {
            userid: id,
            userpwd: pwd
        },function (data) {
            console.log("11111")
            if(data=="0"){
                alert("此用户名已存在");

            }else if(data=="1"){
                // alert("注册成功");
                window.location.href="index.jsp";
            }
        });
    })

</script>
</body>
</html>
