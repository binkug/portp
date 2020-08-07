package naver.binkug.portfolio.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import naver.binkug.portfolio.service.HibernateUserService;

@RestController
public class HibernateRestUserController {
	@Autowired
	private HibernateUserService hibernateUserService;
	
	//회원가입을 처리하는 메소드
	@RequestMapping(value = "user/register", method = RequestMethod.POST)
	public Map<String, Object> register(MultipartHttpServletRequest request,HttpServletResponse response) {
		System.out.println("rest컨트롤러 ");
		//서비스의 메소드를 호출
		hibernateUserService.join(request);
		Map<String, Object> map = (Map<String, Object>)request.getAttribute("result");
		//결과 리턴
		
		return map;
	}
	
	//로그인을 처리하는 메소드
	@RequestMapping(value = "user/login", method = RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request,HttpServletResponse response) {
		
		System.out.println("rest컨트롤러 ");
		//서비스의 메소드를 호출
		hibernateUserService.login(request);
		Map<String, Object> map = (Map<String, Object>)request.getSession().getAttribute("result");
		System.out.println("controller : "+map);
		//결과 리턴
		return map;
	}
	
	//업데이트를 처리하는 메소드
	@RequestMapping(value = "user/update", method = RequestMethod.POST)
	public Map<String, Object> update(MultipartHttpServletRequest request) {
		
		System.out.println("rest컨트롤러 ");
		//서비스의 메소드를 호출
		hibernateUserService.update(request);
		Map<String, Object> map = (Map<String, Object>)request.getAttribute("result");
		//결과 리턴
		
		return map;
	}
}
