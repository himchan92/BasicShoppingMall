package com.jun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.mapper.MemberMapper;
import com.jun.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public void memberJoin(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		memberMapper.memberJoin(member);
	}

	@Override
	public int idCheck(String memberId) throws Exception {
		// TODO Auto-generated method stub
		return memberMapper.idCheck(memberId);
	}	
}
