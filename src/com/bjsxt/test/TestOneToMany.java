package com.bjsxt.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.bjsxt.dao.UsersDao;
import com.bjsxt.entity.Dept;

public class TestOneToMany {
	
	
	@Test
	public void Test1(){
		SqlSessionFactory ssf=null;
		SqlSessionFactoryBuilder ssbf=new SqlSessionFactoryBuilder();
		ssf=ssbf.build(this.getClass().getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));
		
		SqlSession session=ssf.openSession();
		
		UsersDao ud=session.getMapper(UsersDao.class);
		
		Dept dept=ud.selectDept(2);
		
		System.out.println(dept.getDname());
		
		for (int i = 0; i < dept.getUlist().size(); i++) {
			System.out.println(dept.getUlist().get(i).getUname());
		}
	
		session.commit();
		session.close();
		
	}

}
