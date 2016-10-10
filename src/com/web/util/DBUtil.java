package com.web.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DBUtil<T> {
	
	public static SessionFactory sessionFactory;
	
	
//	private static String DRIVERCLASS;
//	
//	private static String URL;
//	
//	private static String USER;
//	
//	private static String PASSWORD;
	
	/**
	 * 静态初始化块 当这个类第一次被访问的时候执行
	 */
	static{
		Configuration config = new Configuration().configure("com/web/hbm/hibernate.cfg.xml");
		sessionFactory = config.buildSessionFactory();
//		Properties p = new Properties();
//		InputStream in = null;
//		try {
//			in = DBUtil.class.getResourceAsStream("/com/web/util/db.properties");
//			p.load(in);
//			
//			DRIVERCLASS = p.getProperty("driverClass");
//			URL = p.getProperty("url");
//			USER = p.getProperty("user");
//			PASSWORD = p.getProperty("password");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 连接数据库  获取连接对象
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		conn = sessionFactory.openSession().connection();
		return conn;
	}
	
	/**
	 * 通过主键查询一个对象
	 * @param c
	 * @param id
	 * @return
	 */
	public T get(Class c, int id){
		Session session = sessionFactory.openSession();
		T t = (T)session.get(c, id);
		session.close();
		return t;
	}
	
	/**
	 * 新增/保存
	 * @param obj
	 * @return
	 */
	public boolean save(T t){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		tx.begin();
		session.save(t);
		tx.commit();
		session.close();
		return true;
	}
	
	/**
	 * 修改/保存
	 * @param obj
	 * @return
	 */
	public boolean update(T t){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		tx.begin();
		session.update(t);
		tx.commit();
		session.close();
		return true;
	}
	
	/**
	 * 通过主键删除
	 * @param obj
	 * @return
	 */
	public boolean delete(T t){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		tx.begin();
		session.delete(t);
		tx.commit();
		session.close();
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> sqlQuery(Class c, String sql, Object... params){
		Session session = DBUtil.sessionFactory.openSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(c);
		if(null != params && params.length > 0){
			for(int i=0;i<params.length;i++){
				sqlQuery.setParameter(i, params[i]);
			}
		}
		List<T> list = sqlQuery.list();
		session.close();
		return list;
	}
	
	//私有构造方法 防止创建此类的对象
	public DBUtil(){}

}
