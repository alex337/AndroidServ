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
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="css/uniform.css" />
    <link rel="stylesheet" href="css/select2.css" />
    <link rel="stylesheet" href="css/matrix-style2.css" />
    <link rel="stylesheet" href="css/matrix-media.css" />
    <link href="css/font-awesome.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>
<div id="content">
    <div id="content-header">
        <h1 align="center">下载作业</h1>
    </div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <div class="widget-box">
                    <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
                    </div>
                    <div class="widget-content nopadding">
                        <table class="table table-bordered data-table">
                            <thead>
                            <tr>
                                <th>学科</th>
                                <th>标题</th>
                                <th>上传日期</th>
                                <th>布置教师</th>
                                <th>作业内容</th>
                                <th>提交</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="work" items="${worklist}">
                                <tr class="gradeX">
                                    <td>${work.coursename}</td>
                                    <td>${work.wName}</td>
                                    <td><spring:eval expression="work.date"></spring:eval></td>
                                    <td>${work.upuser}</td>
                                    <td><a style="color: #5eb95e" href="javascript:void(0)" id="show" onclick="show(this)" remark="${work.remark}">
                                        查看详情
                                    </a></td>
                                    <td><a style="color: #5eb95e" href="${pageContext.request.contextPath}/jsp/stuupwork.jsp?file=${work.filename}&wname=${work.wName}&coursename=${work.coursename}&term=${work.term}">
                                        提交
                                    </a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.uniform.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/matrix.js"></script>
<script src="js/matrix.tables.js"></script>
<script src="js/jquery-1.8.0.min.js"></script>
<script langue="javascript">

    function show(obj)
    {
        var thisObj=$(obj);
        var remark=thisObj.attr("remark");
        alert(remark);
    }

</script>


</body>
</html>
