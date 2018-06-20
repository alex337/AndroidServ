<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试卷预览</title>

<style type="text/css">
body{ margin:0; padding:0; border:0; }
#main{
	width:700px;
    height: auto;
    margin:0 auto;
    padding: 0;
    border: 0;
    font-size: 15px;
    background-color:#F2F2F2;
    border-radius: 20px;
 	padding-top: 30px;
 	padding-left:80px;
 	padding-bottom:50px;
 	margin-top: 30px;
 	margin-bottom: 30px;
}
.title{
	font-weight: bold;
}
.choice{
	padding-left: 30px;
	padding-top: 5px;
}
.answer{
	padding-left: 30px;
	padding-top:5px;
}
.t{
	padding-top:5px;
	padding-bottom:5px;
}
</style>
<script>
<%String noTest = (String)request.getAttribute("noTest");%>
var noTest = "<%=noTest%>";
if (noTest == "noTest") {
	alert("还没有试卷，请先生成试卷!");
}
</script>
</head>
<body>
<div id="main">
	<%=request.getAttribute("testInfo") %>
</div>
</body>
</html>