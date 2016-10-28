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
//		开启第一个session
		SqlSession session=ssf.openSession();
		
		UserDao ud=session.getMapper(UserDao.class);
		
		Dept dept=ud.selectBy(1);
		System.out.println(dept.getDname());
//		这里如果没有调用  方法获得user的数据  mybaties是不会自动去查的。
//		List<User> ulist=dept.getUlist();
//		for (int i = 0; i < ulist.size(); i++) {
//			System.out.println(ulist.get(i).getUname());
//		}
//		清空缓存
//		session.clearCache();
//		Dept dept1=ud.selectBy(1);
//		System.out.println(dept1.getDname());
//		关闭第一个session
		session.commit();
		session.close();
//		开启第二个 session
		SqlSession session2=ssf.openSession();
		UserDao ud1=session2.getMapper(UserDao.class);
		
		Dept dept2=ud1.selectBy(1);
		System.out.println(dept2.getDname());

		session2.commit();
//		关闭第二个session
		session2.close();
		
	}

}
