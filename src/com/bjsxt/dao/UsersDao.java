package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.User;

public interface UsersDao {
	public void addUsers(User user);
	public void delUsers(Integer uid);
	public User slectById(Integer uid);
	public List<User> selectUser(User user);

}
