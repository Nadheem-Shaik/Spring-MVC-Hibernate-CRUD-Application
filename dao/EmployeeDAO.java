package com.tap.dao;

import java.util.List;

import com.tap.Entity.Employee;

public interface EmployeeDAO {

	void insert(Employee e);
	Employee getEmpById(int id);
	void updateEmp(Employee e);
	void deleteEmp(int id);
	List<Employee> fetchAll();
}
