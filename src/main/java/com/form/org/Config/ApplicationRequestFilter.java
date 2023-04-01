package com.form.org.Config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;

import com.form.org.Services.auth.ApplicationUserDetailsService;
import com.form.org.utils.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
public class ApplicationRequestFilter extends OncePerRequestFilter {
	
	  @Autowired
	  private JwtUtil jwtUtil;

	  @Autowired
	  private ApplicationUserDetailsService userDetailsService;

	  @Override
	  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	      throws ServletException, IOException {
  
	    final String authHeader = request.getHeader("Authorization");
	    String userEmail = null;
	    String jwt = null;
	    String idLabo = null;
	    
	    if(authHeader != null && authHeader.startsWith("Bearer ")) {  
	      jwt = authHeader.substring(7);
	      userEmail = jwtUtil.extractUsername(jwt); 
	      idLabo=jwtUtil.extractIdLabo(jwt);
	      
	    }

	    if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	      UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
	      if (jwtUtil.validateToken(jwt, userDetails)) {	  
	       UsernamePasswordAuthenticationToken usPasAuthToken = new UsernamePasswordAuthenticationToken(
	            userDetails, null, userDetails.getAuthorities()
	        );
	         usPasAuthToken.setDetails(
	            new WebAuthenticationDetailsSource().buildDetails(request)
	        );
	        SecurityContextHolder.getContext().setAuthentication(usPasAuthToken);
	      }  
	    }
	    MDC.put("idLabo", idLabo);
	    chain.doFilter(request, response);
	   
	   
	  }

}
