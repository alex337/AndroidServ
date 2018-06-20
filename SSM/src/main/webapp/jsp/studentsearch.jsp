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
    <title>课堂教学管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="css/layui.css"  media="all">
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/layui.js" charset="utf-8"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<form method="post" action="">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 学生管理</strong></div>
        <div class="padding border-bottom">
            <ul class="search">
                <li>
                    <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
                    <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
                </li>
            </ul>
        </div>
        <table class="table table-hover text-center">
                            <tr>
                                <th width="120">学号</th>
                                <th>姓名</th>
                                <th>密码</th>
                                <th>班级</th>
                                <th>操作</th>
                            </tr>
                            <tbody>
                            <c:forEach var="student" items="${stulist}">
                                <tr>
                                    <td><input type="checkbox" name="id[]" value="1" />${student.stuID}</td>
                                    <td>${student.stuName}</td>
                                    <td>${student.stuPwd}</td>
                                    <td>${student.stuClass}</td>
                                    <td><div class="button-group"> <a class="button border-main" href="${pageContext.request.contextPath}/jsp/updatestu.jsp?stuname=${student.stuName}&stuid=${student.stuID}&stuclass=${student.stuClass}&password=${student.stuPwd}"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="${pageContext.request.contextPath}/student/deletestu?id=${student.stuID}"onclick="return del()"><span class="icon-trash-o"></span> 删除</a> </div></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                <td colspan="8"><div class="pagelist"> <a href="${pageContext.request.contextPath}/student/showstu?currentPage=0">首页</a>
                    <a href="${pageContext.request.contextPath}/student/showstu?currentPage=${page.currentPage-1}" onclick="return checkFirst()">上一页</a>
                    <a  href="${pageContext.request.contextPath}/student/showstu?currentPage=${page.currentPage+1}" onclick="return checkNext()">下一页</a>
                    <a href="${pageContext.request.contextPath}/student/showstu?currentPage=${page.totalPage}">尾页</a> </div></td>
            </tr>

        </table>


</div>
</form>
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

    function del(){
        if(!confirm("确认要删除？")){
            window.event.returnValue = false;
        }
    }

    $("#checkall").click(function(){
        $("input[name='id[]']").each(function(){
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })

    function DelSelect(){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var t=confirm("您确认要删除选中的内容吗？");
            if (t==false) return false;
        }
        else{
            alert("请选择您要删除的内容!");
            return false;
        }
    }

</script>


</body>
</html>
