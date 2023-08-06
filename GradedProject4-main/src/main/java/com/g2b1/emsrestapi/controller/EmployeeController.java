package com.g2b1.emsrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.g2b1.emsrestapi.entity.Employee;
import com.g2b1.emsrestapi.service.EmployeeService;

@RequestMapping("/api/employees")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Method-Handler to Display All the Employees Record
	// http://localhost:8080/api/employees
	@GetMapping("")
	public List<Employee> showAllEmployees() {

		return employeeService.viewAllEmployees();
	}

	// Method-Handler to Display An Employee's Record By ID
	// http://localhost:8080/api/employees/1
	@GetMapping("/{id}")
	public Employee viewEmployee(@PathVariable("id") long id) {

		return employeeService.findEmployeeById(id);
	}

	// Method-Handler to Insert An Employee Record into the Database
	@PostMapping("/save")
	public String associateEmployee(@RequestBody Employee employee) {

		employeeService.saveEmployee(employee);
		return "Successfully entered Employee";
	}

	// Method-Handler to Update the Details of A Specific Employee
	@PutMapping("/update")
	public String updateEmployee(@RequestBody Employee employee) {

		employeeService.saveEmployee(employee);
		return "Employee record update successfully";
	}

	// Method-Handler to Delete An Employee Record By ID
	// http://localhost:8080/api/employees/1
	@DeleteMapping("/{id}")
	public String removeEmployee(@PathVariable("id") long id) {

		employeeService.removeEmployee(id);
		return "Deleted Employee id - " + id;
	}

	// Method-Handler to Search(Display) List of All Employees By their FirstName
	// http://localhost:8080/api/employees/search/firstname
	@GetMapping("/search/{firstname}")
	public List<Employee> listEmployeesByFirstname(@PathVariable("firstname") String firstname) {

		return employeeService.listEmployeesByFirstname(firstname);
	}

	// Method-Handler to Sort Employees Records By their FirstName
	// http://localhost:8080/api/employees/sort?order=asc
	@GetMapping("/sort")
	public List<Employee> sortEmployees(@RequestParam("order") String order) {

		List<Employee> employees = null;
		// Permits both asc/ASC
		if (order.equalsIgnoreCase("asc"))
			employees = employeeService.sortEmployees(Direction.ASC);

		// Permits both desc/DESC
		if (order.equalsIgnoreCase("desc"))
			employees = employeeService.sortEmployees(Direction.DESC);

		return employees;
	}
}
