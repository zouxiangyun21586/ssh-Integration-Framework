package com.yr.service;

import java.util.List;

import com.yr.entity.Department;

public interface DepartmentService {
	
	public List<Department> query();
	
	public void insert(Department department) throws Exception;
}
