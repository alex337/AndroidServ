<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>学生端</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <link rel="stylesheet" type="text/css" href="css/pintuer.css">
    <link rel="stylesheet" type="text/css" href="css/admin.css">
    <script src="js/jquery.js" type="text/javascript"></script>


</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />学生端</h1>
    </div>
    <div class="head-l"><a class="button button-little bg-red" href="jsp/login.jsp"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>


</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-user"></span>个人中心</h2>
    <ul style="display:block">
        <li><a href="jsp/stuupdatepwd.jsp" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
        <li><a href="jsp/loginnew.jsp"><span class="icon-caret-right"></span>退出</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>在线考试</h2>
    <ul>
        <li><a href="jsp/searchexam.jsp" target="right"><span class="icon-caret-right"></span>选择考试</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>教案管理</h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/document/documentquery" target="right"><span class="icon-caret-right"></span>下载教案</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>作业管理</h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/work/workquery" target="right"><span class="icon-caret-right"></span>未交作业</a></li>
        <li><a href="${pageContext.request.contextPath}/stuwork/searchfinish" target="right"><span class="icon-caret-right"></span>已交作业</a></li>

    </ul>
    <h2><span class="icon-pencil-square-o"></span>出勤管理</h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/student/selectcour" target="right"><span class="icon-caret-right"></span>查询缺勤</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>在线聊天</h2>
    <ul>
        <li><a href="jsp/chat.jsp" target="right"><span class="icon-caret-right"></span>聊天</a></li>
    </ul>
</div>
<script type="text/javascript">
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<ul class="bread">
    <li><a href="welcome.jsp" target="right" class="icon-home"> 首页</a></li>
    <li><a href="jsp/information.jsp" id="a_leader_txt" target="right" class="icon-home">网站信息</a></li>
</ul>
<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="jsp/chat.jsp" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>