package com.xc.rental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xc.houserental.controller.CommonCotroller;
@Controller()
@RequestMapping("/admin/rental")
public class RentalController extends CommonCotroller {
	@RequestMapping("/rentals")
	public String index(){
		return "/houserental/houserental";
	}
}
