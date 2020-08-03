package naver.binkug.portfolio.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.binkug.portfolio.domain.Activity;
import naver.binkug.portfolio.domain.User;

@Repository
public class ActivityDAO {
	//@Autowired
	//MyBatis를 xml로 이용할 때 사용하는 클래스
	//private SqlSession sqlSession;
	
	//Hibernate는 세션 팩토리
	@Autowired
	private SessionFactory sessionFactory;
	//검색 항목과 검색어 그리고 페이지 번호를 이용해서 해당하는 
	//데이터를 목록으로 리턴하는 메소드
	//페이징을 할 때 오라클은 시작 번호와 종료 번호를 알아야 하지만 
	//Mysql은 시작 번호와 데이터 개수를 알아야 한다.
	//오라클은 1부터 시작하지만 MySQL은 0부터 시작.
	//검색 항목과 검색어 그리고 시작 번호 페이지당 데이터 개수를 하나의 Map으로 묶어서 사용
	public List<User> list (Map<String,Object> map){
		//결과를 저장할 list
		List<User> list = new ArrayList<User>();
		
		//검색 항목 -searchtype , 검색어 -value	
		//시작 번호 - start 페이지당 데이터 개수 - size
		//파라미터 읽기 - ServiceImpl에서 만들어서 넘겨줘야 한다.
		String searchtype = (String) map.get("searchtype");
		String value = (String) map.get("value");
		int start = (Integer) map.get("start");
		int size = (Integer)map.get("size");
		

		if(value != null) {
			//like 검색을 하기 위해서 % 사용 
			//대소문자 구분하지 않고 검색하기 위해서 toLowerCase 사용 
			value = "%" + value.toLowerCase() + "%";
		}
		
		
		//검색 항목이 없는 경우 
		//activity_subject에서 검색 , user_email 검색
		//둘 다 검색
		if(searchtype == null) {
			//오류를 없애기 위해서 각각의 필요한 컬럼들을 써줘야 한다. 
			list = sessionFactory.getCurrentSession().createNativeQuery("select * from member m ,activity a where m.user_email = a.user_email limit " 
					+ start + "," + size ).getResultList();

		}else if(searchtype.equals("activity_subject")) {
			list = sessionFactory.getCurrentSession().createNativeQuery("select * from activity where lower(activity_subject) like \'"+value+"\' limit "
					+ start + ","+size ).getResultList();
		}else if(searchtype.equals("user_email")) {
			list = sessionFactory.getCurrentSession().createNativeQuery("select * from activity where lower(user_email) like \'"+value+"\' limit "
					+ start + ","+size ).getResultList();
		}else if(searchtype.equals("both")) {
			list = sessionFactory.getCurrentSession().createNativeQuery("select * from activity where lower(user_email) like \'"+value+" \'"
					+ "or lower(activity_subject) like \'"+value+ " \' limit "+ start + ","+size ).getResultList();
		}
		
		return list;
		
	}
	
	//검색 결과의 데이터 개수를 리턴하는 메소드
	//하이버네이트에서는 정수를 리턴할 때는 BingInteger로 리턴 됩니다.
	public BigInteger count(Map<String,Object> map) {
		//파라미터 읽기 - serviceImpl에서 만들어서 넘겨주어야 합니다.
		String searchtype = (String) map.get("searchtype");
		String value = (String) map.get("value");
		
		List<BigInteger> list = null;
		if(value != null) {
			//대소문자 구분하지 않고 검색하기 위해서 toLowerCase 사용 
			value = "%"+ value.toLowerCase()+"%";
		}
		
		if(searchtype == null) {
			list = sessionFactory.getCurrentSession().createNativeQuery("select count(*) from activity").getResultList();
		}else if(searchtype.equals("activity_subject")) {
			list = sessionFactory.getCurrentSession().createNativeQuery("select count(*) from activity " + 
					"where lower(activity_subject) like \'" + 
					value + "\'")
						.getResultList();
			
		}else if(searchtype.equals("both")) {
			list = sessionFactory.getCurrentSession()
					.createNativeQuery(
							"select count(*) from activity " + 	"where lower(activity_subject) like \'" + value + "\'" + " or lower(user_email) like \'" +
							value + "\'")
								.getResultList();
			}
			return list.get(0);

	}
	
	//activity_num를 가지고 데이터 1개를 찾아오는 메소드 
	public Activity detail(int activity_num) {
		Activity activity = sessionFactory.getCurrentSession().get(Activity.class, activity_num);
		return activity;
	}
	
	//가장 큰 activity_num을 찾아오는 메소드 
	public int maxnum() {
		List<Integer> list = sessionFactory.getCurrentSession().createNativeQuery("select max(activity_num) from activity").getResultList();
		return list.get(0);
		
	}
	
	//데이터를 삽입하는 메소드
	public void insert(Activity activity) {
		sessionFactory.getCurrentSession().save(activity);
	}
	
}
