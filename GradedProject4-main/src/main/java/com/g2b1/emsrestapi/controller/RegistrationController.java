package com.g2b1.emsrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g2b1.emsrestapi.dto.RegistrationDto;
import com.g2b1.emsrestapi.entity.Role;
import com.g2b1.emsrestapi.service.RoleService;
import com.g2b1.emsrestapi.service.UserService;

@RequestMapping("/registration")
@RestController
public class RegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	// Method-Handler to Add User into the Database along-with Roles
	@PostMapping("/adduser")
	public String saveUser(@RequestBody RegistrationDto registrationDto) {

		userService.save(registrationDto);
		return "User successfully Registered!!";
	}

	// Method-Handler to Add Role into the Database
	@PostMapping("/addrole")
	public String saveRole(@RequestBody Role role) {

		// Handling Exception for Duplicate Role Insertion
		try {
			roleService.save(role);
		} catch (DataIntegrityViolationException e) {
			return "Role Already Exists! Try adding a different ROLE";
		}
		return "Role successfully saved !";
	}
}
