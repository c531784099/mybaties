package com.bjsxt.dao;

import com.bjsxt.entity.User;

public interface UsersDao {
	public void addUsers(User user);
	public void delUsers(Integer uid);

}
