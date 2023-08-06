package com.g2b1.emsrestapi.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.g2b1.emsrestapi.dto.RegistrationDto;

public interface UserService extends UserDetailsService {

	void save(RegistrationDto registrationDto);

}
