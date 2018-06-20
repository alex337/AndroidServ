<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/4/27
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="css/uniform.css" />
    <link rel="stylesheet" href="css/select2.css" />
    <link rel="stylesheet" href="css/matrix-style2.css" />
    <link rel="stylesheet" href="css/matrix-media.css" />
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

<table>
    <tr>
        <th>作业名</th>
        <th>上传日期</th>
        <th>上传学生</th>
        <th>学号</th>
        <th>↓下载↓</th>
    </tr>
    <c:forEach var="stuwork" items="${stuworklist}">
        <tr class="gradeX">
            <td>${stuwork.filename}</td>
            <td><spring:eval expression="stuwork.date"></spring:eval></td>
            <td>${stuwork.stuname}</td>
            <td>${stuwork.stuid}</td>
            <td><a style="color: #5eb95e" href="${pageContext.request.contextPath}/stuwork/stuworkdownload?filename=${work.filename}">
                下载
            </a></td>
        </tr>
    </c:forEach>
</table>
<br /> <br />
<label>第${page.currentPage}/${page.totalPage}页共${page.totalRows}条</label>
<a href="${pageContext.request.contextPath}/stuwork/showstuwork?currentPage=0">首页</a>
<a href="${pageContext.request.contextPath}/stuwork/showstuwork??currentPage=${page.currentPage-1}"
   onclick="return checkFirst()">上一页</a> <a
        href="${pageContext.request.contextPath}/stuwork/showstuwork??currentPage=${page.currentPage+1}"
        onclick="return checkNext()">下一页</a> <a
        href="${pageContext.request.contextPath}/stuwork/showstuwork??currentPage=${page.totalPage}">尾页</a> 跳转到:<input
        type="text" style="width:30px" id="turnPage" />页 <input
        type="button" onclick="startTurn()" value="跳转">
</center>

<script type="text/javascript">

    function checkFirst(){
        if(${page.currentPage>1}){

            return true;

        }
        alert("已到页首,无法加载更多");

        return false;
    }

    function checkNext(){

        if(${page.currentPage<page.totalPage}){

            return true;

        }
        alert("已到页尾，无法加载更多页");
        return false;

    }


    function startTurn(){

        var turnPage=document.getElementById("turnPage").value;

        if(turnPage>${page.totalPage}){

            alert("对不起已超过最大页数");

            return false;

        }

        var shref="${pageContext.request.contextPath}/stuwork/showstuwork?currentPage="+turnPage;

        window.location.href=shref;
    }
</script>

</body>
</html>