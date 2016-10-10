package com.web.model.impl;

import java.util.List;

import com.web.dao.DeptDao;
import com.web.dao.EmpDao;
import com.web.dao.JobDao;
import com.web.dao.MenuDao;
import com.web.dao.MenuVoDao;
import com.web.dao.RoleDao;
import com.web.dao.RoleMenuDao;
import com.web.dao.UserDao;
import com.web.dao.impl.DeptDaoImpl;
import com.web.dao.impl.EmpDaoImpl;
import com.web.dao.impl.JobDaoImpl;
import com.web.dao.impl.MenuDaoImpl;
import com.web.dao.impl.MenuVoDaoImpl;
import com.web.dao.impl.RoleDaoImpl;
import com.web.dao.impl.RoleMenuDaoImpl;
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
	//模型层持有一个DAO层对象
	private JobDao jobDao = new JobDaoImpl();
	//模型层持有一个DAO层对象
	private MenuDao menuDao = new MenuDaoImpl();
	//模型层持有一个DAO层对象
	private MenuVoDao menuVoDao = new MenuVoDaoImpl();
	//模型层持有一个DAO层对象
	private DeptDao deptDao = new DeptDaoImpl();
	//模型层持有一个DAO层对象
	private RoleDao roleDao = new RoleDaoImpl();
	//模型层持有一个DAO层对象
	private RoleMenuDao roleMenuDao = new RoleMenuDaoImpl();
	//模型层持有一个DAO层对象
	private EmpDao empDao = new EmpDaoImpl();
	
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
	public User loadUserById(int uid){
		return userDao.loadUserById(uid);
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
		return menuDao.loadMenusByUid(uid);
	}
	
	/**
	 * 加载所有菜单
	 * @return
	 */
	public Page<MenuVo> loadAllMenus(int pageNo, int pageSize){
		return menuVoDao.loadAllMenus(pageNo, pageSize);
	}
	
	/**
	 * 加载所有一级和二级菜单
	 * @return
	 */
	public List<Menu> load12Menus(){
		return menuDao.load12Menus();
	}
	
	/**
	 * 添加菜单
	 * @param name 菜单名称
	 * @param url  菜单地址
	 * @param isshow 是否在欢迎界面展示
	 * @param parentid 父级菜单ID
	 * @return 返回1表示添加成功 返回2表示父级菜单不存在
	 */
	public int addMenu(Menu menu){
		Menu m = menuDao.loadMenuById(menu.getParentid());
		if(null != m){
			menu.setLevel(m.getLevel()+1);
			menuDao.addMenu(menu);
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
		return roleDao.loadAllRoles();
	}
	
	/**
	 * 通过角色id查询角色菜单
	 * @param rid
	 * @return
	 */
	public List<Object[]> loadRoleMenuByRoleId(int rid){
		return roleDao.loadRoleMenuByRoleId(rid);
	}
	
	/**
	 * 通过角色id加载角色对象
	 * @param rid
	 * @return
	 */
	public Role loadRoleById(int rid){
		return roleDao.loadRoleById(rid);
	}
	
	/**
	 * 编辑角色权限
	 * @param rid
	 * @param mids
	 */
	public void editRoleMenu(int rid, String[] mids){
		roleMenuDao.editRoleMenu(rid, mids);
	}
	
	/**
	 * 检查uid这个用户是否拥有uri这个菜单权限
	 * @param uid
	 * @param uri
	 * @return 返回true表示有权限 返回false表示无权限
	 */
	public boolean checkUserMenu(int uid, String uri){
		return roleMenuDao.checkUserMenu(uid, uri);
	}
	
	/**
	 * 分页查询员工列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page<EmployeeVo> loadEmployeeByPage(int pageNo, int pageSize, String searchName,String searchJob,String searchDept){
		return empDao.loadEmployeeByPage(pageNo, pageSize, searchName, searchJob, searchDept);
	}
	
	/**
	 * 加载所有职位
	 * @return
	 */
	public List<Job> loadAllJob(){
		return jobDao.loadAllJob();
	}
	
	/**
	 * 加载所有部门
	 * @return
	 */
	public List<Dept> loadAllDept(){
		return deptDao.loadAllDept();
	}
	
}
