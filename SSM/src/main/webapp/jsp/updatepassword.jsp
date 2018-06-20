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
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="css/pintuer.css">
    <link rel="stylesheet" type="text/css" href="css/admin.css">
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/pintuer.js" type="text/javascript"></script>

<%--ajax传值测试结果--%>
    <script type="text/javascript">
        function updatepass() {
//            alert("触发事件成功");
            if($("#password").val()!=$("#password2").val()){
                alert("两次密码输入不等，请重新输入");
                document.getElementById("password").value="";
                document.getElementById("password2").value="";
            }else if($("#password").val()==null){
                alert("密码为空，请重新输入");
                document.getElementById("password").value="";
                document.getElementById("password2").value="";
            } else{
                $.ajax({
                    data:"password="+$("#password").val(),
                    type:"GET",
                    dataType:'json',
                    url:"user/updatepassword.action",
                    error:function (data) {
                        alert("出现些问题");
                    },
                    success:function(data){
                        alert(data["msg"]);//返回的data是一个map,所以data["msg"]是对象的值
                        /*window.location.href = "view/login.jsp";这个跳转后还是子页面*/
                        /*top.loaction.href的跳转是跳出子页面成为最外层页面*/
                        top.location.href = "jsp/loginnew.jsp"
                    }
                });
            }
        }
    </script>
</head>

<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-key"></span> 修改教师密码</strong></div>
    <div class="body-content">
        <form id="form-wizard" class="form-x" method="post">
            <div class="form-group">
                <div class="label">
                    <label for="password">新密码：</label>
                </div>
                <div class="field">
                    <input id="password" type="password" name="password" class="input w50" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label for="password2">确认新密码：</label>
                </div>
                <div class="field">
                    <input id="password2" type="password" class="input w50" name="password2" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#newpass:两次输入的密码不一致" />
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button type="button" class="button bg-main icon-check-square-o" onclick="updatepass()">保存</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>

</html>