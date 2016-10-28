package com.bjsxt.wheresql;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestUser1 {
//	���Զ�̬sql��ʹ�� ͨ���Ѿ���õ�����  �ṩ�� �����ļ���  ���ҵ����ʵ����˼�벻̫�á�ҵ����ӻ����ˡ�
	@Test
	public void Test1(){
		
		SqlSessionFactory ssf=null;
		SqlSessionFactoryBuilder ssbf=new SqlSessionFactoryBuilder();
		ssf=ssbf.build(this.getClass().getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));		
		SqlSession session=ssf.openSession();	
		
		UserDao ud=session.getMapper(UserDao.class);
		
		List<User> ulist=ud.selectBy();
		
		for (int i = 0; i <ulist.size(); i++) {
			System.out.println(ulist.get(i).getUname());
			
		}
		
		session.commit();
		session.close();
		
		
		
	}

}
