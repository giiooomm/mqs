package mq;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.user.model.User;
@RunWith(SpringJUnit4ClassRunner.class)
public class mybatisTest {
	@Test
	public void testMybatis() throws IOException{
		String resource = "spring-mybatis.xml"; 
		//加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource); 
		//构建sqlSession的工厂
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();
		//映射sql的标识字符串,是在影射文件中找到namespace+“”+select中的id
		String statement="com.atguigu.day03_mybaits.userMapper.getUser";
		//执行查询返回一个唯一user对象的sql
		User user=session.selectOne(statement, 2);
		System.out.println(user);

	}
}
