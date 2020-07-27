package naver.binkug.portfolio.service;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import naver.binkug.portfolio.dao.ActivityDAO;
import naver.binkug.portfolio.domain.Activity;
import naver.binkug.portfolio.domain.User;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	private ActivityDAO activityDao ;
	
	
	@Override
	@Transactional
	public void list(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String searchtype = request.getParameter("searchtype");
		String value = request.getParameter("value");
		String pageno = request.getParameter("pageno");
		
		//작업을 수행
		
		//한 페이지에 보여질 데이터 개수
		int size = 3;
		//시작 위치 번호 계산
		//MySQL은 데이터 번호가 0부터 시작합니다.
		int start = 0;
		if(pageno != null) {
			start = (Integer.parseInt(pageno)-1) * size;
		}
		//dao 메소드의 파라미터를 만들기 
		Map<String,Object> map = new HashedMap<String,Object>();
		map.put("searchtype", searchtype);
		map.put("value", value);
		map.put("start", start);
		map.put("size", size);
		
		//dao 메소드를 호출해서 결과 저장 
		List<User> list = activityDao.list(map);
		request.setAttribute("list", list);
		int count = activityDao.count(map).intValue();
		request.setAttribute("count", count);
		
	}

	@Override
	@Transactional
	public void detail(HttpServletRequest request, HttpServletResponse response) {
		String activity_num = request.getParameter("activity_num");
		Activity activity = activityDao.detail(Integer.parseInt(activity_num));
		request.setAttribute("activity", activity);
		

	}

	@Override
	@Transactional
	public void insert(MultipartHttpServletRequest request, HttpServletResponse response) {
		//activity_num,user_email,activity_subject,activity_type,activity_start_date_local
		int activity_num = 1;
		//데이터 개수 가져오기 
		int count = activityDao.count(new HashMap<String, Object>()).intValue();
		//데이터가 존재하면 가장 큰 activity_num의 값에 +1
		if(count !=0) {
			activity_num = activityDao.maxnum() + 1;
		}
		String user_email = request.getParameter("user_email");
		String activity_subject = request.getParameter("activity_subject");
		String activity_type = request.getParameter("activity_type");
		String activity_content = request.getParameter("activity_content");

		
		//파일의 기본 값을 설정
		String activity_image = "default.jpg";
		//파일 파라미터 가져오기
		MultipartFile image = request.getFile("activity_image");
		//전송 된 파일이 존재하면
		if(image != null && image.isEmpty() == false) {
			//파일을 저장할 데릭토리 경로 가져오기
			String filePath = request.getRealPath("/img");
			//새로운 파일명 만들기
			activity_image = UUID.randomUUID() + image.getOriginalFilename();
			//실제 경로 만들기 
			filePath = filePath + "/" + activity_image;
			try {
				//파일을 기록할 출력 스트림 생성 
				FileOutputStream fos = new FileOutputStream(filePath);
				//파일 업로드 
				fos.write(image.getBytes());
				fos.close();
			} catch (Exception e) {
				System.out.println("파일 저장 예외: "+e.getMessage());
			}
			
			Activity activity = new Activity();
			activity.setActivity_num(activity_num);
			activity.setActivity_subject(activity_subject);
			activity.setActivity_content(activity_content);
			activity.setActivity_image(activity_image);
			activity.setActivity_type(activity_type);
			activity.setUser_email(user_email);
			
			activityDao.insert(activity);
			request.setAttribute("insert", true);
		}
	}

}
