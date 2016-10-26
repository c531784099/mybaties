package com.bjsxt.dao.imp;



import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.dao.UsersDao;
import com.bjsxt.entity.User;

public class UsersDaoImp implements UsersDao {

	@Override
	public void addUsers(User user) {
		SqlSessionFactory ssf=null;
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
//		���������ļ�  �����Ự����
		ssf=ssfb.build(UsersDaoImp.class.getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));
//		��һ���Ự
		SqlSession  session=ssf.openSession();
		
		session.insert("user.addUsers",user);
		
		session.commit();
		
		session.close();
		
		
		
		
		
		

	}

	@Override
	public void delUsers(Integer uid) {
		

	}

}
