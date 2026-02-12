package com.tap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.Entity.Employee;
import com.tap.dao.EmployeeDAO;

@Controller
public class HomeController {

	@Autowired
	private EmployeeDAO employeeDAO;

	@RequestMapping("/")
	public String loadForm() {
		return "index";
	}

	@RequestMapping("/saveEmployee")
	public String saveEmployee(
			@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			Model model) {

		Employee e = new Employee(id, name, email);

		employeeDAO.insert(e);
		List<Employee> emplist = employeeDAO.fetchAll();

		model.addAttribute("list", emplist);

		return "success";
	}
	@RequestMapping("/updateData")
	public String updateData() {
		return "update";
	}
	@RequestMapping("/updateEmployee")
	public String updateEmployee(
			@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			Model model) {

		Employee e = new Employee(id, name, email);

		employeeDAO.updateEmp(e);
		// Fetch updated list
		List<Employee> emplist = employeeDAO.fetchAll();
		model.addAttribute("list", emplist);
		return "success";
	}
	@RequestMapping("/deleteData")
	public String deleteEmployee(@RequestParam("id") int id,Model model) {
		
		employeeDAO.deleteEmp(id);
		// Fetch updated list
		List<Employee> emplist = employeeDAO.fetchAll();
		model.addAttribute("list", emplist);
		return "success";
	}

	
}
