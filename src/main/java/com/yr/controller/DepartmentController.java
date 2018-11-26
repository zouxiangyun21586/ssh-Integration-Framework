package com.yr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yr.entity.Department;
import com.yr.service.DepartmentService;

@Controller
public class DepartmentController {
	
	public static void main(String[] args) {
		System.out.println("---");
	}
	
	@Autowired
	public DepartmentService departmentService;

	@RequestMapping(value = "/jsp", method = RequestMethod.GET)
	public String queryTest() {
		return "query";
	}

	@ResponseBody
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public List<Department> query(HttpServletResponse response, HttpServletRequest request) {
		List<Department> page = departmentService.query();
		return page;
	}
	
	@RequestMapping(value = "/department", method = RequestMethod.POST)
	public String insert() {
		try { // 处理异常
			Department department = new Department();
			department.setName("卡帝部");
			departmentService.insert(department);
			return "query";
		} catch (Exception e) {
			return "query";
		}
	}
	
}
