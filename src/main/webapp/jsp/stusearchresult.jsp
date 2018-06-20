<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/4/25
  Time: 18:23
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
    <style type="text/css">
        a.button {
    -webkit-appearance: button;
    -moz-appearance: button;
    appearance: button;

    text-decoration: none;
    color: initial;
    }
    </style>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>
<h1 align="center">学生名单</h1>
<table>
<tr>
    <th width="250">班级</th>
    <th>姓名</th>
    <th width="250">学号</th>
    <th width="250">点名</th>

</tr>
<c:forEach items="${stulist}" var="student" varStatus="status">
    <tr
            <c:if test="${status.count%2!=0}">
                style="background-color:#dbce8f"
            </c:if>
            <c:if test="${status.count%2==0}"> style="background-color:grey"</c:if>>
        <th width="5%">${student.stuClass}</th>
        <th>${student.stuName}</th>
        <th width="250">${student.stuID}</th>
        <td><a style="color: #5eb95e" href="${pageContext.request.contextPath}/student/stucall?id=${student.stuID}">
            未到
        </a></td>
        <td><a style="color: #5eb95e" href="${pageContext.request.contextPath}/student/stucall2?id=${student.stuID}">
            已到
        </a></td>
    </tr>
</c:forEach>
</table>
<br /> <br /> <label>第${page.currentPage}/${page.totalPage}页
    共${page.totalRows}条</label> <a href="${pageContext.request.contextPath}/student/selectbyclass?currentPage=0">首页</a> <a
        href="${pageContext.request.contextPath}/student/selectbyclass?currentPage=${page.currentPage-1}"
        onclick="return checkFirst()">上一页</a> <a
        href="${pageContext.request.contextPath}/student/selectbyclass?currentPage=${page.currentPage+1}"
        onclick="return checkNext()">下一页</a> <a
        href="${pageContext.request.contextPath}/student/selectbyclass?currentPage=${page.totalPage}">尾页</a>
</center>
<br /> <br />
<table>
<tr>
    <a href="${pageContext.request.contextPath}/student/searchabsence" class="button">查看缺勤</a>
    <a href="jsp/stusearch.jsp" class="button">返回</a>

</tr>
</table>

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

        var shref="${pageContext.request.contextPath}/student/selectbyclass?currentPage="+turnPage;

        window.location.href=shref;
    }
</script>

</body>
</html>
