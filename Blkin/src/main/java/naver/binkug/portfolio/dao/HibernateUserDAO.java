package naver.binkug.portfolio.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.binkug.portfolio.domain.User;

@Repository
public class HibernateUserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//email 중복 검사를 위한 메소드
	public List<String> emailcheck(){
		List<String> list = (List<String>) sessionFactory.getCurrentSession().createNativeQuery("select user_email from member").getResultList();
		return list;
	}
	
	public List<User>loginCheck(){
		List<User> list = (List<User>) sessionFactory.getCurrentSession().createNativeQuery("select user_email,user_password from member").getResultList();
		return list;
	}
	
	//회원가입을 위한 메소드
	public void register(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
	//로그인을 위한 메소드
	//eamil과 password를 가지고 로그인
	public List<User> login(String user_email){
		List<User> list = sessionFactory.getCurrentSession().createNativeQuery("select * from member "
				+ " where user_email = \'"+user_email+"\'",User.class).getResultList();
		
		return list;
	}
	
	//회원 정보를 수정하는 메소드
	public void update(User user) {
		//다른 sql작업과 혼합이 되는 경우 한꺼번에 수행할 때는 update 대신에 merge를 사용하며  없으면 저장하고 있으면 수정하고 싶을 때는 saveOrUpdate
		sessionFactory.getCurrentSession().merge(user);
	}
	
	//회원정보를 삭제하는 메소드
	public void delete(User user) {
		//이전에 수행 중인 내용을 전부 삭제하고 작업을 수행 
		sessionFactory.getCurrentSession().clear();
		sessionFactory.getCurrentSession().delete(user);
	}
}
