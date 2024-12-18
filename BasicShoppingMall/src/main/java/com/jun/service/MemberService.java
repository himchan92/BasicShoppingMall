package com.jun.service;

import com.jun.model.MemberVO;

public interface MemberService {
	//회원가입
	public void memberJoin(MemberVO member) throws Exception;
	
	//중복검사
	public int idCheck(String memberId) throws Exception;
}
