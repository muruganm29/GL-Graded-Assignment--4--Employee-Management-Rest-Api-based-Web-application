package com.g2b1.emsrestapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.g2b1.emsrestapi.service.UserService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {

		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(bCryptPasswordEncoder());
		return auth;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(daoAuthenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Only ADMIN can Save, Update and Delete Employee Record
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/employees/{id}").hasAuthority("ADMIN")
				.antMatchers("/api/employees/save", "/api/employees/update").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/api/employees/{id}").permitAll()
				.antMatchers("/registration/addrole", "/registration/adduser", "/api/employees",
						"/api/employees/search/{firstname}", "/api/employees/sort")
				.permitAll().anyRequest().authenticated().and().httpBasic() // Basic Authorization
				.and().cors().and().csrf().disable();

	}

}
