package com.g2b1.emsrestapi.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.g2b1.emsrestapi.dto.RegistrationDto;
import com.g2b1.emsrestapi.entity.Role;
import com.g2b1.emsrestapi.entity.User;
import com.g2b1.emsrestapi.repository.UserRepository;
import com.g2b1.emsrestapi.security.MyUserDetails;
import com.g2b1.emsrestapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(RegistrationDto registrationDto) {

		List<Role> currentRoles = registrationDto.getRoles();

		User user = userRepository.findByUsername(registrationDto.getUsername());

		// If the User is Already Registered with "username"
		if (user != null) {

			List<Role> appendRoles = new ArrayList<Role>();

			// Fetching the Existing Roles of the User
			List<Role> previousRoles = user.getRoles();
			for (Role r : previousRoles)
				appendRoles.add(r);

			// Appending Newer Roles to the List
			for (Role r : currentRoles)
				appendRoles.add(r);

			user.setRoles(appendRoles);
		}

		// New User Registration - With Password Encryption
		else
			user = new User(registrationDto.getUsername(), bCryptPasswordEncoder.encode(registrationDto.getPassword()),
					currentRoles);

		userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);

		if (user == null)
			throw new UsernameNotFoundException("Could not find user");

		return new MyUserDetails(user);
	}

}
