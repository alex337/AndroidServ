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
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css">
</head>
<body>
<h2 align="center">教案上传</h2>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="${pageContext.request.contextPath}/document/adddocument" enctype="multipart/form-data"  method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1">资料标题</label><input type="text" name="title" class="form-control"
                                                                       style="height: 35px"  id="exampleInputEmail1" />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">资料描述</label><input type="text" name="remark" class="form-control"
                                                                          style="height: 35px" id="exampleInputPassword1" />
                </div>
                <div class="form-group">
                    <label for="exampleInputFile"></label><input type="file" name="file" id="exampleInputFile" />
                </div>
                <div class="container-fluid" style="position: relative;left: -22px;">
                    <div class="row-fluid">
                        <div class="span12">
                            <input  type="submit" value="上传文件">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>