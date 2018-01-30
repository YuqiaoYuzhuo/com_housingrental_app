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
                            <h4><strong>Beaut-zihan</strong></h4>
                            <p><i class="fa fa-map-marker"></i> 上海市闵行区绿地科技岛广场A座2606室</p>
                            <h5>
                                    关于我
                                </h5>
                            <p>
                                会点前端技术，div+css啊，jQuery之类的，不是很精；热爱生活，热爱互联网，热爱新技术；有一个小的团队，在不断的寻求新的突破。
                            </p>
                            <div class="row m-t-lg">
                                <div class="col-sm-4">
                                    <span class="bar">5,3,9,6,5,9,7,3,5,2</span>
                                    <h5><strong>169</strong> 文章</h5>
                                </div>
                                <div class="col-sm-4">
                                    <span class="line">5,3,9,6,5,9,7,3,5,2</span>
                                    <h5><strong>28</strong> 关注</h5>
                                </div>
                                <div class="col-sm-4">
                                    <span class="bar">5,3,2,-1,-3,-2,2,3,5,2</span>
                                    <h5><strong>240</strong> 关注者</h5>
                                </div>
                            </div>
                            <div class="user-button">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <button type="button" class="btn btn-primary btn-sm btn-block"><i class="fa fa-envelope"></i> 发送消息</button>
                                    </div>
                                    <div class="col-sm-6">
                                        <button type="button" class="btn btn-default btn-sm btn-block"><i class="fa fa-coffee"></i> 赞助</button>
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

