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
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css">
</head>
<body>
<h2 align="center">发布作业</h2>


    <div class="body-content">
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/work/addwork">
            <div class="form-group">
                <div class="label">
                    <label>作业标题：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="title" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>作业内容：</label>
                </div>
                <div class="field">
                    <textarea name="remark" class="input" style="height:450px; border:1px solid #ddd;"></textarea>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>选择学期：</label>
                </div>
                <div class="field">
                    <select class="input w50" name="term">
                        <option value="">请选择学期</option>
                        <option value="2017-2018-1">2017-2018-1</option>
                        <option value="2017-2018-2">2017-2018-2</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>选择学科：</label>
                </div>
                <div class="field">
                    <select id="lunch1" name="sub" class="input w50" data-live-search="true"  >
                        <option value="">请选择学科</option>
                        <c:forEach items="${courselist}" var="coursename">
                            <option value="${coursename }">${coursename}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>选择班级：</label>
                </div>
                <div class="field">
                    <select id="lunch" name="queryCondition" class="input w50" data-live-search="true"  >
                        <option value="">请选择班级</option>
                        <c:forEach items="${classlist}" var="stuClass">
                            <option value="${stuClass }">${stuClass}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="field">
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 发布</button>
                </div>
            </div>

        </form>
    </div>




</body>
</html>
