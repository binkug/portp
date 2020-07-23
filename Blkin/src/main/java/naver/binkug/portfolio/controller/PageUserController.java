package naver.binkug.portfolio.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//웹사이트의 페이지 이동에만 사용하려고 만든 컨트롤러
@Controller
public class PageUserController {
	
	@RequestMapping(value = "user/register", method = RequestMethod.GET)
	public String register() {
		//서비스의 메소드를 호출
		System.out.println("컨트롤러 ");
		return "user/register";
	}
	
	@RequestMapping(value = "user/login", method = RequestMethod.GET)
	public String login() {
		//서비스의 메소드를 호출
		System.out.println("컨트롤러 ");
		return "user/login";
	}	
	@RequestMapping(value="user/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
	session.invalidate();
	return "redirect:../";
	}

}
