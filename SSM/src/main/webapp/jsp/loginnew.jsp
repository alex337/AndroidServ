<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>课堂教学管理系统</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
    <%--<script src="https://cdn.bootcss.com/jquery.form/4.2.1/jquery.form.js"></script>--%>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#loginform1").ajaxForm(function (data) {
                alert(data);
                if (-1 < data.indexOf("right")) {
                    window.location.href = "userzhuan.action";
                }
                else{
                    alert("用户名或密码错误！");
                }
                $("#loginform1").resetForm();
            })
        })


        function loginpass(){
//                    alert("触发事件成功");
//                 alert($("input[name='list']:checked").val());
            if($("input[name='list']:checked").val()=="学生") {
//                        alert($("input[name='list']:checked").val());
                $.ajax({
                    data: {userid: $("#userid").val(), password: $("#password").val()},
                    type: "post",
                    dataType: "json",
                    url: "${pageContext.request.contextPath}/student/stulogin",
                    error: function (data) {
                        alert('动态页出错\n\n'+data.responseText);

                    },
                    success: function (data) {
                        /!*alert(data["msg"]);*!///返回的data是一个map,所以data["msg"]是对象的值
                        var msg1 = data["msg"];
                        /!*alert(msg1);*!/
                        if (msg1 == "wrong") {
                            /!*alert(msg1);*!/
                            alert("用户名或密码错误");
                            $("#loginform1").resetForm();

                        }
                        else {
                            top.location.href = "jsp/student.jsp"
                        }
                    }
                });
            }
            else if($("input[name='list']:checked").val()=="教师")
            {
                $.ajax({
                    data: {userid: $("#userid").val(), password: $("#password").val()},
                    type: "post",
                    dataType: "json",
                    url: "${pageContext.request.contextPath}/teacher/teacherlogin",
                    error: function (data) {
                        alert('动态页出错\n\n'+data.responseText);
                    },
                    success: function (data) {
                        /!*alert(data["msg"]);*!///返回的data是一个map,所以data["msg"]是对象的值
                        var msg1 = data["msg"];
                        /!*alert(msg1);*!/
                        if (msg1 == "wrong") {
                            /!*alert(msg1);*!/
                            alert("用户名或密码错误");

                        }
                        else {
                            top.location.href = "jsp/teacher.jsp"
                        }
                    }
                });
            }
            else
            {
                $.ajax({
                    data: {userid: $("#userid").val(), password: $("#password").val()},
                    type: "post",
                    dataType: "json",
                    url: "${pageContext.request.contextPath}/admin/adminlogin",
                    error: function (data) {
                        alert('动态页出错\n\n'+data.responseText);
                    },
                    success: function (data) {
                        /!*alert(data["msg"]);*!///返回的data是一个map,所以data["msg"]是对象的值
                        var msg1 = data["msg"];
                        /!*alert(msg1);*!/
                        if (msg1 == "wrong") {
                            /!*alert(msg1);*!/
                            alert("用户名或密码错误");

                        }
                        else {
                            top.location.href = "jsp/admin.jsp"
                        }
                    }
                });
            }
        }

    </script>
</head>

<body>
<h1>课堂教学管理系统</h1>
<div class="container w3">
    <h2>现在登录</h2>
    <form  method="post" id="loginform1">
        <div class="username">
            <span class="username" style="height:19px">用户:</span>
            <input type="text" class="name" id="userid" name="userid" for="reservation" placeholder="学号/工号">
            <div class="clear"></div>
        </div>
        <div class="password-agileits">
            <span class="username"style="height:19px">密码:</span>
            <input type="password" class="password" id="password" name="password" for="reservation" placeholder="密码">
            <div class="clear"></div>
        </div>
        <div class="rem-for-agile">
            <input type="radio" name="list" value="教师" class="remember">教师
            <input type="radio" name="list" value="学生" class="remember">学生
            <input type="radio" name="list" value="管理员" class="remember">管理员　　　
            <br>
        </div>
        <div class="login-w3">
            <input type="submit" class="login" onclick=" loginpass()" value="立即登录"/>
        </div>
        <div class="clear"></div>
    </form>
</div>
<div class="footer-w3l">
    <p> 课堂教学管理系统</p>
</div>



<%--<div class="header">--%>
    <%--<div class="inner_c">--%>
        <%--<div class="header_left">Design By Heart</div>--%>
        <%--<div class="header_right">--%>
            <%--<div class="hri_left">--%>
                <%--<ul>--%>
                    <%--<li>登录&nbsp;&nbsp;&nbsp;&nbsp;|</li>--%>
                    <%--<li>注册&nbsp;&nbsp;&nbsp;&nbsp;|</li>--%>
                    <%--<li>公司合作&nbsp;&nbsp;|</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
            <%--<div class="hri_right">咨询热线：XXXX-XXXX-XXX</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<%--<div class="body_top">--%>
    <%--<div class="inner_body">--%>
        <%--<p><img src="images/flower.jpg"/></p>--%>
        <%--<p class="p_id1">Welcome</p>--%>
    <%--</div>--%>
<%--</div>--%>
<%--<div class="body_center">--%>
    <%--<div class="inner_body2">--%>
        <%--<div class="bc_left">--%>
            <%--<img src="images/jiaju1.jpg">--%>
        <%--</div>--%>
        <%--<div class="bc_right">--%>
            <%--<p></p>--%>
            <%--<form  method="post" id="loginform1">--%>
                <%--<input type="text" class="name_input" id="username" name="username" for="reservation" placeholder="学号/工号">--%>
                <%--<input type="password" class="pass_input" id="password" name="password" for="reservation" placeholder="密码">--%>
                <%--<input type="button" class="p_login" onclick="loginpass()" value="立即登录"/>--%>
                <%--<p class="p_login">立即登录</p>--%>
                <%--<span class="pay_list_c1 on">--%>
                    <%--<input type="radio" name="list" value="教师" class="radioclass">教师--%>
                    <%--<input type="radio" name="list" value="学生" class="radioclass">学生--%>
                <%--</span>--%>
            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<%--<div class="bottom">--%>
    <%--<div class="inner_bottom">--%>
        <%--<div class="bottom1">--%>
            <%--<p class="p_l">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Copyright &copy;--%>
                <%--2004-2014&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;课堂教学管理系统（Decorating &nbsp;&nbsp;Houses）--%>
                <%--&nbsp;&nbsp;&nbsp;&nbsp;ICPXX--%>
                <%--备XXXXXXXX号 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
                <%--增值电信业务经营许可证：&nbsp;&nbsp;XXXXXXXXXXX</p>--%>
            <%--<p class="p_r"><img src="../images/govIcon.gif" alt=""></p>--%>
            <%--<!--<p>免责声明：本网站设计用于理论学习</p>-->--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
</body>
</html>