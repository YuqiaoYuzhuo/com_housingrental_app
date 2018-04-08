package com.xc.webcommon.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xc.basic.model.UploadFileModel;
/**
 * <p>Title:上传文件时的工具类接口 </p>
 * <p>Description: 上传文件的工具类用户获取request中的文件对象</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年3月11日
 */
public interface UploadAssemblyInterface {
    
    /**
     * <p>Description:获取请求中的文件列表<p>
     * @param request 请求对象
     * @return 文件列表对象
     * @throws IllegalStateException
     * @throws IOException
     * @author wanglei 2018年3月11日
     */
    public   List<UploadFileModel> getFiles(HttpServletRequest request) throws IllegalStateException, IOException;
    
    /**
     * <p>Description:获取请求中的单个文件<p>
     * @param request 请求
     * @return 返回文件上传对象
     * @throws IllegalStateException
     * @throws IOException
     * @author wanglei 2018年3月11日
     */
    public   UploadFileModel getFile(HttpServletRequest request) throws IllegalStateException, IOException;
    
}
