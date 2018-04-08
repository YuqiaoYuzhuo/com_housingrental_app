package com.xc.systemmanage.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import com.xc.basic.exception.BusinessException;
import com.xc.basic.model.UploadFileModel;
import com.xc.basic.util.CommonFileUtils;
import com.xc.basic.util.FtpUtil;
import com.xc.system_usermanage_core.service.UserService;
import com.xc.systemmanage_core.model.Attachment;
import com.xc.systemmanage_core.service.AttachMentService;
import com.xc.webcommon.controller.CommonCotroller;
import com.xc.webcommon.util.UploadAssemblyInterface;

/**
 * <p>Title:附件上传下载controller </p>
 * <p>Description:附件上传下载 </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年3月11日
 */
@Scope("prototype")
@Controller
@RequestMapping("/attachment")
public class AttachmentController extends CommonCotroller {
	@Autowired
	private UploadAssemblyInterface uploadAssemblyInterface;
	@Autowired
	private AttachMentService attachMentService;
	@Autowired
	private UserService userService;
	/**
	 * <p>Description:附件上传<p>
	 * @param request 请求request
	 * @param response 
	 * @param attachment 附件
	 * @throws IllegalStateException
	 * @throws IOException
	 * @author wanglei 2018年3月11日
	 */
	@RequestMapping("/fileupload")
	@ResponseBody
	public void fileUpload(HttpServletRequest request,HttpServletResponse response,String bussinessId) throws IllegalStateException, IOException{
		UploadFileModel upf = uploadAssemblyInterface.getFile(request);
		String upPsn = userService.getCurentLoginUser().getUserInfo().getUserName();
		Attachment	attachment = attachMentService.addAttachment(upf,bussinessId,upPsn);
		super.responseJson(true,attachment.getAttachUuid(), response);
	}
	/**
	 * <p>Description:附件下载<p>
	 * @param request
	 * @param response
	 * @param attachId 业务id
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * @author wanglei 2018年3月11日
	 */
	@RequestMapping("/fileDownload")
	public View fileDownload(HttpServletRequest request,HttpServletResponse response,String attachId,String businessId) throws IllegalStateException, IOException{
		List<String> filePath = this.getFilePathsByBusinessUuidOrAttachuuid(attachId, businessId);
		List<File> resFiels = this.getFileByPaths(filePath);
		if(null==resFiels){
			throw new BusinessException("系统错误!");
		}
		if(resFiels.size()==1){
			return this.responseFile(resFiels.get(0), CommonFileUtils.getFileNameByPath(resFiels.get(0).getName()), response);
		}
		return this.responseZipFile(resFiels,String.valueOf(System.currentTimeMillis())+".zip",response);
	}
	/**
	 * <p>Description:获取图片方法<p>
	 * @param request
	 * @param response
	 * @param attachment 附件实体类
	 * @throws Exception
	 * @author wanglei 2018年3月11日
	 */
	@RequestMapping("/getImage")
	public void getImage(HttpServletRequest request,HttpServletResponse response,String attachId) throws Exception{
		Attachment attachment = null;
		FtpUtil ftu = FtpUtil.getFtputil();
		if(StringUtils.isNotBlank(attachId)){
			 attachment = attachMentService.findByid(attachId);
		}else{
			throw new BusinessException("系统错误!");
		}
		File resFiel = ftu.downloadFileByFtp(attachment.getAttachSysPath());
		this.responseImage(response, resFiel);
	}
	@RequestMapping("/getattachments")
	public void getImgAttahcUuidsByBusinessUuid(String businessUuid,HttpServletResponse response) throws IOException{
		List<Attachment> attachments = this.getAttachmentUuidByBusinessUuid(businessUuid);
		JSONArray joa= new JSONArray(attachments);
		this.responseJson(true, joa.toString(), response);
	}
	/**
	 * <p>Description:附件删除<p>
	 * @param request
	 * @param response
	 * @param attachment
	 * @throws IllegalStateException
	 * @throws IOException
	 * @author wanglei 2018年3月11日
	 */
	@RequestMapping("/fileDelete")
	@ResponseBody
	public void fileDelete(HttpServletRequest request,HttpServletResponse response,String attachId,String businessId) throws IllegalStateException, IOException{
		FtpUtil ftu = FtpUtil.getFtputil();
		List<String> filePaths = this.getFilePathsByBusinessUuidOrAttachuuid(attachId, businessId);
		for(String filepath:filePaths){
			 ftu.deleteFile(filepath);
		     attachMentService.deleteAttachmentByIds(attachId);	
		}
		super.responseJson(true,"文件删除成功！", response);
	}
	/**
	 * <p>Description:根据文件路径批量下载文件<p>
	 * @param filePaths
	 * @return
	 * @author wanglei 2018年3月31日
	 */
	private List<File> getFileByPaths(List<String> filePaths){
		List<File> res = new ArrayList<>();
		FtpUtil ftu = FtpUtil.getFtputil();
		for(String filepath:filePaths){
			File resFiel = ftu.downloadFileByFtp(filepath);
			res.add(resFiel);
		}
		return res.size()>0?res:null;
	}
	/**
	 * <p>Description:根据业务标示或者附件标示获取文件路径<p>
	 * @param attachId
	 * @param businessId
	 * @return
	 * @author wanglei 2018年3月31日
	 */
	private List<String> getFilePathsByBusinessUuidOrAttachuuid(String attachId,String businessId){
		List<String> filePaths = new ArrayList<>();
		Attachment attachment = null;
		List<Attachment> attachments = new ArrayList<>();
		if(StringUtils.isNotBlank(attachId)){
			 attachment = attachMentService.findByid(attachId);
		}
		if(StringUtils.isNotBlank(businessId)){
			attachments = attachMentService.findAttachmentBusinessUuid(businessId);
		}
		if(null!=attachments&& null!=attachment){
			attachments.add(attachment);
		}
		for(Attachment at:attachments){
			filePaths.add(at.getAttachSysPath());
		}
		if(filePaths.size()<=0){
			throw new BusinessException("附件不存在!");
		}
		return filePaths;
	} 
	/**
	 * <p>Description:根据业务id获取附件id集合<p>
	 * @param businessUuid
	 * @author wanglei 2018年3月31日
	 */
	private List<Attachment> getAttachmentUuidByBusinessUuid(String businessUuid){
		List<Attachment> attachments = null;
		if(StringUtils.isNotBlank(businessUuid)){
			attachments = attachMentService.findAttachmentBusinessUuid(businessUuid);
		}
		if(null==attachments||attachments.size()<=0){
			throw new BusinessException("附件不存在!");
		}
		return attachments;
	}
}
