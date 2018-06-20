<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java在线考试系统</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
body{ margin: 0; border:0; padding:0;}
#head{
	width: 0 auto;
	height: 200px;
	background-color: #B0E2FF;
}
#title{
	height:100px;
	width:800px;
	margin:0 auto;
	font-size:80px;
}
#hello{
	float: left;
	margin-top: 30px;
	margin-left: 120px;
	font-size: 20px;
}
#exit{
	float:right;
	margin-top:60px;
	margin-right:300px;
	font-size: 20px;
}
#body{
	width: 0 auto;
	height: 500px;
	background-color: ;
}
#tips{
	width:400px;
	margin:auto ;
	padding-top:50px;
	padding-bottom:50px;
	font-size: 25px;

}
.form-control{
	margin: 0;
	padding: 5px;
}
#main{
	text-align: center;
    background-color: ;
    width: 500px;
    height: 350px;
    margin:auto ;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
}
#button_test{
	margin-top: 5px;
	width: 300px;
	padding: 5px;
	font-size: 60px;
	vertical-align:middle;
	-moz-border-radius: 3px;
	-webkit-border-radius:3px;
	border-radius: 5px; 
	border: 1px solid #c9c9c9 ;
}
</style>

<script type="text/javascript">
var maxtime;
var temp = 0;
function CountDown() {
	if(maxtime >= 0) {
		var minutes = Math.floor(maxtime/60);
		var seconds = Math.floor(maxtime%60);
		msg = "距离考试开始还有" + minutes + "分" + seconds + "秒";
		document.all["tips"].innerHTML = msg;
		--maxtime;
	}
	else{
		clearInterval(timer);
		//alert("考试时间到，请开始考试!");
		//进入考试
		if (temp == 0)
			document.getElementById("button_test").removeAttribute("disabled");
	}
}
timer = setInterval("CountDown()",1000);

window.onload=function() {
	
	//登录学生名字获取
<%
	String name=(String)session.getAttribute("username");
	String IDCard=(String)session.getAttribute("IDCard");
	String sID=(String)session.getAttribute("userid");
	String Password=(String)session.getAttribute("PassWord");
	
	String Result=(String)request.getParameter("Result");
%>
	var result = "<%=Result%>";
	if(result==null);
	else if(result=="OK")
		alert("修改成功！");
	else if(result=="NO")
		alert("修改失败！");
	
	var a = "<%=name%>" ;
	if(a == "" || a == "null"){
		alert("您还未登录！");
		//window.parent.frames.location.href="../jsp/Login.jsp";
		//document.getElementById("Login_state").innerHTML="<a href='../jsp/Login.jsp'>登录</a>&nbsp;&nbsp;";
	}
	//考试开始时间获取
	<% String time=(String)session.getAttribute("startTime"); %>
	var time = "<%=time%>";
	var d1 = new Date(time);
	var d2 = new Date();
	var d3 = d1 - d2;
	var h = Math.floor(d3/3600000); 
	var m = Math.floor((d3-h*3600000)/60000); 
	var s = Math.floor((d3-h*3600000-m*60000)/1000); 
	//alert("相差"+h+"小时"+m+"分"+s+"秒"); 
	maxtime = h * 3600 + m * 60 + s;//离考试开始总秒数	
	
	<%Integer score = (Integer)request.getAttribute("score");%>
	var score = "<%=score%>";
	if (score != "" && score != "null") {
		confirm("你此次考试的成绩为：" + score);
		document.getElementById("button_test").setAttribute('disabled','disabled');
		temp = 1;
	}
	
	<%String aTest = (String)request.getAttribute("aTest");%>
	var aTest = "<%=aTest%>";
	if (aTest != "null" && aTest != "") {
		confirm("你已经考完试了！");
		document.getElementById("button_test").setAttribute('disabled','disabled');
		temp = 1;
	}
	
	<%String over = (String)request.getAttribute("overTest");%>
	var over="<%=over%>";
	if(over != "null" && over != "") {
		alert("考试已经结束！");
		document.getElementById("button_test").setAttribute('disabled','disabled');
		temp = 1;
	}
	
	<%String noTEST = (String)request.getAttribute("noTEST");%>
	var noTEST="<%=noTEST%>";
	if(noTEST == "noTEST") {
		alert("当前没有考试！");
		document.getElementById("button_test").setAttribute('disabled','disabled');
		temp = 1;
	}
	
}
function  checkPwd(){
	var old = $("#oldPassword").val();
	var rPwd = "<%=Password%>";
	var newPwd =  $("#newPassword").val();
	var checkPwd =  $("#checkPassword").val();
	
	if(old==""||newPwd==""||checkPwd==""){
		alert("不能为空");
		return false;
	}
	
	if(rPwd==old&&newPwd==checkPwd&&old!=null){
		return true;
	}else if(newPwd!=checkPwd){
		alert("两次输入密码不同");
		return false;
	}else{
		alert("旧密码输入错误");
		return false;
	}
}
</script>
</head>
<body>
<div id="head">
	<div id="title">
	<h1 align="center">课堂测试</h1>
	</div>
</div>
<div id="body">
	<div id="tips">
		<label>距离考试开始时间:0分0秒</label>
	</div>
	<div id="main">
	<form name="menuForm" action="${pageContext.request.contextPath}/EnterTest" method="post">
	<input id="button_test" name="Nicholas" type="submit" value="开始考试" disabled="disabled" />
	</form>
	</div>
</div>
        <div class="modal fade" id="myModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" style="width:600px">
                <div class="modal-content">
                    <div class="modal-header">
                        <!--  模态框标题  -->
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <!--  关闭按钮  -->
                        <h4>修改用户信息</h4>
                        <!--  标题内容  -->
                    </div>
					<form  action="${pageContext.request.contextPath}/UpdatePassword?type=Student&id=<%=sID%>"   method="post" class="form-horizontal" role="form" 
							onsubmit="return checkPwd()" >
                    <div class="modal-body">
                        <!--  模态框内容，我在此处添加一个表单 -->
                            <div class="form-group">
                                <label for="oldPassword" class="col-sm-2 control-label"  >旧密码</label>
                                <div class="col-sm-9">
                                    <input name="oldPassword" id="oldPassword" class="form-control well" type="password" value=""></input>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="newPassword" class="col-sm-2 control-label" >新密码</label>
                                <div class="col-sm-9">
                                     <input name="newPassword" id="newPassword" class="form-control well" type="password" value=""></input>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="checkPassword" class="col-sm-2 control-label">确认密码</label>
                                <div class="col-sm-9">
                                     <input name="checkPassword" id="checkPassword" class="form-control well" type="password" value=""></input>
                                </div>
                            </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-success" >确定</button>
                        <button type="button" class="btn " data-dismiss="modal">取消</button>
                    </div>
				</form>
                </div>
            </div>
        </div>
</body>
</html>