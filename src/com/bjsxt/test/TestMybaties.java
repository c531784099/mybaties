package com.bjsxt.test;

import java.util.List;

import org.junit.Test;

import com.bjsxt.dao.imp.UsersDaoImp;
import com.bjsxt.entity.User;

public class TestMybaties {
//	�������
	@Test
	public void Test1(){
		UsersDaoImp ud=new UsersDaoImp();
		
		User u1=new User();
//		u1.setUage(34);
		u1.setUname("cheng");
		
		ud.addUsers(u1);
		
		
	}
	
//	ɾ������
	
	@Test
	public void Test2(){
		UsersDaoImp ud=new UsersDaoImp();
		
		ud.delUsers(1);
		
	}
//	��ѯ����

	@Test
	public void Test3(){
		UsersDaoImp ud=new UsersDaoImp();
		
		User u1=ud.slectById(8);
		
//		System.out.println(u1.getUname()+"=="+u1.getUage());
		
	}
	
//	���ݵ�������ѯ
	
	@Test
	public void Test4(){
		User user=new User();
		
		user.setUname("cheng");
		
		UsersDaoImp ud=new UsersDaoImp();
		
		List<User> list=ud.selectUser(user);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getUid());
		}
		
		
	}
	

}
