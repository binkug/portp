package naver.binkug.portfolio.service;

import java.io.File;
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

import naver.binkug.portfolio.dao.UserDAO;
import naver.binkug.portfolio.domain.User;
import naver.binkug.portfolio.util.CryptoUtil;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDao;

	@Override
	public Map<String, Object> insert(MultipartHttpServletRequest request, HttpServletResponse response) {
		//결과를 저장할 객체를 생성
		Map<String,Object> map = new HashMap<String, Object>();
		//성공과 실패 여부를 확인할 데이터 생성
		map.put("result", false);
		//실패했을 때 실패 이유를 저장하기 위한 데이터 생성
		map.put("emailcheck", false);
		
		//파라미터 읽기
		String userEmail = request.getParameter("user_email");
		String userPassword = request.getParameter("user_password");
		String userName = request.getParameter("user_name");
		String userGender = request.getParameter("user_gender");
		//파일은 읽는 방법이 다름
		MultipartFile userImage = request.getFile("user_image");
		
		//email 중복검사 실행
		String emailResult = null;

		//암호화 되어 있기 때문에 전체 이메일을 가져와서
		//복호화 하면서 비교
		List<String> emailList = userDao.emailCheck();
		try {
			for (String imsi : emailList) {
				if (CryptoUtil.decryptAES256(
					imsi, "binkug").equals(userEmail)) {
					emailResult = userEmail;
					break;
				}
			}
		} catch (Exception e) {}
		
		if(userEmail == null) {
			map.put("emailcheck", true);
		}
		//email 중복검사를 통과한 경우에만 데이터 삽입
		if(emailResult == null) {
			//그림 파일의 기본 이름 설정
			String image = "default.jsp";
			//파일을 선택한 경우에만 파일을 서버에 복사
			if(userImage.isEmpty() == false) {
				//저장할 디렉토리 경로를 생성
				//webapp 까지가 /이다.
				String uploadPath = request.getServletContext().getRealPath("/profile");
				//파일 이름을 랜덤하게 설정 이렇게 설정하면 파일 이름이 중복될 가능성은 거의 없다.
				image = UUID.randomUUID() + userImage.getOriginalFilename();
				
				//실제 저장될 경로 만들기
				uploadPath = uploadPath + "/"+image;
				//File 객체 생성
				File file = new File(uploadPath);
				
				FileOutputStream fos = null;
				try {
					//userimage의 내용을 file에 복사
					fos = new FileOutputStream(file);
					fos.write(userImage.getBytes());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			//공개키 암호화에 사용할 키를 생성
			String key = "binkug";
			
			//저장할 데이터 생성
			User user = new User();
			try {
				//email 암호화 해서 저장
				user.setUser_email(CryptoUtil.encryptAES256(userEmail, key));
				user.setUser_password(BCrypt.hashpw(userPassword, BCrypt.gensalt()));
				user.setUser_name(userName);
				user.setUser_gender(userGender);
				user.setUser_image(image);
				
				//데이터베이스에 저장
				int row = userDao.register(user);
				//저장에 성공하면 map의 result에 true에 저장
				if(row > 0) {
					map.put("result", true);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return map;
	}

	@Override
	public void list(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String pageno = request.getParameter("pageno");
		//페이지당 데이터 개수 
		int cnt = 2;
		//시작 번호와 끝나는 번호 생성 
		int start = Integer.parseInt(pageno)* cnt - (cnt-1);
		int end = start + cnt - 1;
		
		//DAO의 파라미터 만들기
		Map<String ,Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		//dao의 메소드를 실행하고 결과를 저
		List<User>list = userDao.list(map);
		request.setAttribute("list", list);
	}

	@Override
	public void detail(HttpServletRequest request, HttpServletResponse response) {
		String userEmail = request.getParameter("user_email");
		User user = userDao.detail(userEmail);
		request.setAttribute("user", user);
		
	}


}
