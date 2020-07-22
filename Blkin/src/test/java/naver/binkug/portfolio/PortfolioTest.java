package naver.binkug.portfolio;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import naver.binkug.portfolio.domain.User;

//Spring에서 JUnit4 라이브러리를 사용하기 위한 설정
@RunWith(SpringJUnit4ClassRunner.class)
//locations에 설정된 파일들을 실행시켜서 메모리에 로드하기 위한 설정
//프레임워크마다 설정 파일의 경로가 다르므로 web.xml 에 설정된 내용을 확인하고 작성
@WebAppConfiguration
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class PortfolioTest {
	//데이터베이스 연결을 확인할 때 주입
	@Autowired
	private DataSource dataSource;
	
	//연결 테스트를 위한 메소드
	@Test
	public void connectTest() {
		try {
			System.out.println(dataSource.getConnection());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	@Autowired
	private SqlSession sqlSession;
	
//	@Test
//	public void sqlTest() {
//		//email 중복 검사
//		//존재하는 이메일이면 값이 출력
//		System.out.println(sqlSession.selectOne("user.emailcheck","binkug@naver.com"));
//		//존재하지 않는 이메일로 검사
//		System.out.println(sqlSession.selectOne("user.emailcheck","binkug1@naver.com"));
//		
//		//데이터 삽입 확인
//		User user = new User();
//		user.setUser_email("ggangpae2@gmail.com");
//		user.setUser_password("1234");
//		user.setUser_name("관리자");
//		user.setUser_image("sample.png");
//			
//		//삽입 삭제 갱신은 정수를 리턴하는데 리턴되는 값은 영향받은 행의 개수
//		System.out.println(sqlSession.insert("user.register", user));
//	}
	
}