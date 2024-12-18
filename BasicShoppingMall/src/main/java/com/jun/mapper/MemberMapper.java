package com.jun.mapper;

import com.jun.model.MemberVO;

public interface MemberMapper {
	
	//회원가입
	public void memberJoin(MemberVO member);
	
	//중복검사
	public int idCheck(String memberId);
}