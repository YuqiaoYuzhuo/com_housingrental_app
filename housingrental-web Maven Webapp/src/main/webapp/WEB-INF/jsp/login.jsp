<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title>用户登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <%@include file="/common/commonheader.jsp" %>
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>


<body class="gray-bg">
    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>
                <h1 class="logo-name">M</h1>
            </div>
            <h4><span id="msg" style="color:red;"></span></h4>
            <form class="m-t" role="form" id="loginForm" onkeydown='on_return()'>
                <div class="form-group">
                    <input type="text" class="form-control" name="userAccount" id ="userAccount" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="passWord" id ="passWord" placeholder="密码" required="">
                </div>
                <c:if test="${SysPro.system_isCheckCode}">
                <div class="form-group">
                    <input type="text"  id="validateCode" name="checkcode" class="col-lg-8 form-control" placeholder="验证码" required="">
                    <br><br>
                    <span style="cursor:pointer">
					<img src="<%=path %>/drawCheckCode" class=" img-responsive" onclick="reCheckcode(this)"/></span>
                    <span style="float:right; margin-top:-10% "><small>看不清，点击图片更换</small></span>
                </div>
                </c:if>
                
                <button type="button" class="btn btn-primary block full-width m-b" onclick="submintForm()">登 录</button>
                <p class="text-muted text-center"> <a href="#"><small>忘记密码了？</small></a> | <a href="<%=path %>/jsp/register.jsp">注册一个新账号</a>
                </p>

            </form>
        </div>
    </div>
    <!-- 全局js -->
    <%@include file="/common/commonfooter.jsp" %>
      <%--如果配置不需要验证码则不输出验证码 --%>
     <c:if test="${SysPro.system_isCheckCode}">
	     <script type="text/javascript" >
	   //获取验证码
	 	function reCheckcode(img) {
	 		img.src="<%=path %>/drawCheckCode?"+Math.random();
	 	}
	 	//校验验证码
	 	function validateCheckCodeIsNull(){
	 		if(!$("#validateCode").val()){
	 			$("#msg").show();
	 			$("#msg").text("验证码不能为空!");
	 			return false;
	 		}else{
	 			return validateCheckcode();
	 		}
	 	}
	     </script>
     </c:if>
        <%--如果配置不需要验证码则不输出验证码 --%>
     <c:if test="${SysPro.system_isCheckCode}">
      <script type="text/javascript" >
     	//登录校验
			function validateLoginInfo (){
				if(validateUserName() && validateUserPassword()){
					if(ischeck=="true"){
						if(validateCheckCodeIsNull()){
							return true;
						}else{
							$("#msg").show();
							$("#msg").text("验证码错误!");
						}
					}else{
						return true;
					}
					
				}
				return false;
			}
     	</script>
     </c:if>
     <%--如果配置不需要验证码则不输出验证码 --%>
     <c:if test="${!SysPro.system_isCheckCode}">
      <script type="text/javascript" >
     	//登录校验
		function validateLoginInfo (){
			if(validateUserName() && validateUserPassword()){
					return true;
				}
				return false;
			}
     	</script>
     </c:if>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#msg").hide();
	var logginTimeOut = "${logginTimeOut}";
	if(logginTimeOut=="true"){
		$("#msg").show();
		$("#msg").text("登录超时，请重新登录！");
	}
});
//校验用户名
function validateUserName(){
	if(!$("#userAccount").val()){
		$("#msg").show();
		$("#msg").text("用户名不能为空!");
		return false;
	}else{
		return true;
	}
		
}
//校验密码
function validateUserPassword(){
	if(!$("#passWord").val()){
		$("#msg").show();
		$("#msg").text("密码不能为空!");
		return false;
	}
	else{
		return true;
	}
}
//点击enter 登录
function on_return(){
 if(window.event.keyCode == 13){
	 submintForm();
 }
}
//提交表单
function submintForm(){
	if(validateLoginInfo ()){
			var params = {
			    userAccount : $("#userAccount").val(),
				passWord : $("#passWord").val()
				};
			var url = '<%=path %>/login';
			$.ajax({
			    cache: false,
				async: false,
				url : url,
				type : 'POST',
				data : params,
				dataType : "JSON",
				success : function(data) {
					if(data.success=="false"){
						$("#msg").show();
						$("#msg").text(data.message);
					}else{
						window.location.href="<%=path%>/admin/index";
					}
				}
		});
	}
}
/*动态验证验证码是否正确*/
function validateCheckcode(){
	var url = '<%=path %>/validateCheckcode';
    var flag = true;
	//获取表单值，并以json的数据形式保存到params中   
	var params = {
		dataType : "JSON",
		checkcode : $("#validateCode").val()
	};
	$.ajax({
		    cache: false,
			async: false,
			url : url,
			type : 'POST',
			data : params,
			dataType : "JSON",
			success : function(data) {
			 if(data.istrue=="false") {	
				 flag = false;
			  }
			}
	});
	return flag;
}
</script>
</html>
