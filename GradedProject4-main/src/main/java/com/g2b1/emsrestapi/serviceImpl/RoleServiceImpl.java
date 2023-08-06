package com.g2b1.emsrestapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.g2b1.emsrestapi.entity.Role;
import com.g2b1.emsrestapi.repository.RoleRepository;
import com.g2b1.emsrestapi.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public void save(Role role) {

		roleRepository.save(role);
	}

	@Override
	public List<Role> viewAllRoles() {

		return roleRepository.findAll();
	}

}
