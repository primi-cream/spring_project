package com.wemakeprice.shop;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class web_Controller {
	PrintWriter pw = null;
	
	//ajax통신 CORS 방식
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/ajaxok.do")
	public String ajaok(){
		return null;
	}
}
