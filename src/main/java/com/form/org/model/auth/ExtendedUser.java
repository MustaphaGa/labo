package com.form.org.model.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

public class ExtendedUser extends User{
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private Integer idLabo;

	public ExtendedUser(String username, String password,
		      Collection<? extends GrantedAuthority> authorities) {
		    super(username, password, authorities);
		  }
	
	  public ExtendedUser(String username, String password, Integer idLabo,
		      Collection<? extends GrantedAuthority> authorities) {
		    super(username, password, authorities);
		    this.idLabo = idLabo;
		  }

		 
}
