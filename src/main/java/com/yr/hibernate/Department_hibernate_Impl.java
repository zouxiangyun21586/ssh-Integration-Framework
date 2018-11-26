package com.yr.hibernate;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.yr.entity.Department;

@Repository
public class Department_hibernate_Impl implements Department_hibernate {

	@Resource
//	implements Serializable
	private SessionFactory sessionFactory;

	private Session session;
	
	/**
	 * 获取和当前线程绑定的Session
	 * 
	 * @return
	 */
	private Session getSession() {
		return sessionFactory.getCurrentSession(); // openSession不能自动关闭,且会有其他隐患错误,所以建议使用 getCurrentSession (可以自动关闭)
	}
	
	@Override
	public List<Department> query() {
		session = getSession();
		Query q = session.createQuery("from Department");
		List<Department> listUser = q.getResultList();
		return listUser;
	}

	@Override
	public void insert(Department department) {
		session = getSession();
		session.save(department);
	}

}
