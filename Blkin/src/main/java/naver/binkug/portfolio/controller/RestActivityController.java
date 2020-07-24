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

import naver.binkug.portfolio.domain.Activity;
import naver.binkug.portfolio.service.ActivityService;

@RestController
public class RestActivityController {
	@Autowired
	private ActivityService activityService;
	
	//검색해서 데이터를 전송하는 요청을 생성
	@RequestMapping(value = "activity/list")
	public Map<String, Object> list(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("rest컨트롤러 ");
		//서비스의 메소드를 호출
		activityService.list(request, response);
		List<Activity> list =(List<Activity>) request.getAttribute("list");
		int count = (Integer) request.getAttribute("count");
		//결과 리턴
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("list", list);
		return map;
	}
	
	@RequestMapping(value = "activity/detail")
	public Map<String, Object> detail(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("rest컨트롤러 ");
		//서비스의 메소드를 호출
		activityService.detail(request, response);
		Activity activity = (Activity) request.getAttribute("activity");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("activity", activity);
		
		return map;
	}
	
	@RequestMapping(value = "activity/insert",method = RequestMethod.POST)
	public Map<String, Object> insert(MultipartHttpServletRequest request,HttpServletResponse response) {
		System.out.println("rest컨트롤러 ");
		//서비스의 메소드를 호출
		activityService.insert(request, response);
		Boolean result = (Boolean) request.getAttribute("insert");
		Map<String, Object> map = new HashMap<String, Object>();
		if(result != null) {
			map.put("insert", result);
		}else {
			map.put("insert", false);
		}
		
		return map;
	}
}
