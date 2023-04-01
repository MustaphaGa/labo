package com.form.org.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationReponse {
	private String accessToken;
	

}
