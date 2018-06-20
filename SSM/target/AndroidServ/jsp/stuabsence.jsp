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
<h1 align="center">学生缺勤情况</h1>
<table>
    <tr>
        <th width="250">姓名</th>
        <th width="250">学号</th>
        <th width="250">缺勤次数</th>
    </tr>
    <c:forEach items="${stulist}" var="student" varStatus="status">
        <tr
                <c:if test="${status.count%2!=0}">
                    style="background-color:#dbce8f"
                </c:if>
                <c:if test="${status.count%2==0}"> style="background-color:grey"</c:if>>
            <th width="350">${student.stuName}</th>
            <th width="350">${student.stuID}</th>
            <th width="350">${student.stuAbsence}</th>
        </tr>
    </c:forEach>
</table>
<br /> <br />
<table>
<tr>
    <a href="jsp/stusearch.jsp" class="button">返回</a>
</tr>
</table>
</body>
</html>