package com.xc.houserental.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;


public class CommonWebUtil {
	 /**
	 * <p>Description:下载文件<p>
	 * @param request
	 * @param response
	 * @param fileName
	 * @return
	 * @author WangLei 2017年2月21日
	 */
	public static  String download(HttpServletRequest request, HttpServletResponse response,String fileName) {
	            String realPath = request.getSession().getServletContext().getRealPath("/resources/template/");
	            File file = new File(realPath, fileName);
	            if (file.exists()) {
	            	response.setCharacterEncoding("utf-8");
	                response.setContentType("application/force-download");// 设置强制下载不打开
	                response.addHeader("Content-Disposition",
	                        "attachment;fileName=" +fileName);// 设置文件名
	                byte[] buffer = new byte[1024];
	                FileInputStream fis = null;
	                BufferedInputStream bis = null;
	                try {
	                    fis = new FileInputStream(file);
	                    bis = new BufferedInputStream(fis);
	                    OutputStream os = response.getOutputStream();
	                    int i = bis.read(buffer);
	                    while (i != -1) {
	                        os.write(buffer, 0, i);
	                        i = bis.read(buffer);
	                    }
	                } catch (Exception e) {
	                    // TODO: handle exception
	                    e.printStackTrace();
	                } finally {
	                    if (bis != null) {
	                        try {
	                            bis.close();
	                        } catch (IOException e) {
	                            // TODO Auto-generated catch block
	                            e.printStackTrace();
	                        }
	                    }
	                    if (fis != null) {
	                        try {
	                            fis.close();
	                        } catch (IOException e) {
	                            // TODO Auto-generated catch block
	                            e.printStackTrace();
	                        }
	                    }
	                }
	            }
	        return null;
	    }
	 /**
	 * <p>Description:根据poi 生成的excel对象下载excel<p>
	 * @param request
	 * @param response
	 * @param wb
	 * @param fielName
	 * @return
	 * @author WangLei 2017年2月25日
	 */
	public static String wrieExcel(HttpServletRequest request, HttpServletResponse response,Workbook wb,String fielName){
		 ByteArrayOutputStream os = new ByteArrayOutputStream();
		 if(null==wb){
			 throw new RuntimeException("导出数据为空！");
		 }
	        try {
	            wb.write(os);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        byte[] content = os.toByteArray();
	        InputStream is = new ByteArrayInputStream(content);

	        // 设置response参数，可以打开下载页面
	        response.setContentType("application/vnd.ms-excel;charset=utf-8");
	        try {
			response.setHeader("Content-Disposition", "attachment;filename="+ new String(fielName.getBytes(), "iso-8859-1"));
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	        ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	        BufferedInputStream bis = null;
	        BufferedOutputStream bos = null;

	        try {

	            bis = new BufferedInputStream(is);
	            bos = new BufferedOutputStream(out);

	            byte[] buff = new byte[2048];
	            int bytesRead;

	            // Simple read/write loop.
	            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	                bos.write(buff, 0, bytesRead);
	            }

	        } catch (final IOException e) {
	                 e.printStackTrace();
	        } finally {
	            if (bis != null)
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            if (bos != null)
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        return null;

	    }
}
