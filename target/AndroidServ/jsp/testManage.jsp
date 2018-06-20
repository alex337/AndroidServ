<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试题管理</title>

<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
#main{
	text-align: center;
	width:1000px;
    height: 400px;
    margin:0 auto;
    padding: 0;
    border: 0;
}
#button_submit{
	width: 80px;
	font-size: 15px;
	vertical-align:middle;
	-moz-border-radius: 3px;
	-webkit-border-radius:3px;
	border-radius: 2px; 
	border: 1px solid #c9c9c9 ;
}
table{
　　table-layout: fixed;
}

td{
　　white-space: nowrap;
　　overflow: hidden;
　　text-overflow: ellipsis;
	word-wrap:break-word;
	text-align:center;
}
.form-control{
	margin: 0;
	padding: 5px;
}
.abtn{
	-webkit-appearance: button;
    -moz-appearance: button;
    appearance: button;

    text-decoration: none;
    color: initial;
}
</style>
<script type="text/javascript">
function editTest(obj) {
	var td0=$(obj).parent().parent().find('td')[0];
	var id=$(td0).text();
	var td1=$(obj).parent().parent().find('td')[1];
	var title=$(td1).text();
	var td2=$(obj).parent().parent().find('td')[2];
	var A=$(td2).text();
	var td3=$(obj).parent().parent().find('td')[3];
	var B=$(td3).text();
	var td4=$(obj).parent().parent().find('td')[4];
	var C=$(td4).text();
	var td5=$(obj).parent().parent().find('td')[5];
	var D=$(td5).text();
	var td6=$(obj).parent().parent().find('td')[6];
	var answer=$(td6).text();
	
	$("#testID1").val(id);
	$("#testID2").val(id);
	$("#Title1").val(title);
	$("#Title2").val(title);
	$("#OptionA").val(A);
	
	$("#OptionB").val(B);
	$("#OptionC").val(C);
	$("#OptionD").val(D);	
	$("#answer2").val(A);
	$("#answer").find("option[value="+answer+"]").prop("selected",true);

	
	
}

function checkDelete() {
	var gnl=confirm("确定要删除?");  
	if (gnl==true){
		return true;
	}else{

		return false;
	}
}
</script>

<%
String type=(String)request.getAttribute("type");
String key=(String)request.getAttribute("key");
String Page = "1";
if (request.getAttribute("page") != null)
	Page=request.getAttribute("page").toString();
%>

