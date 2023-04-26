package com.form.org.utils;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.form.org.model.auth.ExtendedUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
public class JwtUtil {
	
	 private String SECRET_KEY = "secret";
        
public String extractUsername(String token) {
	return extractClaim(token, Claims::getSubject);}    

public Date extractExpiration(String token) {
	return extractClaim(token, Claims::getExpiration); }

public String extractIdLabo(String token) {
    final Claims claims = extractAllClaims(token);
    return claims.get("idLabo", String.class);
  }
	    //3

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }
	    //4
    private Claims extractAllClaims(String token) {
    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	    }
        //5
    private Boolean isTokenExpired(String token) {
	return extractExpiration(token).before(new Date());
	    }
	public String generateToken(ExtendedUser userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails);

	}

	private String createToken(Map<String, Object> claims, ExtendedUser userDetails) {

		return Jwts.builder().setClaims(claims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.claim( "idLabo", userDetails.getIdLabo().toString())
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();

	}
         //6
		/* public String generateToken(UserDetails userDetails) {
			 Map<String, Object> claims = new HashMap<>();
			 return createToken(claims, userDetails.getUsername());

	    }
	private String createToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.claim( "idLabo", "")
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();

	}
	*/

        
	    //7
	/*
	    private String createToken(Map<String, Object> claims, ExtendedUser subject) {

	        return Jwts.builder().setClaims(claims)
	        		.setSubject(userDetails.getUsername())
	        		.setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
					.claim( "id_labo", "")
	                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	        
	    }*/

	    public Boolean validateToken(String token, UserDetails userDetails) {
	        final String username = extractUsername(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }

}
