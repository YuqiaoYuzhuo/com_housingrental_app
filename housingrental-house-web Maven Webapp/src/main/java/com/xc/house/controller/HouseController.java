package com.xc.house.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xc.webcommon.controller.CommonCotroller;

@Controller
@RequestMapping("/admin/house")
public class HouseController extends CommonCotroller {
	@RequestMapping("/houses")
	public String index (){
		return "/house/house";
	}
}
