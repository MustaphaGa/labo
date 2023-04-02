package com.form.org.Services.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.form.org.Services.UtilisateurService;
import com.form.org.dto.UtilisateurDTO;
import com.form.org.model.auth.ExtendedUser;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

	@Autowired
	private UtilisateurService service;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	UtilisateurDTO utilisateur = service.findByEmail(email);
	
	List<SimpleGrantedAuthority> authorities= new ArrayList<>();
	utilisateur.getProfils().forEach(profil->
	authorities.add(
		new SimpleGrantedAuthority(profil.getNomProfil()))) ;
//	authorities.add(new SimpleGrantedAuthority(utilisateur.getNom()));
	return new ExtendedUser(utilisateur.getEmail(),utilisateur.getPassword(),
			utilisateur.getLabo().getIdLabo(),authorities);
	

	} 

}

