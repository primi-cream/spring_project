package com.wemakeprice.shop;

import java.security.MessageDigest;

import org.springframework.stereotype.Repository;

//@Repository("md5pass")
abstract class md5_pass {
	
	public String md5_making (String upass) {
		StringBuilder sb = new StringBuilder(); // return에 사용되는 객체
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			md.update(upass.getBytes());
			for(byte bt:md.digest()) {
				sb.append(String.format("%x", bt));
			}
		} catch(Exception e) {
			sb.append("인자값 오류 발생으로 생성이 되지 않음");
		}
		
		return sb.toString();
	}
}
