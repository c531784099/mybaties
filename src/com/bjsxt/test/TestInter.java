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
//  ͨ��  �ӿ� ��ʹ��  sql��䡣	
	@Test
	public void Test1(){
		SqlSessionFactory ssf=null;
		SqlSessionFactoryBuilder ssbf=new SqlSessionFactoryBuilder();
		ssf=ssbf.build(this.getClass().getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));
		
		SqlSession session=ssf.openSession();
//		���ĳ���ӿڵĴ������
		UsersDao ud=session.getMapper(UsersDao.class);
//		׼������
		User u1=new User();
//		u1.setUage(99);
		u1.setUname("feng");
//		���ô��������ǿ��ķ�����
		ud.addUsers(u1);
		
        session.commit();
        session.close();
		
	}
	
//	ͨ�� ��֮��ļ̳� ʵ�����ݵķ�װ���ء�
//	����ӿ� ���� �������̡�
	
	@Test
	public void Test2(){
		SqlSessionFactory ssf=null;
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		ssf=ssfb.build(this.getClass().getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));
		SqlSession  ss=ssf.openSession();
		
		UsersDao ud=ss.getMapper(UsersDao.class);
//		ִ��
		List<UsersVo> list=ud.selectUD();
		for (int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i).getDname()+"   [   ]"+list.get(i).getUname());
		}
		
		
		ss.commit();
		ss.close();
		
		
		
	}
	
	
//	����һ��һ�Ĺ������ء�
	
	@Test
	public void Test3(){
		SqlSessionFactory ssf=null;
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		ssf=ssfb.build(this.getClass().getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));
		SqlSession  ss=ssf.openSession();
		
		UsersDao ud=ss.getMapper(UsersDao.class);
		
		List<User> list=ud.selectUserDept();
		
//		�������
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getUname()+"[   ]"+list.get(i).getDept().getDname());
		}
		
		
		ss.commit();
		ss.close();
		
	}

}
