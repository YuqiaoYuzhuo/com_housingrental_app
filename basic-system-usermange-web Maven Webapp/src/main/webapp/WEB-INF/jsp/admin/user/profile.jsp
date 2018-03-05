<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人资料</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
 	<%@include file="/common/commonheader.jsp" %>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row animated fadeInRight">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>个人资料</h5>
                    </div>
                    <div>
                        <div class="ibox-content no-padding border-left-right">
                            <img alt="image" class="img-responsive" src="${SysPro.system_static_sourceurl_prefix}/img/profile_big.jpg">
                        </div>
                        <div class="ibox-content profile-content">
                            <h4><strong>${uif.userName}</strong></h4>
                            <p><i class="fa fa-map-marker"></i> ${uif.userAddr}</p>
                            <h5>
                           	   邮箱
                            </h5>
                            <p>
                           		 ${uif.userEmainl}
                            </p>
                            <h5>
                           	  生日
                            </h5>
                            <p>
                           		 ${uif.userBirthday}
                            </p>
                            <h5>
                           	   电话
                            </h5>
                            <p>
                           		 ${uif.userTel}
                            </p>
                            <h5>
                           	  用户等级
                            </h5>
                            <p>
                           		 ${uif.userLevel}
                            </p>
                            <h5>
                           	   性别
                            </h5>
                            <p>
                        		 <c:if test="${uif.userGender =='1'}">
                        		       男
                        		 </c:if>
                        		  <c:if test="${uif.userGender =='2'}">
                        		       女
                        		 </c:if>
                            </p>
                            <h5>
                           	   QQ
                            </h5>
                            <p>
                           		 ${uif.userQqAccount}
                            </p>
                            <h5>
                           	 微信
                            </h5>
                            <p>
                           		 ${uif.userWxAccout}
                            </p>
                            <div class="user-button">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <button type="button" class="btn btn-primary btn-sm btn-block"><i class="fa fa-envelope"></i>修改信息</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </div>
    <!-- 全局js -->
     <!-- 全局js -->
    <%@include file="/common/commonfooter.jsp" %>
    <!-- 自定义js -->
    <script src="${SysPro.system_static_sourceurl_prefix}js/content${SysPro.system_static_sourceurl_jssuffix}"></script>
    <!-- Peity -->
    <script src="${SysPro.system_static_sourceurl_prefix}js/plugins/peity/jquery.peity.min${SysPro.system_static_sourceurl_jssuffix}"></script>
    <!-- Peity -->
    <script src="${SysPro.system_static_sourceurl_prefix}js/demo/peity-demo${SysPro.system_static_sourceurl_jssuffix}"></script>
</body>
</html>