</head>
<body>
<div id="main">
	<div>
		<form action="${pageContext.request.contextPath}/TestManage?page=1" method="post"> 						<!--搜索三个值：page type key  -->
		<label><input name="type" type="radio"   value="Choice" <%if(type!=null&&type.equals("Choice")) out.print("checked='checked'"); %>/>选择题</label>
		<label>关键字:<input name="key" type="text" <%if(key!=null) out.print("value='"+key+"'");else out.print("value=''");%> /></label>
		<button id="button_submit" type="submit" >搜索</button>
		</form>
	</div>
	
									<!-- 1.构造选择题表格 -->
									
	<!-- <table style="table-layout:fixed" class="table table-hover table-bordered">
		<caption>选择题</caption>
		<thead>
			<tr> 					table表头 
				<th>试题ID</th>
				<th>题目</th>
				<th>选项A</th>
				<th>选项B</th>
				<th>选项C</th>
				<th>选项D</th>
				<th>答案</th>
				<th>操作</th>
			</tr>
		</thead> -->
		<%
			StringBuffer table=(StringBuffer)request.getAttribute("Table");
			if(table==null){
				response.sendRedirect("../TestManage?page=1&type=Choice&key=");
			}else{
				out.print(table.toString());
			}
		%>
			<!-- <tr>
				<td>1</td>
				<td>这是题目XXXXXXXXXXXXXXXXXXXXXXXXXXXX</td>
				<td>这是选项AXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</td>
				<td>这是选项BXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</td>
				<td>这是选项CXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</td>
				<td>这是选项DXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</td>
				<td>A</td>
				<td><button class="btn btn-primary" data-toggle="modal" data-target="#myModal1" onclick="editTest(this)">修改</button><br/>
					<form action="deleteServlet?type=&id=xx&page=&key=" onsubmit="return checkDelete()">
				    <button class="btn btn-primary" type="submit">删除</button></form></td>
			</tr>
		
	</table>
	<div>
		<span>共5页12题</span>&nbsp;&nbsp;
		<label><a href="selectServlet?page=1&type=XX&key=XX" class="abtn">首页</a></label>&nbsp;
		<label><a href="selectServlet?page=LAST&type=XX&key=XX" class="abtn">上一页</a></label>&nbsp;
		<label><a href="selectServlet?page=NEXT&type=XX&key=XX" class="abtn">下一页</a></label>&nbsp;
		<label><a href="selectServlet?page=x&type=XX&key=XX" class="abtn">尾页</a></label>&nbsp;&nbsp;
		<span>当前第X页</span> -->
		
					<!-- x=最后一页 LAST=page-1 NEXT=page+1 填数字
										 type=和key=后面为字符串	
										
		例：
										
		tb.append("共"+pageNum+"条记录&nbsp;共"+((pageNum-1)/2+1)+"页&nbsp;");
		if(page-1>0){
			tb.append("<a href=\"/UpDown2/downloadservlet?page="+(page-1)+"&type="+type+"\">上一页</a>&nbsp;");
			tb.append("<a href=\"/UpDown2/downloadservlet?page="+(page-1)+"&type="+type+"\">"+(page-1)+"</a>&nbsp;");
		}
		tb.append(page+"&nbsp;");
		if(page+1<=((pageNum-1)/2+1)){
			tb.append("<a href=\"/UpDown2/downloadservlet?page="+(page+1)+"&type="+type+"\">"+(page+1)+"</a>&nbsp;");
			tb.append("<a href=\"/UpDown2/downloadservlet?page="+(page+1)+"&type="+type+"\">下一页</a>&nbsp;");
		}
		tb.append("当前第"+page+"页<br/>");
										 
					
	</div>  -->
	
	
									<!-- 2.构造填空题表格 -->
	<!-- <table class="table table-hover table-bordered">
		<caption>填空题</caption>
		<thead>
			<tr> 					
				<th>试题ID</th>
				<th>题目</th>
				<th>答案</th>
				<th>操作</th>
			</tr>
		</thead>
			 <tr>
				<td>1</td>
				<td>这是题目</td>
				<td>这是答案</td>
				<td><button class="btn btn-primary" data-toggle="modal" data-target="#myModal2" onclick="editTest(this)">修改</button><br/>
					<form action="deleteServlet?type=&id=xx&page=&key=" onsubmit="return checkDelete()">
				    <button class="btn btn-primary" type="submit">删除</button></form></td>
			</tr>
		
	</table>
	<div>
		<span>共5页12题</span>&nbsp;&nbsp;
		<label><a href="selectServlet?page=1&type=XX&key=XX" class="abtn">首页</a></label>&nbsp;
		<label><a href="selectServlet?page=LAST&type=XX&key=XX" class="abtn">上一页</a></label>&nbsp;
		<label><a href="selectServlet?page=NEXT&type=XX&key=XX" class="abtn">下一页</a></label>&nbsp;
		<label><a href="selectServlet?page=x&type=XX&key=XX" class="abtn">尾页</a></label>&nbsp;&nbsp;
		<span>当前第X页</span>
		
	</div>
