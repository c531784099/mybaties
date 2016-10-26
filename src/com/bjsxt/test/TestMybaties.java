package com.bjsxt.test;

import org.junit.Test;

import com.bjsxt.dao.imp.UsersDaoImp;
import com.bjsxt.entity.User;

public class TestMybaties {
	
	@Test
	public void Test1(){
		UsersDaoImp ud=new UsersDaoImp();
		
		User u1=new User();
		u1.setUage(34);
		u1.setUname("cheng");
		
		ud.addUsers(u1);
		
		
	}

}
