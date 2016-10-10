package com.web.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.web.util.Page;

/**
 * 所有DAO层实现类的父类
 * @author Administrator
 *
 * @param <T>
 */
public class BaseDao<T> {
	
	private static SessionFactory sf;
	
	private Class<T> entityClass;
	
	private Session session;
	
	private Transaction transaction;

	static{
		Configuration config = new Configuration().configure("com/web/hbm/hibernate.cfg.xml");
		sf = config.buildSessionFactory();
	}
	
	/**
	 * 提供给子类的获取一个Session对象的方法
	 * @return
	 */
	public Session openSession(){
		session = sf.openSession();
		return session;
	}
	
	@SuppressWarnings("unchecked")
	public BaseDao(){
		Type genType = this.getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}
	
	/**
	 * 新增
	 * @param t
	 * @return
	 */
	public T save(T t){
		session = sf.openSession();
		transaction = session.beginTransaction();
		transaction.begin();
		session.save(t);
		transaction.commit();
		session.close();
		return t;
	}
	
	/**
	 * 修改
	 * @param t
	 * @return
	 */
	public T update(T t){
		session = sf.openSession();
		transaction = session.beginTransaction();
		transaction.begin();
		session.update(t);
		transaction.commit();
		session.close();
		return t;
	}
	
	/**
	 * 删除
	 * @param t
	 * @return
	 */
	public T delete(T t){
		session = sf.openSession();
		transaction = session.beginTransaction();
		transaction.begin();
		session.delete(t);
		transaction.commit();
		session.close();
		return t;
	}
	
	/**
	 * 新增/修改
	 * @param t
	 * @return
	 */
	public T saveOrUpdate(T t){
		session = sf.openSession();
		transaction = session.beginTransaction();
		transaction.begin();
		session.saveOrUpdate(t);
		transaction.commit();
		session.close();
		return t;
	}
	
	/**
	 * 通过主键查询一个对象
	 * @param c
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T get(int id){
		session = sf.openSession();
		T t = (T)session.get(entityClass, id);
		session.close();
		return t;
	}
	
	
	/**
	 * 通用的SQL查询方法（不分页）
	 * @param sql
	 * @param objects
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> sqlQuery(String sql, Object... objects){
		session = sf.openSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(entityClass);
		if(null != objects && objects.length > 0){
			for(int i=0;i<objects.length;i++){
				sqlQuery.setParameter(i, objects[i]);
			}
		}
		List<T> list = sqlQuery.list();
		session.close();
		return list;
	}
	
	/**
	 * 通用的SQL查询方法（分页）
	 * @param sql
	 * @param objects
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Page<T> sqlQuery(String sql, int pageNo, int pageSize, Object... objects){
		session = sf.openSession();
		/*
		 * 查询总数量
		 */
		String sqlCount = "select count(*) " + removeSelect(sql);
		SQLQuery sqlQuery = session.createSQLQuery(sqlCount);
		if(null != objects && objects.length > 0){
			for(int i=0;i<objects.length;i++){
				sqlQuery.setParameter(i, objects[i]);
			}
		}
		long total = ((BigInteger)sqlQuery.list().get(0)).longValue();
		
		/*
		 * 查询当前页的数据
		 */
		sqlQuery = session.createSQLQuery(sql).addEntity(entityClass);
		if(null != objects && objects.length > 0){
			for(int i=0;i<objects.length;i++){
				sqlQuery.setParameter(i, objects[i]);
			}
		}
		List<T> list = sqlQuery.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
		session.close();
		return new Page<T>(pageNo, pageSize, list, total);
	}
	
	/**
	 * 通用的HQL查询方法（不分页）
	 * @param hql
	 * @param objects
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> hqlQuery(String hql, Object... objects){
		session = sf.openSession();
		Query query = session.createQuery(hql);
		if(null != objects && objects.length > 0){
			for(int i=0;i<objects.length;i++){
				query.setParameter(i, objects[i]);
			}
		}
		List<T> list = query.list();
		session.close();
		return list;
	}
	
	/**
	 * 通用的HQL查询方法（分页）
	 * @param hql
	 * @param objects
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Page<T> hqlQuery(String hql, int pageNo, int pageSize, Object... objects){
		session = sf.openSession();
		/*
		 * 查询总数量
		 */
		String sqlCount = "select count(*) " + removeSelect(hql);
		Query query = session.createQuery(sqlCount);
		if(null != objects && objects.length > 0){
			for(int i=0;i<objects.length;i++){
				query.setParameter(i, objects[i]);
			}
		}
		long total = ((BigInteger)query.uniqueResult()).longValue();
		
		/*
		 * 查询当前页的数据
		 */
		query = session.createQuery(hql);
		if(null != objects && objects.length > 0){
			for(int i=0;i<objects.length;i++){
				query.setParameter(i, objects[i]);
			}
		}
		List<T> list = query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
		session.close();
		return new Page<T>(pageNo, pageSize, list, total);
	}
	
	/**
	 * 通用的sql查询返回List<Object[]>
	 * @param sql
	 * @param objects
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> sqlQueryArray(String sql, Object... objects){
		session = sf.openSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		if(null != objects && objects.length > 0){
			for(int i=0;i<objects.length;i++){
				sqlQuery.setParameter(i, objects[i]);
			}
		}
		List<Object[]> list = sqlQuery.list();
		session.close();
		return list;
	}
	
	
	
	
	/**
	 * 去掉sql语句的from关键字前面的内容
	 * 只支持select子句的子查询
	 * @param sql
	 * @return
	 */
	private static String removeSelect(String sql) {
		int index = sql.toLowerCase().lastIndexOf("from");
		if(index == -1){
			throw new HibernateException("HQL语句必须包含关键字-from");
		}
		return sql.substring(index);
	}
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		UserDaoImpl bd = new UserDaoImpl();
		Session session = bd.openSession();
		String hql = "select e.ename,j.jobName,d.dname from Employee e,Job j,Dept d where e.jobid=j.jobid and e.deptid=d.did";
		List<Object[]> list = session.createQuery(hql).list();
		System.out.println(list.size());
		session.close();
	}
	
	
	
	
}
