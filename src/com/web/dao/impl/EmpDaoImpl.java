package com.web.dao.impl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.web.dao.EmpDao;
import com.web.entity.Employee;
import com.web.util.Page;
import com.web.vo.EmployeeVo;

public class EmpDaoImpl extends BaseDao<Employee> implements EmpDao{

	/**
	 * 分页查询员工列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Page<EmployeeVo> loadEmployeeByPage(int pageNo, int pageSize, String searchName,String searchJob,String searchDept){
		Session session = this.openSession();
		
		StringBuffer sql = new StringBuffer(" from employee e where 1=1 ");
		//动态拼装组合查询条件
		if(null != searchName && !"".equals(searchName.trim())){
			sql.append(" and e.ename like '%"+ searchName.trim() +"%'");
		}
		if(null != searchJob && Integer.valueOf(searchJob) > 0){
			sql.append(" and e.jobid = " + searchJob);
		}
		if(null != searchDept && Integer.valueOf(searchDept) > 0){
			sql.append(" and e.deptid = " + searchDept);
		}
		
		
		String dataSql = "select e.eid,e.ename," +
				"(select job.jobName from job where job.jobid=e.jobid)," +
				"(select e2.ename from employee e2 where e2.eid=e.managerid)," +
				"e.hireDate,e.salary,e.comm," +
				"(select d.dname from dept d where d.did=e.deptid) ";
		
		//查询当前页的数据
		List<Object[]> list = session.createSQLQuery(dataSql+sql.toString()).setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
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
		List<BigInteger> count = session.createSQLQuery("select count(*) " + sql.toString()).list();
		long total = count.get(0).longValue();
		return new Page<EmployeeVo>(pageNo, pageSize, empList, total);
	}
	
}
