package com.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.web.entity.Dept;
import com.web.entity.Job;
import com.web.entity.Menu;
import com.web.entity.Role;
import com.web.entity.User;
import com.web.model.UserModel;
import com.web.model.impl.UserModelImpl;
import com.web.util.JasperReportHelper;
import com.web.util.Page;
import com.web.vo.EmployeeVo;
import com.web.vo.MenuVo;

/**
 * 8月16号课后练习:
 * 	将项目中所有请求都发送到MainServlet统一处理
 *  每个请求要求额外多传递一个参数methodName,值是需要调用的方法名称
 * 	web.xml中的servlet配置改为*.do
 * 	LoginFilter过滤器中排除登录、注册、退出请求的拦截。
 */
@SuppressWarnings("serial")
public class MenuServlet extends HttpServlet{
	
	//控制层持有一个模型层对象
	private UserModel userModel = new UserModelImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//接收所有请求
		String methodName = req.getParameter("methodName");
		Class c = MenuServlet.class;
		try {
			Method m = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			m.invoke(this, req, resp);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 展示所有菜单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showMenus(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int pageNo = Integer.valueOf(req.getParameter("pageNo"));
		int pageSize = Integer.valueOf(req.getParameter("pageSize"));
		Page<MenuVo> page = userModel.loadAllMenus(pageNo, pageSize);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", page.getDataList());//easyui要求返回的分页数据键必须为rows
		map.put("total", page.getTotal());//easyui要求返回分页总行数的键必须为total
		
		//String json = JSONArray.fromObject(menuList).toString();
		String json = JSONObject.fromObject(map).toString();
		
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(json);
		resp.getWriter().flush();
		//req.setAttribute("menuList", menuList);
		//req.getRequestDispatcher("view/showMenus.jsp").forward(req, resp);
	}
	
	/**
	 * 链接到添加菜单界面  动态加载所有一级和二级菜单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toAddMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Menu> menuList = userModel.load12Menus();
		menuList.add(0, new Menu(-1, "请选择父级菜单"));
		//req.setAttribute("menuList", menuList);
		//req.getRequestDispatcher("view/addMenu.jsp").forward(req, resp);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(menuList).toString());
		resp.getWriter().flush();
	}
	
	/**
	 * 添加菜单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addMenu(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		String name = req.getParameter("name");
		System.out.println(name);
		String url = req.getParameter("url");
		String isshow = req.getParameter("isshow");
		String parentid = req.getParameter("parentid");
		int i = userModel.addMenu(name, url, Integer.valueOf(isshow), Integer.valueOf(parentid));
		if(i == 1){
			req.setAttribute("msg", "添加成功！");
			//添加成功 跳转到菜单列表界面
			this.showMenus(req, resp);
		}else{
			req.setAttribute("msg", "添加失败！");
			//添加失败 跳转到添加界面
			this.toAddMenu(req, resp);
		}
	}
	
	/**
	 * 展示角色列表
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showRoles(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Role> roleList = userModel.loadAllRoles();
		req.setAttribute("roleList", roleList);
		req.getRequestDispatcher("view/showRoles.jsp").forward(req, resp);
	}
	
	/**
	 * 加载角色对应的菜单
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadRoleMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rid = req.getParameter("rid");
		List<Object[]> roleMenuList = userModel.loadRoleMenuByRoleId(Integer.valueOf(rid));
		req.setAttribute("roleMenuList", roleMenuList);
		
		Role r = userModel.loadRoleById(Integer.valueOf(rid));
		req.setAttribute("role", r);
		req.getRequestDispatcher("view/roleMenu.jsp").forward(req, resp);
	}
	
	/**
	 * 编辑角色权限
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void editRoleMenu(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rid = req.getParameter("rid");
		String[] mids = req.getParameterValues("mids");
		userModel.editRoleMenu(Integer.valueOf(rid), mids);
		req.setAttribute("msg", "修改成功!");
		this.loadRoleMenu(req, resp);
	}
	
	public void testAJAX(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("AJAX请求来了");
		
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write("{\"address\":\"重庆渝中区\",\"name\":\"吴昌勇\"}");
		resp.getWriter().flush();
	}
	
	/**
	 * 分页展示员工列表
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showEmps(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int pageNo = Integer.valueOf(req.getParameter("pageNo"));
		int pageSize = Integer.valueOf(req.getParameter("pageSize"));
		
		String searchName = req.getParameter("searchName");
		String searchJob = req.getParameter("searchJob");
		String searchDept = req.getParameter("searchDept");
		
		Page<EmployeeVo> page = userModel.loadEmployeeByPage(pageNo, pageSize, searchName, searchJob, searchDept);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", page.getDataList());//easyui要求返回的分页数据键必须为rows
		map.put("total", page.getTotal());//easyui要求返回分页总行数的键必须为total
		
		//String json = JSONArray.fromObject(menuList).toString();
		String json = JSONObject.fromObject(map).toString();
		
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(json);
		resp.getWriter().flush();
		//req.setAttribute("menuList", menuList);
		//req.getRequestDispatcher("view/showMenus.jsp").forward(req, resp);
	}
	
	/**
	 * 新增员工或搜索员工时准备下拉列表数据
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadAllJob(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Job> jobList = userModel.loadAllJob();
		jobList.add(0, new Job(-1, "请选择职位"));
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(jobList).toString());
		resp.getWriter().flush();
	}
	
	/**
	 * 新增员工或搜索员工时准备下拉列表数据
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadAllDept(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Dept> deptList = userModel.loadAllDept();
		deptList.add(0, new Dept(-1, "请选择部门", null));
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(deptList).toString());
		resp.getWriter().flush();
	}
	
	
	/**
	 *    
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadAllDept2(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Dept> deptList = userModel.loadAllDept();
		deptList.add(0, new Dept(-1, "请选择部门", null));
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.fromObject(deptList).toString());
		resp.getWriter().flush();
	}
	
}
