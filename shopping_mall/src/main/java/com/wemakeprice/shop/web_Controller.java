package com.wemakeprice.shop;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class web_Controller {
	PrintWriter pw = null;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/ajaxok2.do")
	public String ajaxok2(@RequestBody String all_data, HttpServletResponse res) throws Exception {
		//System.out.println(all_data);
		JSONObject jo = new JSONObject(all_data);
		JSONArray ja = (JSONArray)jo.get("all_data");
	
		JSONObject result = new JSONObject();
		result.put("result", "ok");
		this.pw = res.getWriter();
		this.pw.print(result);
		return null;
	}
	
	// @Request ㅣ 배경을 아용하여 대표키로 존덜 전달 될 경우
	//@RequestBody : GET/POST(X), JSON 기반일 경우 사용 (ContentType:"application/json")
	//@ResponseBody : 미디어타입, 파라미터 타입 단 인자값에는 미선언
	//ajax통신 CORS 방식
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/ajaxok.do")
	//ResponseBody
	public String ajaxok(@RequestParam(value="all_data") List<String> alldata, HttpServletResponse res) throws Exception{
		System.out.println(alldata);
		System.out.println(alldata.get(0));
		this.pw = res.getWriter();
		JSONObject jo = new JSONObject();
		jo.put("result", "ok");
		this.pw.print(jo);
		this.pw.close();
		return null;
	}
}
