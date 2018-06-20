<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示成绩</title>
<link href="http://cdn.bootcss.com/twitter-bootstrap/2.2.2/css/bootstrap.min.css" rel="stylesheet">
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
}
</style>
<script>
<%String noScore = (String)request.getAttribute("noScore");%>
var noScore = "<%=noScore%>";
if (noScore == "noScore") {
	alert("没有成绩信息");
}
</script>
</head>
<body>
<div id="main">
	<table style="table-layout:fixed" class="table table-hover table-bordered">
		<caption style="font-size: 20px;margin-top: 10px;margin-bottom: 10px;">学生成绩</caption>
		<thead>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>成绩</th>
			</tr>
		</thead>
<%
		if(request.getAttribute("score")!=null){
			out.print(request.getAttribute("score"));
		}
%>
	</table>
</div>
</body>
</html>