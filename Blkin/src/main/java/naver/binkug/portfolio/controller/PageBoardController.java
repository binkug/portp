package naver.binkug.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageBoardController {
	@RequestMapping(value = "dashboard", method = RequestMethod.GET)
	public String dashboard() {
		//서비스의 메소드를 호출
		
		return "user/dashboard";
	}
	
	@RequestMapping(value = "alluser", method = RequestMethod.GET)
	public String alluser() {
		//서비스의 메소드를 호출
		
		return "user/alluser";
	}
}
