package com.xc.usermanage.remoteservice;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xc.basic.util.CacheUtil;
import com.xc.houserental.remoteservice.CommonRemoteService;

@Controller
@RequestMapping("/UserRemoteService")
public class UserRemoteService extends CommonRemoteService {
	@Autowired
	private CacheUtil cacheUtil;
	@RequestMapping(value="/test/{id}")
     public void testList(@PathVariable String id,HttpServletResponse repose) throws IOException{
		String cach = (String) cacheUtil.get("testcahe", String.class);
		this.responseJson( "Hello Word:"+id+"cache:"+cach,repose);
     }
}