</div> -->

 
        <div class="modal fade" id="myModal1"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <!--  定义模态框，过渡效果为淡入，id为myModal,tabindex=-1可以禁用使用tab切换，aria-labelledby用于引用模态框的标题，aria-hidden=true保持模态框在触发前窗口不可见  -->
            <div class="modal-dialog" style="width:600px">
                <!--  显示模态框对话框模型（若不写下一个div则没有颜色）  -->
                <div class="modal-content">
                    <!--  显示模态框白色背景，所有内容都写在这个div里面  -->

                    <div class="modal-header">
                        <!--  模态框标题  -->
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <!--  关闭按钮  -->
                        <h4>修改试题</h4>
                        <!--  标题内容  -->
                    </div>

                    <div class="modal-body">
                        <!--  模态框内容，我在此处添加一个表单 -->
                        <form   action="./UpdateServlet?page=<%=Page%>&key=<%=key%>" method="post" class="form-horizontal" role="form">
                        
                        <input name="testID" id="testID1" type="hidden" value=""/>
                        <input name="type" type="hidden" value="Choice"/>
                        
                            <div class="form-group">
                                <label for="Title1" class="col-sm-2 control-label">题目</label>
                                <div class="col-sm-9">
                               		<textarea name="Title" id="Title1" rows="2" cols="60" class="form-control well" ></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="OptionA" class="col-sm-2 control-label">选项A</label>
                                <div class="col-sm-9">
                                    <textarea name="OptionA"  id="OptionA"  rows="1" cols="60" class="form-control well" ></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="OptionB" class="col-sm-2 control-label">选项B</label>
                                <div class="col-sm-9">
                                    <textarea name="OptionB" id="OptionB"  rows="1" cols="60" class="form-control well" ></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="OptionC" class="col-sm-2 control-label">选项C</label>
                                <div class="col-sm-9">
                                    <textarea name="OptionC"  id="OptionC"  rows="1" cols="60" class="form-control well" ></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="OptionD" class="col-sm-2 control-label">选项D</label>
                                <div class="col-sm-9">
                                    <textarea name="OptionD" id="OptionD" rows="1" cols="60" class="form-control well" ></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="answer" class="col-sm-2 control-label">答案</label>
                                <div class="col-sm-9">
                                    <select class="form-control" name="answer" id="answer">
									<option value ="A">选项A</option>
									<option value ="B">选项B</option>
									<option value ="C">选项C</option>
									<option value ="D">选项D</option>
									</select>
                                </div>
                            </div>
                        
                    </div>

                    <div class="modal-footer">
                        <!--  模态框底部样式，一般是提交或者确定按钮 -->
                        <button type="submit" class="btn btn-success">确定</button>
                        <button type="button" class="btn " data-dismiss="modal">取消</button>
                    </div>
				</form>
                </div><!-- /.modal-content -->
            </div>
        </div> <!-- /.modal -->
        
        <div class="modal fade" id="myModal2"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <!--  定义模态框，过渡效果为淡入，id为myModal,tabindex=-1可以禁用使用tab切换，aria-labelledby用于引用模态框的标题，aria-hidden=true保持模态框在触发前窗口不可见  -->
            <div class="modal-dialog" style="width:600px">
                <!--  显示模态框对话框模型（若不写下一个div则没有颜色）  -->
                <div class="modal-content">
                    <!--  显示模态框白色背景，所有内容都写在这个div里面  -->

                    <div class="modal-header">
                        <!--  模态框标题  -->
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <!--  关闭按钮  -->
                        <h4>修改试题:填空题</h4>
                        <!--  标题内容  -->
                    </div>

                    <div class="modal-body">
                        <!--  模态框内容，我在此处添加一个表单 -->
                        <form   action="./UpdateServlet?page=<%=Page%>&key=<%=key%>" method="post" class="form-horizontal" role="form">
                        
                        <input name="testID" id="testID2" type="hidden" value=""/>
                        <input name="type" type="hidden" value="Completion"/>
                        
                            <div class="form-group">
                                <label for="Title2" class="col-sm-2 control-label">题目</label>
                                <div class="col-sm-9">
                               		<textarea name="Title" id="Title2" rows="2" cols="60" class="form-control well" ></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="answer2" class="col-sm-2 control-label">答案</label>
                                <div class="col-sm-9">
                                    <textarea name="answer"  id="answer2"  rows="1" cols="60" class="form-control well" ></textarea>
                                </div>
                            </div>
                        
                    </div>

                    <div class="modal-footer">
                        <!--  模态框底部样式，一般是提交或者确定按钮 -->
                        <button type="submit" class="btn btn-success">确定</button>
                        <button type="button" class="btn " data-dismiss="modal">取消</button>
                    </div>
				</form>
                </div><!-- /.modal-content -->
            </div>
        </div> <!-- /.modal -->

</body>
</html>