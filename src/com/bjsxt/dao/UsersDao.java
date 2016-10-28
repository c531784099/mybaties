package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Dept;
import com.bjsxt.entity.User;
import com.bjsxt.entity.UsersVo;

public interface UsersDao {
	public void addUsers(User user);
	public void delUsers(Integer uid);
	public User slectById(Integer uid);
//	测试返回结果是集合的数据承载
	public List<User> selectUser(User user);
//	测试继承承载类
	public List<UsersVo> selectUD();
//	测试  一对一 的关联加载
	public List<User> selectUserDept();
	
//	测试 一对多的测试
	
	public  Dept selectDept(Integer id);

}
