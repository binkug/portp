package naver.binkug.portfolio.dao;

import org.apache.ibatis.session.SqlSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ActivityDAO {
	@Autowired
	//MyBatis를 xml로 이용할 때 사용하는 클래스
	private SqlSession sqlSession;
	
	//Hibernate는 세션 팩토리
//	@Autowired
//	private SessionFactory sessionFactory;
}
