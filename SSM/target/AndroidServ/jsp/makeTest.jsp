<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生成考试</title>
<link href="http://cdn.bootcss.com/twitter-bootstrap/2.2.2/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="css/bootstrap-datetimepicker.css">

<style type="text/css">
body{ margin:0; padding:0; border:0; }
#main{
	text-align: center;
    background-color: ;
	width:600px;
    height: 400px;
    margin:0 auto;
    padding: 0;
    border: 0;
    margin-top:60px;
</style>
<script type="text/javascript">

<%
	//接收结果
	String result=(String)request.getAttribute("result");
	if(result!=null){
		if(result=="True")
			out.print("alert('生成成功!')");
		else
			out.print("alert('生成失败!')");
	}
%>
</script>
</head>
<body>
<div id="main">
	<form action="${pageContext.request.contextPath}/FormTest" method="post" onsubmit="return check()">  <!-- Datetime=考试开始时间 ；Timelimit=考试时间限制  -->
	<div class="form-group">
		<label for="Datetime" class="col-md-2 control-label">考试开始时间:</label>
		<div id="datetime" class="input-group date form_datetime col-md-5" >
			<input id="Datetime" name="Datetime" class="form-control" size="16" type="text" value="" readonly >
			<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
			<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
		</div>
	</div>
	<div class="form-group">
		<label for="Timelimit" class="col-md-2 control-label" >考试时限(分钟):</label>
		<label><input name="Timelimit" id="Timelimit" type="text" onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="请输入整数" value=""/></label>
	</div>
	<div class="form-group">
		<label for="Timelimit" class="col-md-2 control-label" >生成考试:</label>
		<button type="submit" class="btn" onclick="setDate()">随机生成试卷</button>
	</div>
	</form>
</div>

<script type="text/javascript" src="js/jquery-3.2.1.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
    	format: 'yyyy-mm-dd hh:ii',
        weekStart: 1,
        todayBtn:  1,
        autoclose: true,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
        showMeridian: 0,
       	language: 'zh-CN',
       	startDate : new Date()
    });

function check() {
	if($("#Datetime").val()==""||$("#Timelimit").val()==""){
		alert("请填写时间与时限!")
		return false;
	}
	alert("提交试卷生成请求")
	return true;
}
</script>
</body>
</html>