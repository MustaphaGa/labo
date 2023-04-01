package com.form.org.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChangerMotDePasseUtilisateurDTO {
	
	private Integer id;
    private String Password;
    private String confirmPassword;


}
