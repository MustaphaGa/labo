package com.form.org.Services.auth;

import com.form.org.Repository.EmployeRepository;
import com.form.org.Services.EmployeService;
import com.form.org.dto.EmployeDTO;
import com.form.org.model.auth.ExtendedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    @Autowired
	private EmployeService service;


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		EmployeDTO employed =service.findByEmail(email);

		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		employed.getRoles().forEach(rolesDTO -> authorities.add(new SimpleGrantedAuthority(rolesDTO.getRoleName())));


		return new ExtendedUser(employed.getEmail(),employed.getPassword(),employed.getLabo().getIdLabo(),authorities);
		//return new ExtendedUser(employed.getEmail(),employed.getPassword(), Collections.emptyList());

	}
}



