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
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
    <table class="table table-hover text-center">
        <tr>
            <th width="5%">学生</th>
            <th>学号</th>
            <th>作业标题</th>
            <th>学科</th>
            <th width="250">操作</th>
        </tr>
        <tr>
            <td><%=request.getParameter("stuname")%></td>
            <td><%=request.getParameter("stuid")%></td>
            <td><%=request.getParameter("filename")%></td>
            <td><%=request.getParameter("coursename")%></td>
            <td>
                <div class="button-group">
                    <a type="button" class="button border-main" href="${pageContext.request.contextPath}/stuwork/stuworkdownload?filename=<%=request.getParameter("filename")%>"><span class="icon-edit"></span>下载</a>
                </div>
            </td>
        </tr>
    </table>
</div>

<div class="panel admin-panel margin-top">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span></strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/stuwork/assstuwork">
            <input type="hidden" name="id"  value="" />
            <div class="form-group">
                <div class="label">
                    <label>评语：</label>
                </div>
                <div class="field">
                    <textarea type="text" class="input" name="assess" style="height:100px;" ></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>分数：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="score" value="" />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>是否打回：</label>
                </div>
                <div class="field">
                    <div class="button-group radio">

                        <label class="button active">
                            <span class="icon icon-check"></span>
                            <input name="isshow" value="1" type="radio" checked="checked">是
                        </label>

                        <label class="button active"><span class="icon icon-times"></span>
                            <input name="isshow" value="0"  type="radio" checked="checked">否
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    var stuid="<%=request.getParameter("stuid")%>";
    var stuname="<%=request.getParameter("stuname")%>";
    var filename="<%=request.getParameter("filename")%>";
    var wName="<%=request.getParameter("wName")%>";
    var coursename="<%=request.getParameter("coursename")%>";
    var term="<%=request.getParameter("term")%>";
</script>
<%
    session.setAttribute("stuid",request.getParameter("stuid"));
    session.setAttribute("stuname",request.getParameter("stuname"));
    session.setAttribute("filename",request.getParameter("filename"));
    session.setAttribute("wName",request.getParameter("wName"));
    session.setAttribute("coursename",request.getParameter("coursename"));
    session.setAttribute("term",request.getParameter("term"));
%>
</body>
</html>
