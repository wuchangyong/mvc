package com.web.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.web.dao.UserDao;
import com.web.entity.Dept;
import com.web.entity.Job;
import com.web.entity.Menu;
import com.web.entity.Role;
import com.web.entity.User;
import com.web.util.DBUtil;
import com.web.util.Page;
import com.web.vo.EmployeeVo;
import com.web.vo.MenuVo;

public class UserDaoImpl implements UserDao{

	/**
	 * 通过用户名加载一个用户对象（登录）
	 * @param userName 用户输入的帐号
	 * @return 返回null表示用户的帐号不存在 
	 */
	public User loadUserByName(String userName){
		String sql = "select * from tb_user where userName=?";
		List<Object[]> list = DBUtil.executeQuery(sql, new Object[]{userName});
		User user = null;
		if(null != list && list.size() > 0){
			Object[] os = list.get(0);
			user = new User((Integer)os[0], userName, String.valueOf(os[2]), (Integer)os[3], (String)os[4], (Integer)os[5], (String)os[6], (String)os[7],(String)os[8]);
		}
		return user;
	}
	
	/**
	 * 通过主键加载一个用户对象（登录）
	 * @param uid 用户主键
	 * @return  
	 */
	public User loadUserByName(int uid){
		String sql = "select * from tb_user where uid=?";
		List<Object[]> list = DBUtil.executeQuery(sql, new Object[]{Integer.valueOf(uid)});
		User user = null;
		if(null != list && list.size() > 0){
			Object[] os = list.get(0);
			user = new User((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[2]), (Integer)os[3], (String)os[4], (Integer)os[5], (String)os[6], (String)os[7],(String)os[8]);
		}
		return user;
	}

	/**
	 * 加载所有用户
	 */
	@Override
	public Page<User> loadAllUsers(int pageNo, int pageSize) {
		String sql = "select * from tb_user limit ?,?";
		List<Object[]> list = DBUtil.executeQuery(sql, new Object[]{(pageNo-1)*pageSize, pageSize});
		List<User> userList = new ArrayList<User>();
		User user = null;
		if(null != list && list.size() > 0){
			for(Object[] os : list){
				user = new User((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[2]), (Integer)os[3], (String)os[4], (Integer)os[5], (String)os[6], (String)os[7], (String)os[8]);
				userList.add(user);
			}
		}
		
		sql = "select count(*) from tb_user";
		list = DBUtil.executeQuery(sql, null);
		long total = (Long)list.get(0)[0];
		return new Page<User>(pageNo, pageSize, userList, total);
	}
	
	/**
	 * 删除用户
	 * @param uid
	 */
	public void deleteUser(int uid){
		String sql = "delete from tb_user where uid=?";
		DBUtil.executeDML(sql, new Object[]{uid});
	}
	
	/**
	 * 通过帐号主键Id加载此用户拥有的菜单集合
	 * @param uid
	 * @return
	 */
	public List<Menu> loadMenusByUid(int uid){
		String sql = "select m.* from userrole ur,rolemenu rm,menu m where ur.rid=rm.rid and rm.mid=m.mid and m.isshow=1 and ur.uid=?";
		List<Object[]> list = DBUtil.executeQuery(sql, new Object[]{uid});
		List<Menu> menuList = new ArrayList<Menu>();
		Menu m = null;
		if(null != list && list.size() > 0){
			for(Object[] os : list){
				m = new Menu((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[2]), (Integer)os[3], (Integer)os[4], (Integer)os[5]);
				menuList.add(m);
			}
		}
		return menuList;
	}
	
