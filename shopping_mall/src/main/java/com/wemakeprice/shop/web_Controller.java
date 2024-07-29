package com.wemakeprice.shop;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

//md5 : 회원가입, 로그인, 패스워드 변경, 1:1문의, 자유게시판, 상품구매, 
@Controller
public class web_Controller extends md5_pass {
	
	PrintWriter pw = null;
	
	// DAO (@ModelAttribute)
	// DAO가 없이 사용시 (한두가지만 필요시 등과 같이) : 자료형 객체 or @Requestparam을 이용해서 사용
	@Resource(name="userselect")
	private user_select us;
	
	@PostMapping("/idsearch.do")
	public String idsearch(String[] uname, String uemail, HttpServletResponse res) throws Exception{	// 아이디 찾기
		res.setContentType("text/html;charset=UTF-8");
		this.pw = res.getWriter();
		try {
			if(uname[0] == null || uemail == null) {
				this.pw.print("<script>"
						+ "alert('올바른 접근 방식이 아닙니다.');"
						+ "history.go(-1);"
						+ "</script>");
			} else {
				List<Object> onedata = us.search_id(uname[0], uemail);
			}
		} catch (Exception e) {
			this.pw.print("<script>"
					+ "alert('Database 문제로 인하여 해당 정보가 확인되지 않습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		} finally {
			this.pw.close();
		}
		return null;
	}
	
	@PostMapping("/passmodify.do")
	public String passmodify() {	// 패스워드 변경
		return null;
	}
	
//	@Resource(name="md5pass")
//	private md5_pass md;
	
	//패스워드 변경 여부를 체크(MD5)
	@GetMapping("/passwd.do")
	public String passwd() {
		String pwd = "a1234";
		String result = this.md5_making(pwd);
		System.out.println(result);
		return null;
	}
	
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
