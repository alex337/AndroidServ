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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script type="text/javascript">


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
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">
            </div>
            <form  method="post" onsubmit="return false" action="##">
                <div class="panel loginbox">
                    <div class="text-center margin-big padding-big-top"><h1>课堂教学管理系统</h1></div>

                    <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input input-big" id="userid" name="userid" placeholder="登录账号" data-validate="required:请填写账号" />
                                <span class="icon icon-user margin-small"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input input-big" id="password" name="password" placeholder="登录密码" data-validate="required:请填写密码" />
                                <span class="icon icon-key margin-small"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="radio" name="list" value="教师" class="remember">教师
                                <input type="radio" name="list" value="学生" class="remember">学生
                                <input type="radio" name="list" value="管理员" class="remember">管理员
                            </div>
                        </div>
                    </div>
                    <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" onclick=" loginpass()" value="登录"></div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