	/**
	 * 加载所有菜单
	 * @return
	 */
	public Page<MenuVo> loadAllMenus(int pageNo, int pageSize){
		String sql = "select m.mid,m.name,m.url,m.isshow,m.level,(select m2.name from menu m2 where m2.mid=m.parentid) from menu m limit ?,?";
		List<Object[]> list = DBUtil.executeQuery(sql, new Object[]{(pageNo-1)*pageSize, pageSize});
		List<MenuVo> menuList = new ArrayList<MenuVo>();
		MenuVo m = null;
		if(null != list && list.size() > 0){
			for(Object[] os : list){
				m = new MenuVo((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[2]), (Integer)os[3], (Integer)os[4], (String)os[5]);
				menuList.add(m);
			}
		}
		sql = "select count(*) from menu";
		list = DBUtil.executeQuery(sql, null);
		long total = (Long)list.get(0)[0];
		return new Page<MenuVo>(pageNo, pageSize, menuList, total);
	}
	
	/**
	 * 加载所有一级和二级菜单
	 * @return
	 */
	public List<Menu> load12Menus(){
		String sql = "select m.* from menu m where m.level in(1,2)";
		List<Object[]> list = DBUtil.executeQuery(sql, null);
		List<Menu> menuList = new ArrayList<Menu>();
		Menu m = null;
		if(null != list && list.size() > 0){
			for(Object[] os : list){
				m = new Menu((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[2]), (Integer)os[3], (Integer)os[4], (Integer)os[5]);
				menuList.add(m);
			}
		}
		return menuList;
	}
	
	/**
	 * 通过主键id加载一个菜单对象
	 * @param mid
	 * @return
	 */
	public Menu loadMenuById(int mid){
		String sql = "select * from menu where mid=?";
		List<Object[]> list = DBUtil.executeQuery(sql, new Object[]{mid});
		Menu m = null;
		if(null != list && list.size() > 0){
			Object[] os = list.get(0);
			m = new Menu((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[2]), (Integer)os[3], (Integer)os[4], (Integer)os[5]);
		}
		return m;
	}
	
	/**
	 * 添加菜单
	 * @param name 菜单名称
	 * @param url  菜单地址
	 * @param isshow 是否在欢迎界面展示
	 * @param level 当前添加的菜单的级别
	 * @param parentid 父级菜单ID
	 */
	public void addMenu(String name,String url,int isshow,int level,int parentid){
		String sql = "insert into menu(name,url,isshow,level,parentid) values(?,?,?,?,?)";
		DBUtil.executeDML(sql, new Object[]{name,url,isshow,level,parentid});
	}
	
	/**
	 * 加载所有角色
	 * @return
	 */
	public List<Role> loadAllRoles(){
		String sql = "select * from role";
		List<Object[]> list = DBUtil.executeQuery(sql, null);
		List<Role> roleList = new ArrayList<Role>();
		Role r = null;
		if(null != list && list.size() > 0){
			for(Object[] os : list){
				r = new Role((Integer)os[0], String.valueOf(os[1]));
				roleList.add(r);
			}
		}
		return roleList;
	}
	
	/**
	 * 通过角色id查询角色菜单
	 * @param rid
	 * @return
	 */
	public List<Object[]> loadRoleMenuByRoleId(int rid){
		String sql = "select m.mid,m.name,m.parentid,(select 1 from rolemenu rm where rm.mid=m.mid and rm.rid=?) from menu m";
		return DBUtil.executeQuery(sql, new Object[]{rid});
	}
	
	/**
	 * 通过角色id加载角色对象
	 * @param rid
	 * @return
	 */
	public Role loadRoleById(int rid){
		String sql = "select * from role where rid=?";
		List<Object[]> list = DBUtil.executeQuery(sql, new Object[]{rid});
		Role r = null;
		if(null != list && list.size() > 0){
			Object[] os = list.get(0);
			r = new Role((Integer)os[0], String.valueOf(os[1]));
		}
		return r;
	}
	
	
	/**
	 * 编辑角色权限
	 * @param rid
	 * @param mids
	 */
	public void editRoleMenu(int rid, String[] mids){
		/*
		 * 先删除原来已有的菜单关联
		 */
		String sql = "delete from rolemenu where rid=?";
		DBUtil.executeDML(sql, new Object[]{rid});
		
		/*
		 * 再重新添加
		 */
		sql = "insert into rolemenu(rid,mid) values(?,?)";
		if(null != mids && mids.length > 0){
			for(String mid : mids){
				DBUtil.executeDML(sql, new Object[]{rid, Integer.valueOf(mid)});
			}
		}
	}
	
