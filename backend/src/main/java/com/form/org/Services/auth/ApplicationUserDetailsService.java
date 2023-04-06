package com.form.org.Services.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.form.org.Services.EmployeService;
import com.form.org.dto.EmployeDTO;
import com.form.org.model.auth.ExtendedUser;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

	@Autowired
	private EmployeService service;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		EmployeDTO employe = service.findByEmail(email);
	
	List<SimpleGrantedAuthority> authorities= new ArrayList<>();
	employe.getRoles().forEach(roles->
	authorities.add(
		new SimpleGrantedAuthority(roles.getRoleName()))) ;
//	authorities.add(new SimpleGrantedAuthority(utilisateur.getNom()));
	return new ExtendedUser(employe.getEmail(),employe.getPassword(),
			authorities);
	

	} 

}

