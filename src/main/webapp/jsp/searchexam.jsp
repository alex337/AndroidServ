<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>layui</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="css/pintuer.css">
    <link rel="stylesheet" type="text/css" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <%--selectbyclass--%>
</head>
<body>
<div class="panel admin-panel margin-top">
    <div class="body-content">
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/student/selectstudent" method="get">
            <div class="form-group">
                <div class="label">
                    <label>选择考试科目：</label>
                </div>
                <div class="field">
                    <select class="input w50" name="term" onchange="window.location=this.value;">
                        <option value="">请选择考试科目</option>
                        <option value="jsp/stuMenu.jsp">java</option>
                        <option value="xml">xml</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 搜索试卷</button>
                </div>
            </div>
        </form>
    </div>
</div>

<%--<div class="container-fluid">--%>
    <%--<div class="row-fluid">--%>
        <%--<div class="span2">--%>
        <%--</div>--%>
        <%--<div class="span6">--%>
            <%--<form class="form-search" action="${pageContext.request.contextPath}/student/selectbyclass" method="get">--%>
                <%--<input class="input-medium search-query" type="text" name="queryCondition"/>--%>
                <%--<label class="layui-form-label">日期</label>--%>
                <%--<input type="text" class="layui-input" id="test1" >--%>
                <%--<button type="submit" class="btn">查找</button>--%>
            <%--</form>--%>
        <%--</div>--%>
        <%--<div class="span4">--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<script src="laydate/laydate.js"></script> <!-- 改成你的路径 -->
<script>
    //执行一个laydate实例
    laydate.render({
        elem: '#test1',
        format: 'yyyy年MM月dd日 '
    });
</script>

</body>
</html>
