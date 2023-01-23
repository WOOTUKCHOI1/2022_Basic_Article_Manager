package com.KoreaIT.java.BAM.dto;

public class Member extends Dto {
	public String loginId;
	public String loginPw;
	public String loginName;
	
	public Member(int id, String regDate, String loginId, String loginPw, String loginName){
		this.id = id;
		this.regDate = regDate;
		this.loginId = loginId;
		this.loginPw = loginId;
		this.loginName = loginName;
	}
}
