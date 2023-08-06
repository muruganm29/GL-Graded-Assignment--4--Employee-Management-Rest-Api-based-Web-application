package com.g2b1.emsrestapi.dto;

import java.util.List;

import com.g2b1.emsrestapi.entity.Role;

import lombok.Data;
import lombok.NoArgsConstructor;

// POJO to collect information of "user" during Registration
@NoArgsConstructor
@Data
public class RegistrationDto {

	private String username;

	private String password;

	private List<Role> roles;
}
