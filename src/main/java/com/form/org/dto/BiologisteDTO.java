package com.form.org.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.Biologiste;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BiologisteDTO {

	private Integer idBiologiste;
	private String nom;
	private String prenom;
	private String email;
	private String sexe;
	private String telephone;

	private String codeBiologiste;
	private String service;
	
	@JsonIgnore
	private List<DetailResultatDTO> detailResultats;
	
	private DepartementDTO departement;
	
public static BiologisteDTO fromEntity(Biologiste biologiste) {
		if(biologiste == null) {
		return null;
		}
		return  
				BiologisteDTO.builder()
				.idBiologiste(biologiste.getIdBiologiste())
	    		.nom(biologiste.getNom())
	    		.prenom(biologiste.getPrenom())
	    		.email(biologiste.getEmail())
	    		.sexe(biologiste.getSexe())
	            .telephone(biologiste.getTelephone())
	            .codeBiologiste(biologiste.getCodeBiologiste())
	            .service(biologiste.getService())
	            .departement(DepartementDTO.fromEntity(biologiste.getDepartement()))
				.build();
	}		
	
	
public static Biologiste toEntity(BiologisteDTO biologisteDTO) {
		if(biologisteDTO == null  ) {
			return null ;
		}
		Biologiste biologiste = new Biologiste();
		
		biologiste.setIdBiologiste(biologisteDTO.getIdBiologiste());
		biologiste.setNom(biologisteDTO.getNom());
		biologiste.setPrenom(biologisteDTO.getPrenom());
		biologiste.setEmail(biologisteDTO.getEmail());
		biologiste.setSexe(biologisteDTO.getSexe());
		biologiste.setTelephone(biologisteDTO.getTelephone());
		biologiste.setCodeBiologiste(biologisteDTO.getCodeBiologiste());
		biologiste.setService(biologisteDTO.getService());
		biologiste.setDepartement(DepartementDTO.toEntity(biologisteDTO.getDepartement()));
		return biologiste;
	}


public BiologisteDTO() {
	super();
}


public BiologisteDTO(Integer idBiologiste, String nom, String prenom, String email, String sexe, String telephone,
		String codeBiologiste, String service, List<DetailResultatDTO> detailResultats, DepartementDTO departement) {
	super();
	this.idBiologiste = idBiologiste;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.sexe = sexe;
	this.telephone = telephone;
	this.codeBiologiste = codeBiologiste;
	this.service = service;
	this.detailResultats = detailResultats;
	this.departement = departement;
}








}
