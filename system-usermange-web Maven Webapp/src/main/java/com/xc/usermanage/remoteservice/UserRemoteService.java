package com.xc.usermanage.remoteservice;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xc.houserental.remoteservice.CommonRemoteService;

@Controller
@RequestMapping("/UserRemoteService")
public class UserRemoteService extends CommonRemoteService {
	@RequestMapping(value="/test/{id}")
     public void testList(@PathVariable String id,HttpServletResponse repose) throws IOException{
		this.responseJson( "Hello Word:"+id,repose);
     }
}
