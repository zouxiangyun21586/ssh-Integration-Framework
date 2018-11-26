package com.yr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yr.entity.Department;
import com.yr.hibernate.Department_hibernate_Impl;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private Department_hibernate_Impl department_hibernate_impl;

	/**
	 * 注意: Dao使用getCurrentSession获取session时必须加事务,否则抛异常(可以直接配全局节省代码)
	 */
	@Transactional
	@Override
	public List<Department> query() {
		List<Department> listDepartment = department_hibernate_impl.query();
		return listDepartment;
	}

	@Transactional
	@Override
	public void insert(Department department) throws Exception {
//		try { // 保证事务能回滚
			department_hibernate_impl.insert(department);
			int i = 1 / 0;
			department_hibernate_impl.insert(department);
//		} catch (RuntimeException e) {
//			e.printStackTrace();
//		}
	}

}
