package naver.binkug.portfolio.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ActivityService {
	//검색어를 가지고 검색하는 메소드 
	public void list(HttpServletRequest request,HttpServletResponse response);
	//activity_num을 이용해서 하나의 데이터를 가져오는 메소드 
	public void detail(HttpServletRequest request,HttpServletResponse response);
	//데이터를 삽입하는 메소드 
	public void insert(MultipartHttpServletRequest request,HttpServletResponse response);
}
