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
                教师添加
            </h2>
        </div>
    </div>
</div>
<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/teacher/addtea" method="post">
    <div class="form-group">
        <label for="firstname" class="col-sm-5 control-label">姓名</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="firstname" name="teacherName"
                   placeholder="请输入名字">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname" class="col-sm-5 control-label">工号</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="lastname" name="teacherID"
                   placeholder="请输入工号">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname1" class="col-sm-5 control-label">密码</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="lastname1" name="teacherPwd"
                   placeholder="请输入密码">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname2" class="col-sm-5 control-label">职称</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="lastname2" name="teacherTitle"
                   placeholder="请输入职称">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname3" class="col-sm-5 control-label">院系</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="lastname3" name="teacherDep"
                   placeholder="请输入院系">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname4" class="col-sm-5 control-label">课程</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="lastname4" name="teacherCou"
                   placeholder="请输入课程">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-5 col-sm-10">
            <button type="submit" class="btn btn-default">添加</button>
            <button type="reset" class="btn btn-default">取消</button>
        </div>
    </div>
</form>
</body>
</html>