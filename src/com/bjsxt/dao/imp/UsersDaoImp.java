package com.bjsxt.dao.imp;

/**
 * 这里是我们通过  实现类逐个调用   api来实现操作数据库。同时使用  xml来获得sql语句的信息。
 * 第二种方式是：
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
//		加载配置文件  产生会话对象
		ssf=ssfb.build(UsersDaoImp.class.getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));
//		打开一个会话
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
// 查询单个对象
	@Override
	public User slectById(Integer uid) {
		SqlSessionFactory ssf=null;
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		ssf=ssfb.build(this.getClass().getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));
		
		SqlSession session=ssf.openSession();
//		核心代码
		User u1=(User) session.selectOne("user.slectById", uid);
		
		session.commit();
		session.close();
				
		
		
		return u1;
	}

	@Override
	public List<User> selectUser(User user) {
		SqlSessionFactory ssf=null;
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
//		创建了工厂
		ssf=ssfb.build(this.getClass().getClassLoader().getResourceAsStream("SqlConfigMapper.xml"));
//		打开会话
		SqlSession session=ssf.openSession();
//		这里就是根据定义好的preparedstatement的对象、execute方法、使用的装饰模式、并封装返回值。
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
