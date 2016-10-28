package com.bjsxt.test;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.bjsxt.dao.UsersDao;
import com.bjsxt.entity.User;
import com.bjsxt.entity.UsersVo;

public class TestInter {
//  通过  接口 来使用  sql语句。	
	@Test
	public void Test1(){
		SqlSessionFactory ssf=null;
		SqlSessionFactoryBuilder ssbf=new SqlSessionFactoryBuilder();
		ssf=ssbf.build(this.getClass().getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));
		
		SqlSession session=ssf.openSession();
//		获得某个接口的代理对象
		UsersDao ud=session.getMapper(UsersDao.class);
//		准备数据
		User u1=new User();
//		u1.setUage(99);
		u1.setUname("feng");
//		调用代理对象增强后的方法。
		ud.addUsers(u1);
		
        session.commit();
        session.close();
		
	}
	
//	通过 类之间的继承 实现数据的封装承载。
//	定义接口 就是 面向反射编程。
	
	@Test
	public void Test2(){
		SqlSessionFactory ssf=null;
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		ssf=ssfb.build(this.getClass().getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));
		SqlSession  ss=ssf.openSession();
		
		UsersDao ud=ss.getMapper(UsersDao.class);
//		执行
		List<UsersVo> list=ud.selectUD();
		for (int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i).getDname()+"   [   ]"+list.get(i).getUname());
		}
		
		
		ss.commit();
		ss.close();
		
		
		
	}
	
	
//	测试一对一的关联加载。
	
	@Test
	public void Test3(){
		SqlSessionFactory ssf=null;
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		ssf=ssfb.build(this.getClass().getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));
		SqlSession  ss=ssf.openSession();
		
		UsersDao ud=ss.getMapper(UsersDao.class);
		
		List<User> list=ud.selectUserDept();
		
//		输出数据
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getUname()+"[   ]"+list.get(i).getDept().getDname());
		}
		
		
		ss.commit();
		ss.close();
		
	}

}
