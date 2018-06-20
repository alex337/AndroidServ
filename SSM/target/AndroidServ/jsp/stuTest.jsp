<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>在线考试</title>
<style type="text/css">
body{
	margin:0;
	border:0;
	padding:0;
	background-color:#63B8FF;
}
#title{
	height:80px;
	width:600px;
	font-size:50px;
	margin:0 auto; 
	background-color: #63B8FF;
	padding-left: 60px;
	padding-top: 10px;
}
#body{
	margin:0;
	border:0;
	padding:0;
	width:100%;
	height:950px;
	background-image: url(//image.wjx.cn/images/newbg/oldbg2-bg.jpg);
    background-position-x: initial;
    background-position-y: initial;
    background-size: initial;
    background-repeat-x: repeat;
    background-repeat-y: no-repeat;
    background-attachment: initial;
    background-origin: initial;
    background-clip: initial;
    background-color: rgb(221, 244, 255);
	
}
#time{
	margin: 0 auto;
	width: 920px;
	height:50px;
}
#Content{
	width: 920px;
    padding-top: 10px;
	height:900px;
	margin: 0 auto;
}
#main{
	height: 800px;
	background: white;
    width:	920px;
    margin: 0 auto;
}
.con{
	height:680px;
	background-color:white;
}
.t{
	margin-bottom:10px;
	margin-left:30px;
	margin-right:30px;
	height:120px;
	background-color:white;
    border-bottom: 2px dashed #d7d8d9;
}
.btn{
	width: 120px;
	height: 40px;
}
#formDiv{
	padding-top: 40px;
	background-color: white;
	border-radius: 20px;
}
#pageChange{
	height: 30px;
	width: 280px;
	padding-bottom:10px;
	margin: 0 auto;
	margin-left: 30px;
	padding-left: 20px;
}
.title{
	padding-left: 50px;
	font-size:16px;
	font-weight: bold;
}
.answer{
	padding:5px;
	padding-top:10px; 
	padding-left: 60px;
	font-size:13px;
	font-weight: normal;
}
#sbmBtn{
	margin:0 auto;
	height: 60px;
	width: 100px; 
	padding-top: 10px;
}
</style>

	
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="./layer-v3.1.1/layer/layer.js"></script>
<script type="text/javascript">
function PageLast() {
	var divs=document.getElementsByClassName('con');
    for(var i=0;i<divs.length;i++){
        if(divs[i].style.display=='block'){
	        if(i==0){
	            alert("已经是第一页了");break;
	        }else{
	                divs[i].style.display="none";
	                divs[i-1].style.display="block";
	                break;
	        }
        }
    }
}
function PageNext() {
	var divs=document.getElementsByClassName('con');
    for(var i=0;i<divs.length;i++){
        if(divs[i].style.display=='block'){
	        if(i==divs.length-1){
	            alert("已经是最后第一页了");break;
	        }else{
	                divs[i].style.display="none";
	                divs[i+1].style.display="block";
	                break;
	        }
        }
    }
}

//判断题目
function check(){
	for(var i=1;i<=50;i++){//选择题
		var ts = document.getElementsByName("t"+i);
		if(ts[0]!=null){
			for(var j=0;j<ts.length;j++){
				if(ts[j].checked==true)
					break;
			}
			if(j==ts.length){
				alert("第"+i+"题未选择,请选择!");
				var divs=document.getElementsByClassName('con');
				for(var k=0;k<divs.length;k++){
					if(divs[k].style.display=='block'){
						divs[k].style.display="none";
						divs[(i-1)/5].style.display="block";
						break;
					}
				}
				break;
			}
		}
	}
	
	for(var i=51;i<=100;i++){
		var ts = document.getElementsByName("t"+i);
		if(ts[0]!=null){
			if(ts[0].value=="")
			{
				alert("还有填空题还未填空!");
					/*var divs=document.getElementsByClassName('con');
					for(var k=0;k<divs.length;k++) {
						if(divs[k].style.display=='block'){
							divs[k].style.display="none";
							divs[i / 5].style.display="block";
							//return false;
						}					
					}*/
					break;
				}
			}
		}
	var gnl=confirm("确定要提交？");
	if (gnl==true){
		return true;
	}else{
		return false;
	}
}


document.onkeydown = function (e) {
    var ev = window.event || e;
    var code = ev.keyCode || ev.which;
    if (code == 116) {
        ev.keyCode ? ev.keyCode = 0 : ev.which = 0;
        cancelBubble = true;
        return false;
    }
} //禁止f5刷新
document.oncontextmenu=function(){return false};//禁止右键刷新

var maxtime;
window.onload = function() {
	<% String time=(String)session.getAttribute("endTime"); %>
	var time = "<%=time%>";
	var d1 = new Date(time);
	var d2 = new Date();
	var d3 = d1 - d2;
	var h = Math.floor(d3/3600000); 
	var m = Math.floor((d3-h*3600000)/60000); 
	var s = Math.floor((d3-h*3600000-m*60000)/1000);
	//alert("相差"+h+"小时"+m+"分"+s+"秒"); 
	maxtime = h * 3600 + m * 60 + s;
	//alert(seconds);
}
//倒计时
function CountDown() {
	if(maxtime >= 0) {
		var minutes = Math.floor(maxtime/60);
		var seconds = Math.floor(maxtime%60);
		msg = "距离考试结束还有" + minutes + "分" + seconds + "秒";
		document.all["countdown"].innerHTML = msg;
		if(maxtime == 5 * 60) 
			layer.msg("考试还剩5分钟，请抓紧时间！");
		--maxtime;
	}
	else{
		clearInterval(timer);
		//alert("考试时间到!");
		//提交试卷
		document.getElementById("TestForm").submit();
	}
}
timer = setInterval("CountDown()",1000);
</script>
</head>
<body>
<div id="title">
<label>课堂测试</label>
</div>
<div id="body">
	<div id="Content">
		<div id="time">
		<h3 id="countdown">距离考试结束还有</h3>
		</div>
		<div id="formDiv">
		<form id="TestForm" action="${pageContext.request.contextPath}/TestSubmit" method="post" onsubmit="return check()">
		<%=request.getAttribute("sb") %>
		

		<div id="pageChange">
			<button class="btn" type="button" value="last" onclick="PageLast()">上一页</button>&nbsp;&nbsp;&nbsp;
			<button class="btn" type="button" value="next" onclick="PageNext()">下一页</button>
		</div>
		<div id="sbmBtn">
			<input id="submitBtn" class="btn" type="submit" value="提交试卷" />
		</div>
		</form>
		</div>
	</div>
</div>
</body>
</html>