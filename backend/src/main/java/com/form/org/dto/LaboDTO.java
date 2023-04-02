package com.form.org.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.Labo;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LaboDTO {

	private Integer idLabo;
	private String nomLabo; 
	private String codeFiscal;
	private String numTel;
	private String email;
	private String siteWeb;
	
	@JsonIgnore
	private List<UtilisateurDTO> utilisateurs;
	
	public static LaboDTO fromEntity(Labo labo) {
		if (labo == null) {
			return null;
		}
		return LaboDTO.builder()
				.idLabo(labo.getIdLabo())
				.nomLabo(labo.getNomLabo())
				.codeFiscal(labo.getCodeFiscal())
				.email(labo.getEmail())
				.numTel(labo.getNumTel())
				.siteWeb(labo.getSiteWeb())
				.build();		
	}
	
	
	@SuppressWarnings("unused")
	public static Labo toEntity(LaboDTO laboDTO) {
		if(laboDTO == null) {
			return null;
		}
		
		Labo labo=new Labo();
		labo.setIdLabo(laboDTO.getIdLabo());
		labo.setNomLabo(laboDTO.getNomLabo());
		labo.setCodeFiscal(laboDTO.getCodeFiscal());
		labo.setEmail(laboDTO.getEmail());
		labo.setNumTel(laboDTO.getNumTel());
		labo.setSiteWeb(laboDTO.getSiteWeb());
		return labo;
		
	}
}
