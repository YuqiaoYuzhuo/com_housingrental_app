<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>用户注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <%@include file="/common/commonheader.jsp" %>
  </head>
<body class="gray-bg">
    <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div>
            <div>
                <h1 class="logo-name">M+</h1>
            </div>
            <h3>欢迎注册 ${SysPro.system_name}</h3>
            <p>创建一个${SysPro.system_name}新账户</p>
            <form class="m-t" role="form" method="POST" id ="userRegister" action="admin/user/addRegisterHouseOwner">
                <div class="form-group">
                    <input type="text" class="form-control" id="uaserAccountNum" name="uaserAccountNum" placeholder="请输入手机号" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="userAccountPassword" name="userAccountPassword"  placeholder="请输入密码" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="confirm_password" name="confirm_password"   placeholder="请再次输入密码" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">注 册</button>

                <p class="text-muted text-center"><small>已经有账户了？</small><a href="login.jsp">点此登录</a>
                </p>

            </form>
        </div>
    </div>

    <!-- 全局js -->
    <%@include file="/common/commonfooter.jsp" %>
    <!-- iCheck -->
    <script src="${SysPro.system_static_sourceurl_prefix}/js/plugins/iCheck/icheck.min.js"></script>
   <script src="${SysPro.system_static_sourceurl_prefix}js/plugins/validate/jquery.validate.min${SysPro.system_static_sourceurl_jssuffix}"></script>
    <script src="${SysPro.system_static_sourceurl_prefix}js/plugins/validate/messages_zh.min${SysPro.system_static_sourceurl_jssuffix}"></script>
     <script src="${SysPro.system_static_sourceurl_prefix}js/common.validator${SysPro.system_static_sourceurl_jssuffix}"></script>
</body>
</html>
