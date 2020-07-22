package naver.binkug.portfolio.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.binkug.portfolio.domain.User;

@Repository
public class UserDAO {
	@Autowired
	private SqlSession sqlSession;
	
	
	//데이터 번호를 받아서 번호에 해당하는 데이터를 가져오는 메소드
	public List<User> list(Map map){
		return sqlSession.selectList("member.list");
		
	}
	public User detail(String user_email) {
		return sqlSession.selectOne("membe.detail",user_email);
	}
	
	//이메일 중복체크 메소드
	public List<String> emailCheck() {
		
		return sqlSession.selectList("member.emailcheck");
	}
	//회원가입 처리 메소드
	public int register(User user) {
		return sqlSession.insert("member.register",user);
	}
	
}
