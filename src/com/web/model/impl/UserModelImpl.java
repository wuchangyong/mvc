package com.web.model.impl;

import java.util.List;

import com.web.dao.UserDao;
import com.web.dao.impl.UserDaoImpl;
import com.web.entity.Dept;
import com.web.entity.Job;
import com.web.entity.Menu;
import com.web.entity.Role;
import com.web.entity.User;
import com.web.model.UserModel;
import com.web.util.Page;
import com.web.vo.EmployeeVo;
import com.web.vo.MenuVo;

public class UserModelImpl implements UserModel{

	//模型层持有一个DAO层对象
	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * 通过用户名加载一个用户对象（登录）
	 * @param userName 用户输入的帐号
	 * @return 返回null表示用户的帐号不存在 
	 */
	public User loadUserByName(String userName){
		return userDao.loadUserByName(userName);
	}
	
	/**
	 * 通过主键加载一个用户对象（登录）
	 * @param uid 用户主键
	 * @return  
	 */
	public User loadUserByName(int uid){
		return userDao.loadUserByName(uid);
	}
	
	/**
	 * 加载所有用户
	 * @return
	 */
	public Page<User> loadAllUsers(int pageNo,int pageSize){
		return userDao.loadAllUsers(pageNo,pageSize);
	}
	
	/**
	 * 删除用户
	 * @param uid
	 */
	public void deleteUser(int uid){
		userDao.deleteUser(uid);
	}
	
	/**
	 * 通过帐号主键Id加载此用户拥有的菜单集合
	 * @param uid
	 * @return
	 */
	public List<Menu> loadMenusByUid(int uid){
		return userDao.loadMenusByUid(uid);
	}
	
	/**
	 * 加载所有菜单
	 * @return
	 */
	public Page<MenuVo> loadAllMenus(int pageNo, int pageSize){
		return userDao.loadAllMenus(pageNo, pageSize);
	}
	
	/**
	 * 加载所有一级和二级菜单
	 * @return
	 */
	public List<Menu> load12Menus(){
		return userDao.load12Menus();
	}
	
	/**
	 * 添加菜单
	 * @param name 菜单名称
	 * @param url  菜单地址
	 * @param isshow 是否在欢迎界面展示
	 * @param parentid 父级菜单ID
	 * @return 返回1表示添加成功 返回2表示父级菜单不存在
	 */
	public int addMenu(String name,String url,int isshow,int parentid){
		Menu m = userDao.loadMenuById(parentid);
		if(null != m){
			userDao.addMenu(name, url, isshow, m.getLevel()+1, parentid);
			return 1;
		}else{
			return 2;
		}
	}
	
	/**
	 * 加载所有角色
	 * @return
	 */
	public List<Role> loadAllRoles(){
		return userDao.loadAllRoles();
	}
	
	/**
	 * 通过角色id查询角色菜单
	 * @param rid
	 * @return
	 */
	public List<Object[]> loadRoleMenuByRoleId(int rid){
		return userDao.loadRoleMenuByRoleId(rid);
	}
	
	/**
	 * 通过角色id加载角色对象
	 * @param rid
	 * @return
	 */
	public Role loadRoleById(int rid){
		return userDao.loadRoleById(rid);
	}
	
	/**
	 * 编辑角色权限
	 * @param rid
	 * @param mids
	 */
	public void editRoleMenu(int rid, String[] mids){
		userDao.editRoleMenu(rid, mids);
	}
	
	/**
	 * 检查uid这个用户是否拥有uri这个菜单权限
	 * @param uid
	 * @param uri
	 * @return 返回true表示有权限 返回false表示无权限
	 */
	public boolean checkUserMenu(int uid, String uri){
		return userDao.checkUserMenu(uid, uri);
	}
	
	/**
	 * 分页查询员工列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page<EmployeeVo> loadEmployeeByPage(int pageNo, int pageSize, String searchName,String searchJob,String searchDept){
		return userDao.loadEmployeeByPage(pageNo, pageSize, searchName, searchJob, searchDept);
	}
	
	/**
	 * 加载所有职位
	 * @return
	 */
	public List<Job> loadAllJob(){
		return userDao.loadAllJob();
	}
	
	/**
	 * 加载所有部门
	 * @return
	 */
	public List<Dept> loadAllDept(){
		return userDao.loadAllDept();
	}
	
}
