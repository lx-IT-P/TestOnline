<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/20 0020
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/page_common.js"></script>
    <link href="${pageContext.request.contextPath }/css/common_style_blue.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index_1.css"/>
</head>
<body>
<form action="${pageContext.request.contextPath }/TeacherServlet?add" method="post" class="layui-form">

    <!-- 页面标题 -->
    <div id="TitleArea">
        <div id="TitleArea_Head"></div>
        <div id="TitleArea_Title">
            <div id="TitleArea_Title_Content">
                <img border="0" width="13" height="13"
                     src="${pageContext.request.contextPath }/images/title_arrow.gif"/> 添加新试题
            </div>
        </div>
        <div id="TitleArea_End"></div>
    </div>

    <!-- 主内容区域（数据列表或表单显示） -->
    <div id="MainArea">
        <!-- 表单内容 -->
        <%--<form action="${pageContext.request.contextPath }/TeacherServlet?method=add" method="post" enctype="multipart/form-data">--%>
        <!-- 本段标题（分段标题） -->
        <div class="ItemBlock_Title">
            <img width="4" height="7" border="0" src="${pageContext.request.contextPath }/images/item_point.gif"> 试题信息&nbsp;
        </div>
        <!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <div class="ItemBlock2">
                    <table cellpadding="0" cellspacing="0" class="mainForm">
                        <tr>
                            <td>科目：</td>
                            <td>
                                <select id="subSelect">
                                    <option>语文</option>
                                    <option>数学</option>
                                    <option>英语</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td width="80px">试题内容：</td>
                            <td><input id="testContent" type="text" class="InputStyle" value="" name="name"/> *</td>
                        </tr>
                        <tr>
                            <td>选项A：</td>
                            <td><textarea id="option1" name="remark" class="TextareaStyle" name="name1"></textarea></td>
                        </tr>
                        <tr>
                            <td>选项B：</td>
                            <td><textarea id="option2" name="remark" class="TextareaStyle" name="name2"></textarea></td>
                        </tr>

                        <tr>
                            <td>选项C：</td>
                            <td><textarea id="option3" name="remark" class="TextareaStyle" name="name3"></textarea></td>
                        </tr>
                        <tr>
                            <td>选项D：</td>
                            <td><textarea id="option4" name="remark" class="TextareaStyle" name="name4"></textarea></td>
                        </tr>
                        <tr>
                            <td width="80px">正确答案：</td>
                            <td><input id="trueOp" type="text" class="InputStyle" value="" name="name5"/> *</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="button" value="添加" class="FunctionButtonInput" id="addQuestionBtn"/>
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
</form>
</div>
<script src="../layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    $("#addQuestionBtn").click(function () {
        var sub=$("#subSelect").val();
        var subid=1;
        if(sub=="语文"){
            subid=1;
        }
        else if(sub=="数学"){
            subid=2;
        }else if(sub=="英语"){
            subid=3;
        }
        var question=$("#testContent").val();
        var op1=$("#option1").val();
        var op2=$("#option2").val();
        var op3=$("#option3").val();
        var op4=$("#option4").val();
        var trueop=$("#trueOp").val();
        // alert(sub+" "+question+" "+op1+" "+op2+" "+op3+" "+op4+" "+trueop);
        $.post("${pageContext.request.contextPath}/QuestionServlet?method=addQuestion",
            {subject:subid,question:question,option1:op1,option2:op2,option3:op3,option4:op4,trueOp:trueop},
        function (data) {
            // alert(data);
            console.log(data);
            if(data=="1")
                alert("添加成功！");
            else
                alert("添加失败！");
        })
    })
</script>
</body>

</html>
