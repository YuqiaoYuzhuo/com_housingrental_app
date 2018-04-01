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
    <meta name="renderer" content="webkit">
    <title> ${SysPro.system_name}主页</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <%@include file="/common/commonheader.jsp" %>
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <i class="glyphicon glyphicon-home"></i>
                                        <strong class="font-bold">M</strong>
                                    </span>
                                </span>
                            </a>
                        </div>
                        <div class="logo-element">M
                        </div>
                    </li>
                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">系统菜单</span>
                    </li>
                    <li>
                        <a class="J_menuItem" href="welcomeindex">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">主页</span>
                        </a>
                    </li>
                    <!--用户菜单  -->
                   <c:forEach items="${systemMenus}" var="systemMenu" >
                    <c:if test="${empty systemMenu.menuUrl}">
                      <li>
                    	<a href="#">
                            <i class="${systemMenu.menuRemark}"></i>
                            <span class="nav-label">${systemMenu.menuName}</span>
                            <span class="fa arrow"></span>
                        </a>
                         <ul class="nav nav-second-level">
                         <c:forEach items="${systemMenus}" var="systemsubMenu">
                           <c:if test="${systemsubMenu.menuParentUuid==systemMenu.menuUuid}">
                           	 <li>
                                <a class="J_menuItem" href="<c:url value='${systemsubMenu.menuUrl}'/>">${systemsubMenu.menuName}</a>
                            </li>
                           </c:if>
                         </c:forEach>
                         </ul>
                        </li>
                    </c:if>
                   </c:forEach>
                    <!--用户菜单结束  -->
                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="#"><i class="fa fa-bars"></i> </a>
                        <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                            <div class="form-group">
                                <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                            </div>
                        </form>
                    </div>
                    <ul class="nav navbar-top-links navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <i class="glyphicon glyphicon-cog"></i>个人配置
                            </a>
                            <ul class="dropdown-menu dropdown-alerts">
                                <li>
                                    <a class="J_menuItem dropdown-toggle" data-toggle="dropdown"  href="user/profile">
                                        <div>
                                            <i class="glyphicon glyphicon-user"></i>
                                            		个人资料
                                        </div>
                                    </a>
                                </li>
                                 <li class="divider"></li>
                            
                                <li>
                                    <a class="J_menuItem" href="user/updatepasswd">
                                        <div>
                                            <i class="glyphicon glyphicon-pencil"></i> 修改密码
                                        </div>
                                    </a>
                                </li>
                               
                                <li class="divider"></li>
                                <li>
                                    <a href="<%=basePath%>loginout">
                                        <div>
                                            <i class="glyphicon glyphicon-off"></i> 退出
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="row J_mainContent" id="content-main">
                <iframe id="J_iframe" width="100%" height="100%" src="welcomeindex" frameborder="0" data-id="welcomeindex" seamless></iframe>
            </div>
        </div>
        <!--右侧部分结束-->
    </div>
<div style="text-align:center;">
</div>
</body>
    <%@include file="/common/commonfooter.jsp" %>
    <!-- 自定义js -->
<script src="${SysPro.system_static_sourceurl_prefix}/js/hAdmin.js?v=4.1.0"></script>
<script type="text/javascript" src="${SysPro.system_static_sourceurl_prefix}/js/index.js"></script>
<script type="text/javascript">
$(function () {          
    $(".J_menuItem").on('click', function (e) {
    	$(".dropdown").removeClass('open');
    });

});
</script>
</html>

