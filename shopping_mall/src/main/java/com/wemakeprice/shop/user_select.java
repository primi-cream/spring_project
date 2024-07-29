package com.wemakeprice.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

// user table (select,insert,update,delete)	- Module
@Repository("userselect")
public class user_select {
	@Resource(name="template")
	private SqlSessionTemplate tm;
	
	public List<Object> search_id(String uname, String uemail) {	// 1명의 정보
		ArrayList<Object> onedata = new ArrayList<Object>();
		Map<String, String> keycode = new HashMap<String, String>();
		keycode.put("part", "1");
		keycode.put("uname", uname);
		keycode.put("uemail", uemail);
		user_dao dao = tm.selectOne("Shopping_mall.search",keycode);
		System.out.println(keycode + " dao : " + dao.getUemail());
		System.out.println(dao);
		System.out.println(dao.getUemail());
		System.out.println(dao.getUid());
		
		return onedata;
	}
}
