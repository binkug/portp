package naver.binkug.portfolio.service;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import naver.binkug.portfolio.dao.HibernateUserDAO;
import naver.binkug.portfolio.domain.User;
import naver.binkug.portfolio.util.CryptoUtil;

@Service
public class HibernateUserServiceImpl implements HibernateUserService {
	@Autowired
	private HibernateUserDAO hibernateUserDAO;

	// 하이버네이트는 트랜잭션을 사용하지 않으면 예외가 발생
	@Override
	@Transactional
	public void join(MultipartHttpServletRequest request) {
		// 파라미터 읽기
		String user_email = request.getParameter("user_email");
		String user_name = request.getParameter("user_name");
		String user_password = request.getParameter("user_password");
		MultipartFile user_image = request.getFile("user_image");
		String user_gender = request.getParameter("user_gender");

		System.out.println("user_email : " + user_email);
		System.out.println("user_gender : " + user_gender);

		// 결과를 저장할 Map을 생성
		Map<String, Object> map = new HashMap<String, Object>();
		// result는 회원가입 성공여부
		// emailcheck에는 이메일 중복 검사 통과 여부
		// nicknamecheck에는 닉네임 중복 검사 통과 여
		map.put("result", false);
		map.put("emailcheck", true);

		String key = "binkug";
		// email 중복 검사
		// 복호화가 가능한 암호화로 되어 있음
		List<String> emaillist = hibernateUserDAO.emailcheck();
		for (String temp : emaillist) {
			try {
				// 복호화 해서 비교
				if (CryptoUtil.decryptAES256(temp, key).equals(user_email)) {
					map.put("emailcheck", false);
					request.setAttribute("result", map);
					return;
				}
			} catch (Exception e) {
			}
		}

		// 파일 업로드
		String profile = "default.jpg";
		// 이미지가 존재하면 업로드
		if (user_image != null && user_image.isEmpty() == false) {
			// 업로드할 디렉토리 경로를 생성
			String filePath = request.getRealPath("/profile");
			// 파일이름 생성
			profile = UUID.randomUUID() + user_image.getOriginalFilename();
			// 업로드할 파일 경로를 생성
			filePath = filePath + "/" + profile;

			// 파일 업로드
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(filePath);
				fos.write(user_image.getBytes());
			} catch (Exception e) {
				System.out.println("파일 업로드 실패:" + e.getMessage());
			}
		}
		// Dao의 파라미터 만들기
		User user = new User();
		try {
			user.setUser_email(CryptoUtil.encryptAES256(user_email, key));
		} catch (Exception e) {
		}
		user.setUser_gender(user_gender);
		user.setUser_name(user_name);
		user.setUser_password(BCrypt.hashpw(user_password, BCrypt.gensalt()));
		user.setUser_image(profile);

		// 회원가입 메소드 호출
		hibernateUserDAO.register(user);
		map.put("result", true);
		request.setAttribute("result", map);
		// map에서 result가 회원가입 성공여부
		// emailcheck는 이메일 중복 검사 통과 여부
		// nicknamecheck는 닉네임 중복 검사 통과 여부

	}

//	@Override
//	@Transactional
//	public void login(HttpServletRequest request) {
//		//파라미터 읽기
//		String user_email = request.getParameter("user_email");
//		String user_password = request.getParameter("user_password");
//		//로그인 성공 여부를 저장 
//		Map<String, Object> map = 
//				new HashMap<String, Object>();
//		map.put("result", false);
//		System.out.println("user email "+user_email);
//		//user_email을 가지고 데이터를 찾아오기
//		List<User> list = hibernateUserDAO.login(user_email);
//		//user_email에 해당하는 데이터가 없다면 더이상 진행 할 필요가 없음 
//		if(list == null || list.size() < 1) {
//			request.setAttribute("result", map);
//			return;
//		}
//		
//		//찾아온 데이터와 비밀번호를 비교
//		for(User user : list) {
//			if(BCrypt.checkpw(user_password, user.getUser_password())) {
//				map.put("user_email", user_email);
//				
//				map.put("user_image", user.getUser_image());
//				try {
//					map.put("user_email",CryptoUtil.decryptAES256(user.getUser_email(),"binkug"));
//				}catch(Exception e) {}
//				map.put("result", true);
//				request.setAttribute("result", map);
//				return;
//			}
//		}
//
//	}
	@Override
	@Transactional
	public void login(HttpServletRequest request) {
		//파라미터 읽기
		String user_email = request.getParameter("user_email");
		String user_password = request.getParameter("user_password");
		System.out.println("user_email:" + user_email);
		System.out.println("user_password:" + user_password);
		//로그인 성공 여부를 저장 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", false);
		String emailResult = null;
		List<String> emailList = hibernateUserDAO.emailcheck();
		try {
			for (String imsi : emailList) {
				System.out.println(imsi);

				if (CryptoUtil.decryptAES256(imsi, "binkug").equals(user_email)) {
					user_email = imsi;

					break;

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<User> list = hibernateUserDAO.login(user_email);
		System.out.println("list:" + list);

		if(list == null || list.size() < 1) {
			request.setAttribute("result", map);
			return;
		}
		
		//찾아온 데이터와 비밀번호를 비교
		for(User user : list) {
			if(BCrypt.checkpw(user_password, user.getUser_password())) {
				map.put("user_name", user.getUser_name());
				map.put("user_image", user.getUser_image());
				try {
					map.put("email",CryptoUtil.decryptAES256(user.getUser_email(),"binkug"));
				}catch(Exception e) {}
				map.put("result", true);
				request.getSession().setAttribute("result", map);
				return;
			}
		}

	}

	@Override
	@Transactional
	// Hibernate는 기본키를 조건으로 해서 수정이나 삭제를 수행
	public void update(MultipartHttpServletRequest request) {
		// 필요한 파라미터 읽기
		String user_email = request.getParameter("user_email");
		String user_password = request.getParameter("user_password");
		String user_name = request.getParameter("user_name");
		// 이미지는 반드시 입력되는 항목이 아니라면
		// 이전값을 파라미터로 보내고 새로운 값이 null이 아니라면
		// 새로운 값으로 대체
		String profile = request.getParameter("oldprofile");
		// email 찾아오기
		List<User> list = hibernateUserDAO.login(user_email);
		String email = list.get(0).getUser_email();

		// 이미지 파일 업로드
		MultipartFile image = request.getFile("user_image");
		if (image != null && image.isEmpty() == false) {
			// 업로드할 파일 경로 생성
			String filePath = request.getRealPath("/profile");
			profile = UUID.randomUUID() + image.getOriginalFilename();
			filePath = filePath + "/" + profile;
			// 파일 업로드
			try {
				FileOutputStream fos = new FileOutputStream(filePath);
				fos.write(image.getBytes());
			} catch (Exception e) {
				System.out.println("파일 업로드 예외:" + e.getMessage());
			}

		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", false);

		// DAO 파라미터 만들기
		User user = new User();
		user.setUser_email(user_email);
		user.setUser_password(user_password);
		user.setUser_name(user_name);
		user.setUser_image(profile);

		hibernateUserDAO.update(user);

		map.put("result", true);

		request.setAttribute("result", map);

	}

	@Override
	@Transactional
	public void delete(HttpServletRequest request) {
		String user_email = request.getParameter("user_email");
		List<User> list = hibernateUserDAO.login(user_email);
		String email = list.get(0).getUser_email();

		User user = new User();
		user.setUser_email(user_email);

		Map<String, Object> map = new HashMap<>();
		map.put("result", false);
		hibernateUserDAO.delete(user);
		map.put("result", true);
		request.setAttribute("result", map);
	}

}
