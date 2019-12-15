<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/main.css" rel="stylesheet" type="text/css" />
<link href="../css/iconfont.css" rel="stylesheet" type="text/css" />
<link href="../css/test.css" rel="stylesheet" type="text/css" />
<title></title>
</head>
<style type="text/css">
.hasBeenAnswer {
	background: #5d9cec;
	color:#fff;
}
</style>


<body>

<div class="main">
		<!--nr start-->
		<div class="test_main">
			<div class="nr_left">
				<div class="test">

						<div class="test_title">
							<p class="test_time">
								<i class="icon iconfont">&#xe6fb;</i><b class="alt-1">01:40</b>
							</p>
							<font><input type="button" name="test_jiaojuan" value="交卷" onclick="jisuan()"></font>
						</div>
						
							<div class="test_content">
								<div class="test_content_title">
									<h2>单选题</h2>
									<p>
										<span>共</span><i class="content_lit">60</i><span>题，</span><span>合计</span><i class="content_fs">60</i><span>分</span>
									</p>
								</div>
							</div>
							
							<div class="test_content_nr">
							 <c:forEach items="${requestScope.list}" var="food" varStatus="vs">
								<ul>
									 <input type="text" name="zqda${vs.count }" value="${food.correct}"/>
										<li id="qu_0_${vs.count}" value="${food.id}" name="id">
						     					<div class="test_content_nr_tt">
							 				<i>${vs.count }</i><span>(1分)</span><font>${food.test_name }</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
											<ul>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer${vs.count }"
																	id="0_answer_1_option_1" value="A"
																/>
															
															
															<label for="0_answer_1_option_1">
																A.
																<p class="ue" style="display: inline;">${food.option1}</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer${vs.count }"
																	id="0_answer_1_option_2" value="B"
																/>
															
															
															<label for="0_answer_1_option_2">
																B.
																<p class="ue" style="display: inline;">${food.option2}</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer${vs.count }"
																	id="0_answer_1_option_3" value="C"
																/>
															
															
															<label for="0_answer_1_option_3">
																C.
																<p class="ue" style="display: inline;">${food.option3}</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer${vs.count }"
																	id="0_answer_1_option_4" value="D"
																/>
															
															
															<label for="0_answer_1_option_4">
																D.
																<p class="ue" style="display: inline;">${food.option4}</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
										</c:forEach>
										
									<div class="nr_right">
				<div class="nr_rt_main">
					<div class="rt_nr1">
						<div class="rt_nr1_title">
							<h1>
								<i class="icon iconfont">&#xe692;</i>答题卡
							</h1>
							<p class="test_time">
								<i class="icon iconfont">&#xe6fb;</i><b class="alt-1">01:40</b>
							</p>
						</div>
						
							<div class="rt_content">
								<div class="rt_content_tt">
									<h2>单选题</h2>
									<p>
										<span>共</span><i class="content_lit">60</i><span>题</span>
									</p>
								</div>
								<div class="rt_content_nr answerSheet">
									<ul>
										
											<li><a href="#qu_0_0">1</a></li>
										
											<li><a href="#qu_0_1">2</a></li>
										
											<li><a href="#qu_0_2">3</a></li>
										
											<li><a href="#qu_0_3">4</a></li>
										
											<li><a href="#qu_0_4">5</a></li>
										
											<li><a href="#qu_0_5">6</a></li>
										
											<li><a href="#qu_0_6">7</a></li>
										
											<li><a href="#qu_0_7">8</a></li>
										
											<li><a href="#qu_0_8">9</a></li>
										
											<li><a href="#qu_0_9">10</a></li>
										
											<li><a href="#qu_0_10">11</a></li>
										
											<li><a href="#qu_0_11">12</a></li>
										
											<li><a href="#qu_0_12">13</a></li>
										
											<li><a href="#qu_0_13">14</a></li>
										
											<li><a href="#qu_0_14">15</a></li>
										
											<li><a href="#qu_0_15">16</a></li>
										
											<li><a href="#qu_0_16">17</a></li>
										
											<li><a href="#qu_0_17">18</a></li>
										
											<li><a href="#qu_0_18">19</a></li>
										
											<li><a href="#qu_0_19">20</a></li>
										
											<li><a href="#qu_0_20">21</a></li>
										
											<li><a href="#qu_0_21">22</a></li>
										
											<li><a href="#qu_0_22">23</a></li>
										
											<li><a href="#qu_0_23">24</a></li>
										
											<li><a href="#qu_0_24">25</a></li>
										
											<li><a href="#qu_0_25">26</a></li>
										
											<li><a href="#qu_0_26">27</a></li>
										
											<li><a href="#qu_0_27">28</a></li>
										
											<li><a href="#qu_0_28">29</a></li>
										
											<li><a href="#qu_0_29">30</a></li>
										
											<li><a href="#qu_0_30">31</a></li>
										
											<li><a href="#qu_0_31">32</a></li>
										
											<li><a href="#qu_0_32">33</a></li>
										
											<li><a href="#qu_0_33">34</a></li>
										
											<li><a href="#qu_0_34">35</a></li>
										
											<li><a href="#qu_0_35">36</a></li>
										
											<li><a href="#qu_0_36">37</a></li>
										
											<li><a href="#qu_0_37">38</a></li>
										
											<li><a href="#qu_0_38">39</a></li>
										
											<li><a href="#qu_0_39">40</a></li>
										
											<li><a href="#qu_0_40">41</a></li>
										
											<li><a href="#qu_0_41">42</a></li>
										
											<li><a href="#qu_0_42">43</a></li>
										
											<li><a href="#qu_0_43">44</a></li>
										
											<li><a href="#qu_0_44">45</a></li>
										
											<li><a href="#qu_0_45">46</a></li>
										
											<li><a href="#qu_0_46">47</a></li>
										
											<li><a href="#qu_0_47">48</a></li>
										
											<li><a href="#qu_0_48">49</a></li>
										
											<li><a href="#qu_0_49">50</a></li>
										
											<li><a href="#qu_0_50">51</a></li>
										
											<li><a href="#qu_0_51">52</a></li>
										
											<li><a href="#qu_0_52">53</a></li>
										
											<li><a href="#qu_0_53">54</a></li>
										
											<li><a href="#qu_0_54">55</a></li>
										
											<li><a href="#qu_0_55">56</a></li>
										
											<li><a href="#qu_0_56">57</a></li>
										
											<li><a href="#qu_0_57">58</a></li>
										
											<li><a href="#qu_0_58">59</a></li>
										
											<li><a href="#qu_0_59">60</a></li>
										
									</ul>
								</div>
							</div>
						
						
					
						
					</div>

				</div>
			</div>
		</div>
		<input type="button" value="提交"  onclick="jisuan()"/>
		<!--nr end-->
		<div class="foot"></div>
	</div>
	 <script src="../js/jquery-1.11.3.min.js"></script>
	<script src="../js/jquery.easy-pie-chart.js"></script>
	<!--时间js-->
	<script src="../js/jquery.countdown.js"></script>
 
 <script src="../js/jquery.js"></script>
 <script>
 function jisuan(){
 var sum = 0;
     var ans="";
	for(var i=0;i<7;i++){
	var option  = document.getElementsByName("answer"+i);
	var answer = document.getElementsByName("zqda"+i);
	for(var j=0;j<option.length;j++){
	for(var k=0;k<answer.length;k++){
	if(option[j].checked)
	{
        ans+=j+"."+option[j].value;
		if(option[j].value == answer[k].value){
	 sum +=1;
	        }
	     }
     }
 }
	}
     $.post("${pageContext.request.contextPath}/AnswerServlet?method=addAnswer",
         {answer:ans},
         function (data) {
             // alert(data);
             console.log(data);
             if(data=="1")
                 alert("添加成功！");
             else
                 alert("添加失败！");
         })
     $.post("${pageContext.request.contextPath}/ExamServlet?method=addExam",
         {score:sum},
         function (data) {
             // alert(data);
             console.log(data);
             if(data=="1")
                 alert("添加成功！");
             else
                 alert("添加失败！");
         })
 alert("您是否确认交卷");
	alert(ans);

 }
 
  
		
	</script> 
</body>
</html>
