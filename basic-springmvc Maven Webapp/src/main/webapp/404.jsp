<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - 404 页面</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="shortcut icon" href="favicon.ico"> <link href="${SysPro.system_static_sourceurl_prefix}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${SysPro.system_static_sourceurl_prefix}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${SysPro.system_static_sourceurl_prefix}/css/animate.css" rel="stylesheet">
    <link href="${SysPro.system_static_sourceurl_prefix}/css/style.css?v=4.1.0" rel="stylesheet">

</head>
<body class="gray-bg">
    <div class="middle-box text-center animated fadeInDown">
        <h1>404</h1>
        <h3 class="font-bold">页面未找到！</h3>
        <div class="error-desc">
            抱歉，页面好像去火星了~
      <br/><a href="/housingrental/admin/welcomeindex" class="btn btn-primary m-t">返回主页</a>
        </div>
    </div>
    <!-- 全局js -->
    <script src="${SysPro.system_static_sourceurl_prefix}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${SysPro.system_static_sourceurl_prefix}/js/bootstrap.min.js?v=3.3.6"></script>
</body>
</body> 
</html>
