package com.web.dao;

import java.util.List;

import com.web.entity.Dept;
import com.web.entity.Job;
import com.web.entity.Menu;
import com.web.entity.Role;
import com.web.entity.User;
import com.web.util.Page;
import com.web.vo.EmployeeVo;
import com.web.vo.MenuVo;

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
	public User loadUserByName(int uid);
	
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
	
	/**
	 * 通过帐号主键Id加载此用户拥有的菜单集合
	 * @param uid
	 * @return
	 */
	public List<Menu> loadMenusByUid(int uid);
	
	/**
	 * 加载所有菜单
	 * @return
	 */
	public Page<MenuVo> loadAllMenus(int pageNo, int pageSize);
	
	/**
	 * 加载所有一级和二级菜单
	 * @return
	 */
	public List<Menu> load12Menus();
	
	/**
	 * 通过主键id加载一个菜单对象
	 * @param mid
	 * @return
	 */
	public Menu loadMenuById(int mid);
	
	/**
	 * 添加菜单
	 * @param name 菜单名称
	 * @param url  菜单地址
	 * @param isshow 是否在欢迎界面展示
	 * @param level 当前添加的菜单的级别
	 * @param parentid 父级菜单ID
	 */
	public void addMenu(String name,String url,int isshow,int level,int parentid);
	
	
	/**
	 * 加载所有角色
	 * @return
	 */
	public List<Role> loadAllRoles();
	
	/**
	 * 通过角色id查询角色菜单
	 * @param rid
	 * @return
	 */
	public List<Object[]> loadRoleMenuByRoleId(int rid);
	
	/**
	 * 通过角色id加载角色对象
	 * @param rid
	 * @return
	 */
	public Role loadRoleById(int rid);
	
	/**
	 * 编辑角色权限
	 * @param rid
	 * @param mids
	 */
	public void editRoleMenu(int rid, String[] mids);
	
	/**
	 * 检查uid这个用户是否拥有uri这个菜单权限
	 * @param uid
	 * @param uri
	 * @return 返回true表示有权限 返回false表示无权限
	 */
	public boolean checkUserMenu(int uid, String uri);
	
	/**
	 * 分页查询员工列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page<EmployeeVo> loadEmployeeByPage(int pageNo, int pageSize, String searchName,String searchJob,String searchDept);


	/**
	 * 加载所有职位
	 * @return
	 */
	public List<Job> loadAllJob();
	
	/**
	 * 加载所有部门
	 * @return
	 */
	public List<Dept> loadAllDept();
}
