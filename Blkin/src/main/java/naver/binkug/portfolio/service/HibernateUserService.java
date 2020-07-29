package naver.binkug.portfolio.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface HibernateUserService {
	
	//회원 가입을 메소드
	public void join(MultipartHttpServletRequest request);
	//로그인을 위한 메소드
	public void login(HttpServletRequest request);
	//회원정보 수정을 위한 메소드
	public void update(MultipartHttpServletRequest request);
	//회원탈퇴를 위한 메소드
	public void delete(HttpServletRequest request);
}
