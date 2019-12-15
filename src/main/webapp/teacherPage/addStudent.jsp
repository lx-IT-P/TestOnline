<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/20 0020
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/page_common.js"></script>
    <link href="../css/common_style_blue.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="../css/index_1.css" />
</head>

<body>
<!-- 页面标题 -->
<div id="TitleArea">
    <div id="TitleArea_Head"></div>
    <div id="TitleArea_Title">
        <div id="TitleArea_Title_Content">
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath }/images/title_arrow.gif"/> 添加学生
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <!-- 表单内容 -->

        <!-- 本段标题（分段标题） -->
        <div class="ItemBlock_Title">
            <img width="4" height="7" border="0" src="${pageContext.request.contextPath }/images/item_point.gif"> 学生信息&nbsp;
        </div>
        <!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <div class="ItemBlock2">
                    <table cellpadding="0" cellspacing="0" class="mainForm">

                        <tr>
                            <td width="80px">学生姓名</td>
                            <td><input type="text"  class="InputStyle" value="" id="name"/> *</td>
                        </tr>
                            <tr>
                                <td width="80px">学生性别</td>
                                <td><input type="text"  class="InputStyle" value="" id="sex"/> *</td>
                            </tr>
                            <tr>
                                <td width="80px">学生年龄</td>
                                <td><input type="text"  class="InputStyle" value="" id="age"/> *</td>
                            </tr>
                            <tr>
                                <td width="80px">学生电话</td>
                                <td><input type="text"  class="InputStyle" value="" id="phone"/> *</td>
                            </tr>
                            <tr>
                                <td width="80px">学生邮箱</td>
                                <td><input type="text"  class="InputStyle" value="" id="email"/> *</td>
                            </tr>

                    </table>
                </div>
            </div>
        </div>


        <!-- 表单操作 -->
        <div id="InputDetailBar">

            <input type="button" value="添加" class="FunctionButtonInput" id="submit">

            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>

</div>

</body>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script src="../layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    $("#submit").click(function () {
        var name = $("#name").val();
        var sex = document.getElementById("sex").value;
        var age = $("#age").val();
        var phone = $("#phone").val();
        var email = $("#email").val();
        $.post("${pageContext.request.contextPath}/StudentServlet?method=addStudent", {
            name: name,
            sex: sex,
            age: age,
            phone: phone,
            email: email
        }, function (data) {
            alert("添加成功！！！！！")
        })
    })
</script>
</html>
