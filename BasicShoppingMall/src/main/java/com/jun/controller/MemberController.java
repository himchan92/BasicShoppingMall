package com.jun.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	
	@Autowired
	private JavaMailSender mailSender;
	
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
	
	//이메일 인증
	@GetMapping("/mailCheck")
	@ResponseBody
	public String mailCheckGET(String email) throws Exception {
		logger.info("이메일 데이터 전송 확인");
		logger.info("인증번호 : " + email);
		
		//인증번호(난수) 생성
		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("인증번호 : " + checkNum);
		
		//이메일 보내기
		String setFrom = "thdjun92@naver.com";
		String toMail = email;
		String title = "이메일 테스트";
		String content = "이메일 정상이며 인증번호는 " + checkNum + "입니다.";
		
		try {
			//메일 전송처리
//			MimeMessage message = mailSender.createMimeMessage();
//			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
//			helper.setFrom(setFrom);
//			helper.setTo(toMail);
//			helper.setSubject(title);
//			helper.setText(content, true);
//			mailSender.send(message);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String num = Integer.toString(checkNum);
		
		return num;
	}
		
}
