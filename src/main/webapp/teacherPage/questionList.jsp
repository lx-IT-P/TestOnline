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
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/page_common.js"></script>
    <link href="${pageContext.request.contextPath }/css/common_style_blue.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index_1.css" />
    <style rel="stylesheet">
        td{
            width: 100px;
            text-align: center;
            border: 1px solid #D8EDFC;
        }
    </style>
</head>
<body>
<div id="TitleArea">
    <div id="TitleArea_Head"></div>
    <div id="TitleArea_Title">
        <div id="TitleArea_Title_Content">
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath }/images/title_arrow.gif"/> 试题列表
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>


<!-- 过滤条件 -->
<div id="QueryArea">
    <form action="${pageContext.request.contextPath }/QuestionServlet?method=search" method="post">
        <input type="hidden" name="method" value="search">
        <input type="text" name="keyword" title="请输入试题名称">
        <input type="submit" value="搜索">
        &nbsp;&nbsp;&nbsp;&nbsp;
        科目：
        <select id="subname">
            <option>语文</option>
            <option>数学</option>
            <option>英语</option>
        </select>
        <input type="button" value="筛选" onclick="Screening()"/>
    </form>
</div>
<!-- 主内容区域（数据列表或表单显示） -->
<%--<form action="${pageContext.request.contextPath }/QuestionServlet?method=selectQuestion" method="post">--%>
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <th>试题编号</th>
            <th>科目</th>
            <th>试题内容</th>
            <th>选项A</th>
            <th>选项B</th>
            <th>选项C</th>
            <th>选项D</th>
            <th>正确选项</th>
            <th>操作</th>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="TableData"></tbody>
    </table>
</div>
<br><br>
<%--<div id="asd">--%>

    <div id="divshow" hidden="hidden">

        试卷名称：<input type='text' id='examName'/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        总分设定：<input type='text' id='score'/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type='button' value='创建试卷' onclick='publishBtn()'/>
    </div>
<%--</div>--%>

<script type="text/javascript">
    window.onload=function () {
        $.post("${pageContext.request.contextPath}/QuestionServlet?method=selectQuestion",function (data) {
            console.log(data);
            console.log(data.length);
            console.log(data[0].sub_id);
            str="";
            for (var i = 0; i <data.length ; i++) {
            str="<tr><td>"+(i+1)+"</td><td>"+data[i].sub_id+"</td><td>"+data[i].test_name+"</td><td>"+data[i].option1+"</td><td>"+
            data[i].option2+"</td><td>"+data[i].option3+"</td><td>"+data[i].option4+"</td><td>"+data[i].correct+"</td><td><a href='${pageContext.request.contextPath}/updateQuestion.jsp?testid='"+data[i].test_id+"''>"
            +"修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a>删除</a></td></tr>";
            document.getElementById("TableData").innerHTML+=str;
            }

        },"json")
    }
    function Screening() {

        var sub=$("#subname").val();
        // var subid=1;
        if(sub=="语文"){
            subid=1;
        }
        else if(sub=="数学"){
            subid=2;
        }else if(sub=="英语"){
            subid=3;
        }
        // alert(subid)
        $.post("${pageContext.request.contextPath}/QuestionServlet?method=screen",{subid:subid},function (data) {
            // console.log("12222");
            // alert(data);
            // console.log(data)
            document.getElementById("MainArea").innerHTML="";
            var tb="<table class=\"MainArea_Content\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "        <!-- 表头-->\n" +
                "        <thead>\n" +
                "        <tr align=\"center\" valign=\"middle\" id=\"TableTitle\">\n" +
                "            <th>选择</th>\n" +
                "            <th>试题编号</th>\n" +
                "            <th>试题内容</th>\n" +
                "            <th>选项A</th>\n" +
                "            <th>选项B</th>\n" +
                "            <th>选项C</th>\n" +
                "            <th>选项D</th>\n" +
                "            <th>正确选项</th>\n"+
                "        </tr>\n" +
                "        </thead>\n" +
                "        <tbody id=\"TableData1\"></tbody></table>";
            document.getElementById("MainArea").innerHTML=tb;
            str="";
            for (var i = 0; i <data.length ; i++) {
                str="<tr><td>"+"<input name=\"check\" value=\"'"+data[i].test_id+"'\" type=\"checkbox\"/>"+"</td><td>"+(i+1)+"</td><td>"+data[i].test_name+"</td><td>"+data[i].option1+"</td><td>"+
                    data[i].option2+"</td><td>"+data[i].option3+"</td><td>"+data[i].option4+"</td><td>"+data[i].correct+"</td></tr>";
                    document.getElementById("TableData1").innerHTML+=str;
            }

            // strBtn="&nbsp;&nbsp;&nbsp;&nbsp;试卷名称：<input type='text' id='examName'/>&nbsp;&nbsp;&nbsp;&nbsp;总分设定：<input type='text' id='score'/>&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' value='创建试卷' onclick='publishBtn()'/>";
            // document.getElementById("asd").innerHTML+=strBtn;
            // document.getElementById("divshow").show();
            $("#divshow").show();
        },"json")


    }
    function publishBtn(){
        console.log("asssssss");
        var testCheck=document.getElementsByName("check");
        var ExamName=document.getElementById("examName").value;
        var Score=document.getElementById("score").value;
        // alert(aa[0].value);
        // alert(ExamName)
        // alert(Score)
        var testId="";
        for(var i=0;i<testCheck.length;i++){
            if(testCheck[i].checked){
                testId+=testCheck[i].value+"_";
            }
        }
        alert(testId);
        $.post("${pageContext.request.contextPath}/ExamServlet?method=addExam",{examName:ExamName,testsid:testId,totalScore:Score},function (data) {
            console.log(data);
            if(data=="1"){
                alert("创建试卷成功!")
            }else {
                alert("创建试卷失败!")
            }
        },"json")

    }
</script>
</body>
</html>
