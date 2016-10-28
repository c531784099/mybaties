package com.bjsxt.lazy;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class Test1 {
	
	@Test
	public void Test2(){
		SqlSessionFactory ssf=null;
		SqlSessionFactoryBuilder ssbf=new SqlSessionFactoryBuilder();
		ssf=ssbf.build(this.getClass().getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));
//		������һ��session
		SqlSession session=ssf.openSession();
		
		UserDao ud=session.getMapper(UserDao.class);
		
		Dept dept=ud.selectBy(1);
		System.out.println(dept.getDname());
//		�������û�е���  �������user������  mybaties�ǲ����Զ�ȥ��ġ�
//		List<User> ulist=dept.getUlist();
//		for (int i = 0; i < ulist.size(); i++) {
//			System.out.println(ulist.get(i).getUname());
//		}
//		��ջ���
//		session.clearCache();
//		Dept dept1=ud.selectBy(1);
//		System.out.println(dept1.getDname());
//		�رյ�һ��session
		session.commit();
		session.close();
//		�����ڶ��� session
		SqlSession session2=ssf.openSession();
		UserDao ud1=session2.getMapper(UserDao.class);
		
		Dept dept2=ud1.selectBy(1);
		System.out.println(dept2.getDname());

		session2.commit();
//		�رյڶ���session
		session2.close();
		
	}

}
