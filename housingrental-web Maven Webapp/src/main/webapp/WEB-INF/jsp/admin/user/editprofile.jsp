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
    <title>修改个人信息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <%@include file="/common/commonheader.jsp" %>
</head>
<body class="gray-bg">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>个人信息维护 <small>修改个人信息</small></h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-sm-12">
                                 <form class="form-horizontal" id="updateprofileform" method="post">
                                 <input type="hidden" id="userUuid" name="userUuid" value="${uif.userUuid}" class="form-control">
                                 <div class="form-group">
                                    <label class="col-sm-3 control-label">姓名：</label>
                                    <div class="col-sm-8">
                                        <input type="text" id="userName" name="userName" value="${uif.userName}" class="form-control">
                                        <span id="msg" style="color:red;"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">邮箱：</label>
                                    <div class="col-sm-8">
                                        <input type="text" id="userEmainl" name="userEmainl" value="${uif.userEmainl}" class="form-control">
                                        <span id="msg" style="color:red;"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">生日：</label>
                                    <div class="col-sm-8">
                                        <input type="text" id="userBirthday" name="userBirthday" value="${uif.userBirthday}" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">电话：</label>
                                    <div class="col-sm-8">
                                        <input type="text" id="userTel" name="userTel" value="${uif.userTel}" class="form-control">
                                    </div>
                                </div>
                                  <div class="form-group">
                                    <label class="col-sm-3 control-label">性别：</label>
                                    <div class="col-sm-8">
                                        <input type="text" id="userGender" name="userGender" value="${uif.userGender}" class="form-control">
                                    </div>
                                </div>
                                  <div class="form-group">
                                    <label class="col-sm-3 control-label">QQ：</label>
                                    <div class="col-sm-8">
                                        <input type="text" id="userQqAccount" name="userQqAccount" value="${uif.userQqAccount}" class="form-control">
                                    </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-sm-3 control-label">微信：</label>
                                    <div class="col-sm-8">
                                        <input type="text" id="userWxAccout" name="userWxAccout" value="${uif.userWxAccout}" class="form-control">
                                    </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-sm-3 control-label">地址：</label>
                                    <div class="col-sm-8">
                                        <input type="text" id="userAddr" name="userAddr" value="${uif.userAddr}" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-3 col-sm-8">
                                        <button class="btn btn-lg btn-info"  onclick="submitUpForm();" id="sub_butn" type="button">确认修改 </button>
                                    </div>
                                </div>
                            </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
          </div>
    <!-- 全局js -->
    <%@include file="/common/commonfooter.jsp" %>
    <!-- 自定义js -->
  <!-- 自定义js -->
    <script src="${SysPro.system_static_sourceurl_prefix}/js/content${SysPro.system_static_sourceurl_jssuffix}"></script>
    <!-- iCheck -->
    <script src="${SysPro.system_static_sourceurl_prefix}/js/plugins/iCheck/icheck.min${SysPro.system_static_sourceurl_jssuffix}"></script>
        <script src="${SysPro.system_static_sourceurl_prefix}js/plugins/validate/jquery.validate.min${SysPro.system_static_sourceurl_jssuffix}"></script>
    <script src="${SysPro.system_static_sourceurl_prefix}js/plugins/validate/messages_zh.min${SysPro.system_static_sourceurl_jssuffix}"></script>
    <script src="${SysPro.system_static_sourceurl_prefix}js/common.validator${SysPro.system_static_sourceurl_jssuffix}"></script>
    <script>
        $(document).ready(function () {
             
        });
        //修改个人信息提交方法
        function submitUpForm(){
            var _url = '<c:url value="/admin/user/saveProfile"/>';
            $("#updateprofileform").ajaxSubmit({
                cache: false,
                dataType : "json", 
                async: false,
                url : _url,
                type :'POST',
                success : function(data) {
                        alert(data);
                }
            });
        }
    </script>
</body>
</html>

