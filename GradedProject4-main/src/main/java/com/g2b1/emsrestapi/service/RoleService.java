package com.g2b1.emsrestapi.service;

import java.util.List;

import com.g2b1.emsrestapi.entity.Role;

public interface RoleService {

	void save(Role role);

	List<Role> viewAllRoles();

}
