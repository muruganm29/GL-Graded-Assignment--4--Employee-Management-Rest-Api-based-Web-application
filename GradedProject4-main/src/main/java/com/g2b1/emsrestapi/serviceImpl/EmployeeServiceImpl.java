package com.g2b1.emsrestapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.g2b1.emsrestapi.entity.Employee;
import com.g2b1.emsrestapi.repository.EmployeeRepository;
import com.g2b1.emsrestapi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void saveEmployee(Employee employee) {

		employeeRepository.saveAndFlush(employee);
	}

	@Override
	public List<Employee> viewAllEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(long id) {

		return employeeRepository.findById(id).get();
	}

	@Override
	public void removeEmployee(long id) {

		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> listEmployeesByFirstname(String firstname) {

		return employeeRepository.findEmployeeByFirstname(firstname);
	}

	@Override
	public List<Employee> sortEmployees(Direction direction) {

		return employeeRepository.findAll(Sort.by(direction, "firstname"));
	}

}
