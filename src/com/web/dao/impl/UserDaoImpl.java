package com.web.dao.impl;

import java.util.List;
import com.web.dao.UserDao;
import com.web.entity.User;
import com.web.util.Page;

public class UserDaoImpl extends BaseDao<User> implements UserDao{

	/**
	 * 通过用户名加载一个用户对象（登录）
	 * @param userName 用户输入的帐号
	 * @return 返回null表示用户的帐号不存在 
	 */
	public User loadUserByName(String userName){
		String hql = "select u from User u where u.userName=?";
		List<User> list = this.hqlQuery(hql, userName);
		User user = null;
		if(null != list && list.size() > 0){
			user = list.get(0);
		}
		return user;
	}
	
	/**
	 * 通过主键加载一个用户对象（登录）
	 * @param uid 用户主键
	 * @return  
	 */
	public User loadUserById(int uid){
		return this.get(uid);
	}

	/**
	 * 加载所有用户
	 */
	@Override
	public Page<User> loadAllUsers(int pageNo, int pageSize) {
		String hql = "from User";
		return hqlQuery(hql, pageNo, pageSize);
	}
	
	/**
	 * 删除用户
	 * @param uid
	 */
	public void deleteUser(int uid){
		User u = this.get(uid);
		this.delete(u);
	}
	
	
	
	
	
	
	
}
