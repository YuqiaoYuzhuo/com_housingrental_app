<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 全局js -->
<script src="${SysPro.system_static_sourceurl_prefix}/js/jquery.min${SysPro.system_static_sourceurl_jssuffix}?v=2.1.4"></script>
<script src="${SysPro.system_static_sourceurl_prefix}/js/bootstrap.min${SysPro.system_static_sourceurl_jssuffix}?v=3.3.6"></script>
<script src="${SysPro.system_static_sourceurl_prefix}/js/plugins/metisMenu/jquery.metisMenu${SysPro.system_static_sourceurl_jssuffix}"></script>
<script src="${SysPro.system_static_sourceurl_prefix}/js/plugins/slimscroll/jquery.slimscroll.min${SysPro.system_static_sourceurl_jssuffix}"></script>
<script src="${SysPro.system_static_sourceurl_prefix}/js/plugins/layer/layer.min${SysPro.system_static_sourceurl_jssuffix}"></script>
<!-- Flot -->
    <script src="${SysPro.system_static_sourceurl_prefix}/js/plugins/flot/jquery.flot${SysPro.system_static_sourceurl_jssuffix}"></script>
    <script src="${SysPro.system_static_sourceurl_prefix}/js/plugins/flot/jquery.flot.tooltip.min${SysPro.system_static_sourceurl_jssuffix}"></script>
    <script src="${SysPro.system_static_sourceurl_prefix}/js/plugins/flot/jquery.flot.resize${SysPro.system_static_sourceurl_jssuffix}"></script>
    <script src="${SysPro.system_static_sourceurl_prefix}/js/plugins/flot/jquery.flot.pie${SysPro.system_static_sourceurl_jssuffix}"></script>
<!-- 第三方插件 -->
<script src="${SysPro.system_static_sourceurl_prefix}/js/plugins/pace/pace.min${SysPro.system_static_sourceurl_jssuffix}"></script>
<script>
function getImgFiled(bussinessUuid,filedId){
	if(bussinessUuid!=''&&filedId!=''){
		var _url = "<c:url value='/attachment/getattachments'/>?businessUuid="+bussinessUuid;
		$.ajax({
		    cache: false,
			async: false,
			url : _url,
			type : 'POST',
			dataType : "JSON",
			success : function(data) {
				if(data.res=="success"){
					console.info(data.rmsg);
					var htmlText = getImageFiledHtmlText(data.rmsg);
					htmlText+= getAttacListHtml(data.rmsg);
					$("#"+filedId).html(htmlText);
				}
			}
	});
 }
}
function getImageFiledHtmlText(attachIds){
	var attachIdsArr = eval(attachIds);;
	var htmlTxt = "";
	for(i=0;i<attachIdsArr.length;i++){
		htmlTxt+="<img src='<c:url value='/attachment/getImage'/>?attachId="+attachIdsArr[i].attachUuid+"'/>"
	}
	return htmlTxt;
}	
function getAttacListHtml(attachIds){
	var attachIdsArr = eval(attachIds);;
	var htmlTxt = "";
	for(i=0;i<attachIdsArr.length;i++){
		htmlTxt+="<a href ='<c:url value='/attachment/fileDownload'/>?attachId="+attachIdsArr[i].attachUuid+"'>"+attachIdsArr[i].attachRealName+"|</a>";
	}
	return htmlTxt;
}
</script>