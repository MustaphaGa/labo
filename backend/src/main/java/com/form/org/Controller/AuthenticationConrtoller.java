package com.form.org.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import com.form.org.Controller.api.AuthenticationApi;
import com.form.org.Services.auth.ApplicationUserDetailsService;
import com.form.org.dto.auth.AuthenticationReponse;
import com.form.org.dto.auth.AuthenticationRequest;
import com.form.org.model.auth.ExtendedUser;
import com.form.org.utils.JwtUtil;

@RestController
public class AuthenticationConrtoller implements AuthenticationApi{
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private ApplicationUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	
//	 public ResponseEntity<AuthenticationReponse> authenticate(@RequestBody AuthenticationRequest request){    
//    	 authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(
//				request.getLogin(),
//				request.getPassword())
//				);
	@Override
	public ResponseEntity<AuthenticationReponse> authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
				request.getLogin(),
				request.getPassword())
				);			
		final UserDetails userDetails= userDetailsService.loadUserByUsername(request.getLogin());
		final String jwt= jwtUtil.generateToken((ExtendedUser) userDetails);
  		return ResponseEntity.ok(AuthenticationReponse.builder().accessToken(jwt).build()); 

    		
   
	}
}
