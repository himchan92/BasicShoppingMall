package com.jun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//회원가입
	@GetMapping("/join")
	public void loginGET() {
		logger.info("회원가입 페이지 진입");
	}
	
	//로그인
	@GetMapping("/login")
	public void joinGET() {
		logger.info("로그인 페이지 진입");
	}
}
