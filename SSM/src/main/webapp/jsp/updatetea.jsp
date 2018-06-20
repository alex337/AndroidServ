<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>
<div class="row clearfix">
    <div class="col-md-12 column">
        <div class="page-header">
            <h2 align="center">
                教师修改
            </h2>
        </div>
    </div>
</div>
<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/teacher/updatetea" method="post">
    <div class="form-group">
        <label for="firstname" class="col-sm-5 control-label">工号</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="firstname" name="teaid">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname" class="col-sm-5 control-label">职称</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="lastname" name="teatitle"
                   value="">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname3" class="col-sm-5 control-label">院系</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="lastname3" name="teadep"
                   value="">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname4" class="col-sm-5 control-label">课程</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="lastname4" name="teacou"
                   value="">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname1" class="col-sm-5 control-label">密码</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="lastname1" name="password" placeholder="请输入用户密码">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-5 col-sm-10">
            <button type="submit" class="btn btn-default">修改</button>
            <button type="reset" class="btn btn-default">取消</button>
        </div>
    </div>
    <input type="text" class="form-control" id="lastname2" name="teaname"
           placeholder="" style="visibility:hidden">
</form>

<script type="text/javascript">
    var teaid="<%=request.getParameter("teaid")%>";
    var teatitle="<%=request.getParameter("teatitle")%>";
    var teadep="<%=request.getParameter("teadep")%>";
    var teacou="<%=request.getParameter("teacou")%>";
    var password="<%=request.getParameter("password")%>";
    var teaname="<%=request.getParameter("teaname")%>";
    document.getElementById("firstname").value =teaid;
    document.getElementById("lastname").value = teatitle;
    document.getElementById("lastname1").value = password;
    document.getElementById("lastname2").value = teaname;
    document.getElementById("lastname3").value = teadep;
    document.getElementById("lastname4").value = teacou;
</script>
</body>
</html>