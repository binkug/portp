package naver.binkug.portfolio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import naver.binkug.portfolio.domain.User;
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
	
	//회원 리스트를 보는 메소
	@RequestMapping(value = "user/list", method = RequestMethod.GET)
	public Map<String, Object> list(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("rest컨트롤러 ");
		//서비스의 메소드를 호출
		userService.list(request, response);
		Map<String, Object> map =  new HashMap<String, Object>();
		//데이터를 가져와서 map에 출력
		List<User> list = (List<User>) request.getAttribute("list");
		System.out.println("컨트롤러 list"+list);
		map.put("list", list);
		//결과 리턴
		return map;
	}
	
	//회원 리스트를 보는 메소
	@RequestMapping(value = "user/detail", method = RequestMethod.GET)
	public Map<String, Object> detail(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("rest컨트롤러 ");
		//서비스의 메소드를 호출
		userService.detail(request, response);
		
		User user = (User) request.getAttribute("user");
		System.out.println("컨트롤러 "+user);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("user", user);

		//결과 리턴
		return map;
	}
	//로그인 
	@RequestMapping(value="user/login", method=RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> result = userService.login(request, response);
		return result;
	}
	
	
}
