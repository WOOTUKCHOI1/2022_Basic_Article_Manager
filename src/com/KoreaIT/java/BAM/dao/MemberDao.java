package com.KoreaIT.java.BAM.dao;

import java.util.ArrayList;
import java.util.List;

import com.KoreaIT.java.BAM.dto.Member;

public class MemberDao extends Dao {
	private List<Member> members;
	
	public MemberDao() {
		members = new ArrayList<>();
	}

	public void add(Member member) {
		members.add(member);
		lastId++;
	}
	
	public boolean loginIdChk(String loginId) {
		int index = getMemberIndexByLoginId(loginId);

		if (index == -1) {
			return true;
		}

		return false;
	}

	public int getMemberIndexByLoginId(String loginId) {
		int i = 0;

		for (Member member : members) {
			if (member.loginId.equals(loginId)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public Member getMemberByLoginId(String loginId) {
		int index = getMemberIndexByLoginId(loginId);
		
		if(index != -1) {
			return members.get(index);
		}
		
		return null;
	}

	public String getWriterName(int memberId) {
		
		for(Member member : members) {
			if(memberId == member.id) {
				return member.name;
			}
		}
		return null;
	}
	
}
