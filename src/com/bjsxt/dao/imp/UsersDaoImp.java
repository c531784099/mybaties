package com.bjsxt.dao.imp;

/**
 * ����������ͨ��  ʵ�����������   api��ʵ�ֲ������ݿ⡣ͬʱʹ��  xml�����sql������Ϣ��
 * �ڶ��ַ�ʽ�ǣ�
 * 
 * 
 * */

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bjsxt.dao.UsersDao;
import com.bjsxt.entity.Dept;
import com.bjsxt.entity.User;
import com.bjsxt.entity.UsersVo;


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
	public void delUsers(Integer uid1) {
		SqlSessionFactory ssf=null;
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		ssf=ssfb.build(this.getClass().getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));
		
		SqlSession session=ssf.openSession();
		
		session.delete("user.delUsers",uid1);
		
		session.commit();
		session.close();
		

	}
// ��ѯ��������
	@Override
	public User slectById(Integer uid) {
		SqlSessionFactory ssf=null;
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		ssf=ssfb.build(this.getClass().getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));
		
		SqlSession session=ssf.openSession();
//		���Ĵ���
		User u1=(User) session.selectOne("user.slectById", uid);
		
		session.commit();
		session.close();
				
		
		
		return u1;
	}

	@Override
	public List<User> selectUser(User user) {
		SqlSessionFactory ssf=null;
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
//		�����˹���
		ssf=ssfb.build(this.getClass().getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));
//		�򿪻Ự
		SqlSession session=ssf.openSession();
//		������Ǹ��ݶ���õ�preparedstatement�Ķ���execute������ʹ�õ�װ��ģʽ������װ����ֵ��
		List<User> list=session.selectList("user.selectUser", user);
//		PreparedStatement
		session.commit();
		session.close();		
		return list;
	}

	@Override
	public List<UsersVo> selectUD() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectUserDept() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dept selectDept(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
