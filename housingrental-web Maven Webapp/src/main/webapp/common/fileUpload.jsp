<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>文件上传</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <form action='<c:url value="/attachment/fileupload"/>?method=fileUpload' method="post" enctype="multipart/form-data">
	<input type="text" name =bussinessId  />
	<input type="file" name ="file1" />
	<input type = "submit" value="上传"/>
	<%-- <img alt="" src="<c:url value='/attachment/getImage?attachId=fae1fc7cc98b426389187017a8c69619s'/>"> --%>
	<div id="imgFiled">
	</div>
</form>
<%@include file="/common/commonfooter.jsp" %>
<script type="text/javascript">
getImgFiled('11111','imgFiled');
</script>
  </body>
</html>
