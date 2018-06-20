<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="/bootstrap-select-1.12.4/dist/css/bootstrap-select.min.css" rel="stylesheet" />
<script src="/bootstrap-select-1.12.4/dist/js/bootstrap-select.min.js"></script>
<title>上传试题</title>

<script type="text/javascript">
window.onload = function() {
	<%String upload = (String)request.getAttribute("upload");%>
	var upload = "<%=upload%>";
	if (upload != "null" && upload != "") {
		alert("上传成功。");
	}
	<%String uploadFail = (String)request.getAttribute("uploadFail");%>
	var uploadFail = "<%=uploadFail%>";
	if (uploadFail != "null" && uploadFail != "") {
		alert("上传失败。");
	}
}
function uploadStyle(s){
	var Style=document.getElementsByName('NowUploadStyle');
	var All=document.getElementById("styleAll");
	var Type=document.getElementById("uploadType");
	var type1=document.getElementById("OneChoice");
	var type2=document.getElementById("OneCompletion");
	var submitBtn=document.getElementById("oneSubmit");

	if(s=="one"){
		Style[0].value = "one";
		Type.style.display="block";
		All.style.display="none";
	}
	else if(s=="all"){
		Style[0].value = "all";
		Type.style.display="none";
		All.style.display="block";
	}
	type1.style.display="none";
	type2.style.display="none";
	submitBtn.style.display="none";


}

function display(d) {
	var Style=document.getElementsByName('NowUploadStyle');
	var type1=document.getElementById("OneChoice");
	var type2=document.getElementById("OneCompletion");
	var submitBtn=document.getElementById("oneSubmit");
	if(d=="Choice"){
		type1.style.display="block";
		type2.style.display="none";
	}
	else if(d=="Completion"){
		type2.style.display="block";
		type1.style.display="none";
	}
	submitBtn.style.display="block";

}
</script>

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
.btn{
	width: 120px;
	height: 40px;
	border-radius: 5px;
}
#uploadStyle{
	padding-top: 30px;
}
#uploadType{
	font-size: 20px;
}
#styleOne{
	margin:0 auto;
}
#styleAll{
	font-size: 20px;
}
p{
	font-size: 10px;
}
</style>
</head>
<body>
<div id="main">
	<div id="uploadStyle" >
		<button class="btn" type="button"  onclick="uploadStyle('one')">逐一上传</button>&nbsp;&nbsp;&nbsp;&nbsp;
		<input name="NowUploadStyle" type="hidden" value="" />
	</div>
	
	<div id="styleOne" >
	
	<!-- form ：题目类型name="type" ; 选择题题目name="choiceTitle" ,选项ABCD name="OptionA"、"OptionB".. 答案name="answer"  ; 
									   填空题题目name="completionTitle",答案name="answerText"                                -->
	
		<form  id="oneForm" action="${pageContext.request.contextPath}/UploadQuestions" method="post"  class="bs-example bs-example-form" role="form">
		<div id="uploadType"  style="display: none;">
			<label ><input name="type" type="radio" onclick="display('Choice')" value="Choice"/>选择题</label>
			<label ><input name="type" type="radio" onclick="display('Completion')"  value="Completion"/>填空题</label>
		</div>

		<div id="OneChoice"  style="display: none;" >
			<label >题目:</label><br/>
			<div class="form-group">
			<label ><textarea name="choiceTitle" rows="3" cols="50"></textarea></label>
			</div>

			<div class="input-group">
			<span class="input-group-addon">A</span>
			<input name="OptionA" class="form-control" type="text"/>
			</div>
			<div class="input-group">
			<span class="input-group-addon">B</span>
			<input name="OptionB" class="form-control" type="text"/>
			</div>
			<div class="input-group">
			<span class="input-group-addon">C</span>
			<input name="OptionC" class="form-control" type="text"/>
			</div>
			<div class="input-group">
			<span class="input-group-addon">D</span>
			<input name="OptionD" class="form-control" type="text"/>
			</div>

			<label >答案:</label>
			<label >
			<select class="selectpicker" name="answer">
			<option value ="A">选项A</option>
			<option value ="B">选项B</option>
			<option value ="C">选项C</option>
			<option value ="D">选项D</option>
			</select>
			</label>
			<br/>
		</div>
		<div id="OneCompletion" class="form-group" style="display:none;">
			<label >题目:</label><br/>
			<div class="form-group">
			<label ><textarea name="completionTitle" rows="3" cols="50"></textarea></label>
			</div>

			<div class="input-group">
			<span class="input-group-addon">答案:</span>
			<input name="answerText" class="form-control" type="text"/>
			</div>
		</div>
		<div class="form-group" id="oneSubmit" style="display:none;">
			<button type="submit" class="btn btn-default">导入题库</button>
		</div>
	</form>
	</div>
	
	<div id="styleAll" style="display:none;">
	
		<%--<!--批量导入试题form  -->--%>
		<%--<form id="allForm" action="${pageContext.request.contextPath}/UploadFileQuestions" role="form" method="post" enctype="multipart/form-data" >--%>
		<%--<div>--%>
			<%--<label><input name="type1" type="radio"  value="Choice" checked="checked" />选择题</label>--%>
			<%--<label><input name="type1" type="radio"  value="Completion"/>填空题</label>--%>
		<%--</div>--%>
		<%--<div class="form-group" >--%>
		    <%--<label for="inputfile">文件输入</label>--%>
		    <%--<input type="file" id="inputfile" name="fileName">--%>
    		<%--<p class="help-block">1.请先选择上传选择题还是填空题，上传文件为txt类型；<br/>--%>
    								<%--2.选择题文件格式：<br/>&nbsp;题目占一行，4个选项占下一行（选项间以两个空格以上分隔），依此类推输入所有题目；--%>
    											<%--<br/>&nbsp;结尾一行输入“答案”（没有双引号）然后换行，然后依题目顺序输出一行答案选项（空格分隔）；--%>
    											<%--<br/>&nbsp;文件不得出现空行；<br/>--%>
    								<%--3.填空题文件格式：<br/>&nbsp;题目占一行，答案占下一行，依此类推输入所有题目；--%>
    												<%--<br/>&nbsp;文件不得出现空行。<br/>--%>
    								<%--4.文件上传路径为D盘根目录</p>--%>
		<%--</div>--%>
		  <%--<button type="submit" class="btn btn-default">提交</button>--%>
		<%--</form>--%>
	</div>
	
</div>
</body>
</html>