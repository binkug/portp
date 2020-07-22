package naver.binkug.portfolio.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import naver.binkug.portfolio.service.UserService;

@RestController
public class RestUserController {

	@Autowired
	private UserService userService;
	
	//회원가입을 처리하는 메소드
	@RequestMapping(value = "user/register", method = RequestMethod.POST)
	public Map<String, Object> register(MultipartHttpServletRequest request,HttpServletResponse response) {
		System.out.println("rest컨트롤러 ");
		//서비스의 메소드를 호출
		Map<String, Object> map = userService.insert(request, response);
		//결과 리턴
		
		return map;
	}
	
}
