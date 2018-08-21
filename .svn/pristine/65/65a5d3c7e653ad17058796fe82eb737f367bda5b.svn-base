package mq;

import java.util.List;
import java.util.Map;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext; 
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.base.util.EntitytoString;
import com.user.dao.UserDao;
import com.user.model.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test2 {

	@Test 
	public void getList(){
/*		ApplicationContext ap = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		UserDao userDao = (UserDao) ap.getBean("userDao");*/
		UserDao userDao = getBean("userDao");
		List<Map<String, Object>> list = userDao.getList();
		
		@SuppressWarnings("unchecked")
		List<User> userList= EntitytoString.getEntitys(list, User.class);
		
		for(User u : userList){
			System.out.println(u);
		}
		
		
	}
	
	@Test
	public void insertTo(){
		UserDao userDao = getBean("userDao");
		//String sql = "insert into User(usercode,password,states) values(?,?,?)";
		userDao.insertTo(new Object[]{"giiooomm","ak47","1"});
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getBean(String beanName){
		@SuppressWarnings("resource")
		ApplicationContext ap = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		return (T) ap.getBean(beanName);
		
	}
	
	public void closeAp(ApplicationContext ap){
		((ClassPathXmlApplicationContext)ap).close();
	}
}
