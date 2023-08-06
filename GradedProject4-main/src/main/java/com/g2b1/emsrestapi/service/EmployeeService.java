package com.g2b1.emsrestapi.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.g2b1.emsrestapi.entity.Employee;

public interface EmployeeService {

	public void saveEmployee(Employee employee);

	public List<Employee> viewAllEmployees();

	public Employee findEmployeeById(long id);

	public void removeEmployee(long id);

	public List<Employee> listEmployeesByFirstname(String firstname);

	public List<Employee> sortEmployees(Direction direction);

}
