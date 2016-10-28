package com.bjsxt.mtm;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestMTM {
	
	@Test
	public void Test1(){
		SqlSessionFactory ssf=null;
		SqlSessionFactoryBuilder ssbf=new SqlSessionFactoryBuilder();
		ssf=ssbf.build(this.getClass().getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));		
		SqlSession session=ssf.openSession();		
		UserDao ud=session.getMapper(UserDao.class);
		
		List<Dept> list=ud.selectByDept();
//		遍历输出数据
		for (int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i).getDname()+":");
			List<User> listu=list.get(i).getUlist();
			for (int j = 0; j < listu.size(); j++) {
				System.out.println("=="+listu.get(j).getUname()+"::");
				List<Post> plist=listu.get(j).getPlist();
//				这里是通过关联对象获得数据  和双向关联差不多
//				Dept dept=listu.get(j).getDept();
//				System.out.println(dept.getDname());
				for (int j2 = 0; j2 < plist.size(); j2++) {
					System.out.println("===="+plist.get(j2).getPname());
					
				}
				
			}
			
			
		}
		
		
		session.commit();
		session.close();
		
		
	}

}
