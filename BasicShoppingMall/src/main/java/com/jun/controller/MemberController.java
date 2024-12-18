package com.jun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jun.model.MemberVO;
import com.jun.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberservice;
	
	//회원가입 페이지
	@GetMapping("/join")
	public void loginGET() {
		logger.info("회원가입 페이지 진입");
	}
	
	//회원가입
	@PostMapping("/join")
	public String joinPOST(MemberVO member) throws Exception {
		logger.info("join 진입");
		
		memberservice.memberJoin(member);
		
		logger.info("join service 성공");
		
		return "redirect:/main";
	}
	
	//로그인
	@GetMapping("/login")
	public void joinGET() {
		logger.info("로그인 페이지 진입");
	}
	
	@PostMapping("/memberIdChk")
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception {
		logger.info("memberIdChk() 진입");
		
		int result = memberservice.idCheck(memberId);
		
		logger.info("결과값 = " + result);
		
		if(result != 0) {
			return "fail"; //중복 아이디가 존재
		} else {
			return "success"; //중복 아이디 x
		}
	}
		
}
