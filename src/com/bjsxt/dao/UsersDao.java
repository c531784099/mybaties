package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Dept;
import com.bjsxt.entity.User;
import com.bjsxt.entity.UsersVo;

public interface UsersDao {
	public void addUsers(User user);
	public void delUsers(Integer uid);
	public User slectById(Integer uid);
//	���Է��ؽ���Ǽ��ϵ����ݳ���
	public List<User> selectUser(User user);
//	���Լ̳г�����
	public List<UsersVo> selectUD();
//	����  һ��һ �Ĺ�������
	public List<User> selectUserDept();
	
//	���� һ�Զ�Ĳ���
	
	public  Dept selectDept(Integer id);

}
