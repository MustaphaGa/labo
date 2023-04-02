package com.form.org.Controller.api;

import static com.form.org.utils.Constants.AUTHENTICATION_ENDPOINT;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.form.org.dto.auth.AuthenticationReponse;
import com.form.org.dto.auth.AuthenticationRequest;

import io.swagger.annotations.Api;

@Api("authentication")
public interface AuthenticationApi {

	 @PostMapping(AUTHENTICATION_ENDPOINT + "/authenticate")
	  public ResponseEntity<AuthenticationReponse> authenticate(@RequestBody AuthenticationRequest request);
}
