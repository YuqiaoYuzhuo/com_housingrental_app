package com.xc.houserental.util.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.xc.basic.model.UploadFileModel;
import com.xc.basic.util.CommonFileUtils;
import com.xc.basic.util.SystemPropertiesUtil;
import com.xc.houserental.factory.MyCommonsMultipartResolverFactory;
import com.xc.houserental.util.UploadAssemblyInterface;

@Service("uploadAssemblyInterface")
public class BaseUploadAssembly implements UploadAssemblyInterface
{

    public static final Logger logger  = LoggerFactory.getLogger(BaseUploadAssembly.class.getName());
    
    private  CommonsMultipartResolver multipartResolver;
    
    public void UploadAssembly(){
       
    }
    
    @Override
    public List<UploadFileModel> getFiles(HttpServletRequest request)throws IllegalStateException, IOException
    {
        List<UploadFileModel> files = new ArrayList<UploadFileModel>();
        //创建一个通用的多部分解析器  
         multipartResolver =MyCommonsMultipartResolverFactory.getInstance().createCommonsMultipartResolver(request);
        //判断 request 是否有文件上传,即多部分请求  
          if(multipartResolver.isMultipart(request)){  
              //转换成多部分request    
              MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
              //取得request中的所有文件名  
              Iterator<String> iter = multiRequest.getFileNames();  
              while(iter.hasNext()){
                  UploadFileModel model = new UploadFileModel();
                  //取得上传文件  
                  MultipartFile file = multiRequest.getFile(iter.next());  
                  if(file != null){  
                      //取得当前上传文件的文件名称  
                      String myFileName = file.getOriginalFilename();  
                      if(myFileName.trim() !="" &&myFileName.indexOf(".") != -1){
                          String filename = myFileName.substring(0,myFileName.indexOf("."));
                          String suffix = myFileName.substring(myFileName.indexOf(".")+1,myFileName.length());
                          model.setFileRealName(filename);
                       
                          String fileSystemName = filename+"_"+System.currentTimeMillis();
                          model.setFileSystemName(fileSystemName);
                          model.setSuffix(suffix);
                          
                          //重命名上传后的文件名  
                          String fileSuffix = model.getSuffix();
                          String fileTempAllPath = SystemPropertiesUtil.getUploadTempPathPropertyValue() +fileSystemName+"."+fileSuffix; 
                          String fileRealAllPath = SystemPropertiesUtil.getUploadPathPropertyValue()+fileSystemName+"."+fileSuffix;
                          //如果文件为图片则新建imag文件夹
                          if(CommonFileUtils.isPicture(fileSuffix)){
                        	  fileRealAllPath = SystemPropertiesUtil.getUploadPathPropertyValue()+"image/"+fileSystemName+"."+fileSuffix;
                          }
                          File localFile = new File(fileTempAllPath);  
                          if(!localFile.getParentFile().exists()){
                        	  localFile.mkdirs();
                          }
                          file.transferTo(localFile);
                          model.setFileSize(String.valueOf(localFile.length()));
                          model.setTemp_file_path(fileTempAllPath);
                          model.setFile_upload_real_path(fileRealAllPath);
                          model.setFile(localFile);
                          files.add(model);
                      }else{
                          logger.warn("文件不存在.............file name is null ");
                      }
                  }else{
                      logger.warn("文件不存在..............file is null ");
                  }
              }
              return files;
              }else{
                  logger.warn("无文件上传!");
                  return null;
              }
    }

    @Override
    public UploadFileModel getFile(HttpServletRequest request)throws IllegalStateException, IOException
    {
        List<UploadFileModel> list  = getFiles(request);
        if(list !=null && list.size()>0) {
                return list.get(0);
        }else {
            logger.warn("文件不存在..............");
            return null;
        }
    }  
}
