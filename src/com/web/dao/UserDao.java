package com.web.dao;


import com.web.entity.User;
import com.web.util.Page;

public interface UserDao {

	/**
	 * 通过用户名加载一个用户对象（登录）
	 * @param userName 用户输入的帐号
	 * @return 返回null表示用户的帐号不存在 
	 */
	public User loadUserByName(String userName);
	
	/**
	 * 通过主键加载一个用户对象（登录）
	 * @param uid 用户主键
	 * @return  
	 */
	public User loadUserById(int uid);
	
	/**
	 * 加载所有用户
	 * @return
	 */
	public Page<User> loadAllUsers(int pageNo, int pageSize);
	
	/**
	 * 删除用户
	 * @param uid
	 */
	public void deleteUser(int uid);
	
	
}
