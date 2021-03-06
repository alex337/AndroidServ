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
    <link rel="stylesheet" href="css/layui.css"  media="all">
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
        <h1 align="center">学生信息</h1>
    </div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <div class="widget-box">
                    <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
                    </div>
                    <div class="widget-content nopadding">
                        <table class="table table-bordered data-table" id="myTable">
                            <thead>
                            <tr>
                                <th>学号</th>
                                <th>姓名</th>
                                <th>班级</th>
                                <th>操作</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="student" items="${stulist}">
                                <tr class="gradeX">
                                    <td>${student.stuID}</td>
                                    <td>${student.stuName}</td>
                                    <td>${student.stuClass}</td>
                                    <td><button style="color: #5eb95e"  onclick="stucall(this)">
                                        未到
                                    </button></td>
                                    <td><button style="color: #5eb95e"  onclick="stucall2(this)">
                                        已到
                                    </button></td>
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
<script type="text/javascript">
    var req2;
    function stucall(curB) {
        //获取当前按钮是第几行
        var curRow = curB.parentNode.parentNode.rowIndex;
        //获取表名
        var tab = document.getElementById("myTable");
        //获取当前行第2列里的值，也就是学号
        var text = tab.rows[curRow].cells[0].innerHTML;
        // 访问stucall4这个servlet同时把获取的表单内容text加入url字符串，以便传递给stucall4
        var url = "${pageContext.request.contextPath}/student/stucall3?id=" + text;
        alert("确定该同学未到？");
        // 创建一个XMLHttpRequest对象req
        if (window.XMLHttpRequest) {
            req2 = new XMLHttpRequest();// IE7, Firefox, Opera支持
        } else if (window.ActiveXObject) {
            req2 = new ActiveXObject("Microsoft.XMLHTTP");// IE5,IE6支持
        }
        req2.open("get", url, true);
        req2.onreadystatechange = callback;
        // send函数发送请求
        req2.send(null);
    }
    function stucall2(curB) {
        //获取当前按钮是第几行
        var curRow = curB.parentNode.parentNode.rowIndex;
        //获取表名
        var tab = document.getElementById("myTable");
        //获取当前行第2列里的值，也就是学号
        var text = tab.rows[curRow].cells[0].innerHTML;
        // 访问stucall4这个servlet同时把获取的表单内容text加入url字符串，以便传递给stucall4
        var url = "${pageContext.request.contextPath}/student/stucall4?id=" + text;
        alert("确定该同学已到");
        // 创建一个XMLHttpRequest对象req
        if (window.XMLHttpRequest) {
            req2 = new XMLHttpRequest();// IE7, Firefox, Opera支持
        } else if (window.ActiveXObject) {
            req2 = new ActiveXObject("Microsoft.XMLHTTP");// IE5,IE6支持
        }
        req2.open("get", url, true);
        req2.onreadystatechange = callback;
        // send函数发送请求
        req2.send(null);
    }
    function callback() {
        if (req2.readyState == 4 && req2.status == 200) {
            return "OK";
        }
    }
</script>




<%--<div id="content">--%>
    <%--<div id="content-header">--%>
        <%--<h1 align="center">学生信息</h1>--%>
    <%--</div>--%>
    <%--<div class="container-fluid">--%>
        <%--<div class="row-fluid">--%>
            <%--<div class="span12">--%>
                <%--<div class="widget-box">--%>
                    <%--<div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>--%>
                    <%--</div>--%>
                    <%--<div class="widget-content nopadding">--%>
                        <%--<table class="table table-bordered data-table">--%>
                            <%--<thead>--%>
                            <%--<tr>--%>
                                <%--<th>学号</th>--%>
                                <%--<th>姓名</th>--%>
                                <%--<th>班级</th>--%>
                                <%--<th>操作</th>--%>
                                <%--<th>操作</th>--%>
                            <%--</tr>--%>
                            <%--</thead>--%>
                            <%--<tbody>--%>
                            <%--<c:forEach var="student" items="${stulist}">--%>
                                <%--<tr class="gradeX">--%>
                                    <%--<td>${student.stuID}</td>--%>
                                    <%--<td>${student.stuName}</td>--%>
                                    <%--<td>${student.stuClass}</td>--%>
                                    <%--<td><a style="color: #5eb95e" href="${pageContext.request.contextPath}/student/stucall3?id=${student.stuID}">--%>
                                        <%--未到--%>
                                    <%--</a></td>--%>
                                    <%--<td><a style="color: #5eb95e" href="${pageContext.request.contextPath}/student/stucall4?id=${student.stuID}">--%>
                                        <%--已到--%>
                                    <%--</a></td>--%>
                                <%--</tr>--%>
                            <%--</c:forEach>--%>
                            <%--</tbody>--%>
                        <%--</table>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.uniform.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/matrix.js"></script>
<script src="js/matrix.tables.js"></script>
</body>
</html>
