package com.xc.houserental.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.View;

import com.xc.basic.excel.CreateExcelDataFileFactory;
import com.xc.houserental.model.ReturnModel;
import com.xc.houserental.springview.DownloadByFileView;
import com.xc.houserental.springview.DownloadByURLView;

/**
 * <p>Title:公共controller 集成了系统的公共方法 </p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月14日
 */
public class CommonCotroller {
	private String[] titles;
	private String[] columns;
	private List<?> exportList;
	private String fileName;
	private HttpServletRequest request;  
	private HttpServletResponse response;  
	private HttpSession session;  
      
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){  
        this.request = request;  
        this.response = response;  
        this.session = request.getSession();  
    }
    /**
     * 获取HttpServletRequest
     * @author liyufei
     * @return
     */
    protected HttpServletRequest request() {
    	return this.request;
    }
    /**
     * 获取HttpServletResponse
     * @author liyufei
     * @return
     */
    protected HttpServletResponse response() {
    	return this.response;
    }
    /**
     * 获取HttpSession
     * @author liyufei
     * @return
     */
    protected HttpSession sessoion() {
    	return this.session;
    }
	
	/**
	 * 生成excel文件给客户端下载
	 * @param response
	 * @return
	 * @throws IOException
	 */
	protected View responseExcelFile(HttpServletResponse response) throws IOException{
		File file = CreateExcelDataFileFactory.CreateExcelDataFileClass().getExcelFile
		(fileName, exportList, columns, titles);
		return responseFile(file,fileName,response);
	}
	
	/**
	 * 生成文件给客户端下载
	 * @param file
	 * @param exportFileName 文件下载名称
	 * @param response
	 * @return
	 * @throws IOException
	 */
	protected View responseFile(File file,String exportFileName,HttpServletResponse response) throws IOException{
			return new DownloadByFileView(file,exportFileName);
	}
	
	/**
	 * 生成文件给客户端下载
	 * @param url 文件地址
	 * @param exportFileName 文件下载名称
	 * @param response
	 * @return
	 * @throws IOException
	 */
	protected View responseFile(URL url,String exportFileName,HttpServletResponse response) throws IOException{
		return new DownloadByURLView(url,exportFileName);
	}
	
	/**
	 * 返回一个包装好的json对象给前端{res:success/error,rmsg:rmsg}
	 * @param result
	 * @param rmsg
	 * @param response
	 * @throws IOException
	 */
	protected void responseJson(Boolean result,String rmsg,HttpServletResponse response) throws IOException{
		if(result)
			responseSuccessJson(rmsg,response);
		else
			responseFailJson(rmsg,response);
	}
	
	/**
	 * 返回一个包装好的json对象给前端{res:success,rmsg:rmsg}
	 * @param rvalue 返回业务值 
	 * @param rmsg	  返回描述
	 * @param response
	 * @throws IOException
	 */
	
	private void responseSuccessJson(String rmsg,HttpServletResponse response) throws IOException{
        JSONObject jo = ReturnModel.createSuccessJSONObject(rmsg);
        this.responseJson(jo, response);
    }
	
	/**
	 * 返回一个包装好的json对象给前端{res:fail,rvalue:rvalue,rmsg:rmsg}
	 * @param rvalue 返回业务值 
	 * @param rmsg	  返回描述
	 * @param response
	 * @throws IOException
	 */
	private void responseFailJson(String rmsg,HttpServletResponse response) throws IOException{
		JSONObject jo = ReturnModel.createFailJSONObject(rmsg);
        this.responseJson(jo, response);
    }
	
	
	/**
	 * 生成json串给前端
	 * @param jo
	 * @param response
	 * @throws IOException
	 */
    protected void responseJson(JSONObject jo,HttpServletResponse response) throws IOException{
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8"); 
        PrintWriter pw =  response.getWriter();
        pw.append(jo.toString());
        pw.close();
    }
    /**
	 * 生成json串给前端
	 * @param jo
	 * @param response
	 * @throws IOException
	 */
    protected void responseJson(JSONArray jo,HttpServletResponse response) throws IOException{
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");  
        PrintWriter pw =  response.getWriter();
        pw.append(jo.toString());
        pw.close();
    }
    /**
     * 生成字符串给前端
     * @param htmlText
     * @param response
     * @throws IOException
     */
    protected void responseHtmltext(String htmlText,HttpServletResponse response) throws IOException{
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");  
        PrintWriter pw =  response.getWriter();
        pw.append(htmlText);
        pw.close();
    }
    
    /**
     * forward跳转
     * @param path 目标路径
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void forward(String path,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");  
        request.getRequestDispatcher(path).forward(request, response);
    }
    
    /**
     * 重定向
     * @param path 目标地址
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void redirect(String path,HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");  
        response.sendRedirect(path);
    }
    
    /**返回一个图片
     * @param response
     * @param ins 图片二进制流
     * @throws Exception
     */
    @SuppressWarnings("resource")
	protected void responseImage(HttpServletResponse response,File file) throws Exception{  
        if(null == file){
        	return ;
        }
    	response.setContentType("image/png");
        OutputStream stream = response.getOutputStream(); 
        FileInputStream fin = new FileInputStream(file);
        byte[] buf=new byte[1024];  
        int len=0;  
        while((len=fin.read(buf))!=-1){   //将byte数据读到最多buf长度的buf数组中   
        	stream.write(buf,0,len); 
        }  
        stream.flush();  
        stream.close();  
          
    }  
    /**
     * <p>Description:获取项目的绝对根路径<p>
     * @return 项目根路径
     * @author wanglei 2017年8月18日
     */
    protected String getRealPath() {
        return ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
    }
	public String[] getTitles() {
		return titles;
	}

	public void setTitles(String[] titles) {
		this.titles = titles;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public List<?> getExportList() {
		return exportList;
	}

	public void setExportList(List<?> exportList) {
		this.exportList = exportList;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
    
}
