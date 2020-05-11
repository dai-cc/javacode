<%--
  Created by IntelliJ IDEA.
  User: 代睦尘
  Date: 2020/5/6
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <link href="static/css/app.css" rel="stylesheet">
    <!-- jQuery -->
    <script type="text/javascript" src="static/jquery/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){//绑定页面加载时间，在加载完之后执行
            //alert("jsp文件加载完成");
            $.ajax({//提交后台ajax请求
               url:"login",//请求的路径
               type:"post",//请求的方法
               contentType:"application/json",//请求的数据格式
               data:{username:"abc",password:"123"},//请求的数据
                dataType:"json",//响应的数据格式
               success:function (data) {//返回的状态码是200时，调用这个函数

               }
            });
            var json = {username:"abc",password:"123"};
            alert(json.password);
            $("#btn").click(function () {//绑定按钮的点击事件
                //alert("点击按钮");
                //这里也可以写按钮点击，请求服务的代码
            });
        });
    </script>>
</head>
<body>
    <!--假如，提交到后台的url是http://localhost:8080/blog/login -->
    <!-- 如果action为login,实际访问到的路径是http://localhost:8080/blog/jsp/login，是以当前页面作为相对路径，加上请求路径login-->
    <!-- 如果action为/login,访问到的是http://localhost:8080/login-->
    <!--这两种都是不好的，不推荐-->
    <!--改进：配置jsp变量及base标签，可以解决路径问题，action还是login（引入html标签上面10-13行标签内的内容，和18行base标签）-->
    <!--改进之后访问到的地址http://localhost:8080/blog/login-->
    <form action="login">
        <input type="text" name="username" placeholder="请输入用户名">
        <input type="password" name="password" placeholder="请输入密码">
        <input type="submit" value="提交">
    </form>
    <input id="btn" type="button" value="点击观看时间">
</body>
</html>