	/**
	 * 检查uid这个用户是否拥有uri这个菜单权限
	 * @param uid
	 * @param uri
	 * @return 返回true表示有权限 返回false表示无权限
	 */
	public boolean checkUserMenu(int uid, String uri){
		String sql = "select 1 from userrole ur,rolemenu rm,menu m where ur.rid=rm.rid and rm.mid=m.mid and ur.uid=? and m.url like '%" + uri + "%'";
		List<Object[]> list = DBUtil.executeQuery(sql, new Object[]{uid});
		if(null != list && list.size() > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 分页查询员工列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page<EmployeeVo> loadEmployeeByPage(int pageNo, int pageSize, String searchName,String searchJob,String searchDept){
		StringBuffer sql = new StringBuffer(" from employee e where 1=1 ");
		//动态拼装组合查询条件
		if(null != searchName && !"".equals(searchName.trim())){
			sql.append(" and e.Employee_Name like '%"+ searchName.trim() +"%'");
		}
		if(null != searchJob && Integer.valueOf(searchJob) > 0){
			sql.append(" and e.job_id = " + searchJob);
		}
		if(null != searchDept && Integer.valueOf(searchDept) > 0){
			sql.append(" and e.Department_id = " + searchDept);
		}
		
		
		String dataSql = "select e.Employee_id,e.Employee_Name," +
				"(select job.job_name from job where job.job_id=e.job_id)," +
				"(select e2.Employee_Name from employee e2 where e2.Employee_id=e.manager_id)," +
				"e.HireDate,e.Salary,e.comm," +
				"(select d.Name from department d where d.department_id=e.Department_id) ";
		
		//查询当前页的数据
		List<Object[]> list = DBUtil.executeQuery(dataSql+sql.toString()+" limit ?,?", new Object[]{(pageNo-1)*pageSize, pageSize});
		List<EmployeeVo> empList = new ArrayList<EmployeeVo>();
		EmployeeVo emp = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(null != list && list.size() > 0){
			for(Object[] os : list){
				emp = new EmployeeVo((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[2]), String.valueOf(os[3]), null!=os[4]?sdf.format((Date)os[4]):"未知", (Integer)os[5], null!=os[6]?(Integer)os[6]:0, String.valueOf(os[7]));
				empList.add(emp);
			}
		}
		
		//查询总共有多少行数据
		list = DBUtil.executeQuery("select count(*) " + sql.toString(), null);
		long total = (Long)list.get(0)[0];
		return new Page<EmployeeVo>(pageNo, pageSize, empList, total);
	}
	
	
	/**
	 * 加载所有职位
	 * @return
	 */
	public List<Job> loadAllJob(){
		String sql = "select * from job";
		List<Object[]> list = DBUtil.executeQuery(sql, null);
		List<Job> jobList = new ArrayList<Job>();
		Job j = null;
		if(null != list && list.size() > 0){
			for(Object[] os : list){
				j = new Job((Integer)os[0], String.valueOf(os[1]));
				jobList.add(j);
			}
		}
		return jobList;
	}
	
	/**
	 * 加载所有部门
	 * @return
	 */
	public List<Dept> loadAllDept(){
		String sql = "select * from department";
		List<Object[]> list = DBUtil.executeQuery(sql, null);
		List<Dept> deptList = new ArrayList<Dept>();
		Dept d = null;
		if(null != list && list.size() > 0){
			for(Object[] os : list){
				d = new Dept((Integer)os[0], String.valueOf(os[1]), String.valueOf(os[2]));
				deptList.add(d);
			}
		}
		return deptList;
	}
	
	
	
}
