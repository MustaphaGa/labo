package com.form.org.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UtilisateurDTO {
	
	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String confirmPassword;
	
	private LaboDTO labo;
	
	@JsonIgnore
	private List<ProfilDTO> profils;
	
	public static UtilisateurDTO fromEntity(Utilisateur utilisateur) {
		if (utilisateur == null) {
			return null;
		}
		return UtilisateurDTO.builder()

				.id(utilisateur.getId())
				.nom(utilisateur.getNom())
				.prenom(utilisateur.getPrenom())
				.email(utilisateur.getEmail())
				.password(utilisateur.getPassword())
				.confirmPassword(utilisateur.getConfirmPassword())
				.labo(LaboDTO.fromEntity(utilisateur.getLabo()))
				.profils(
			            utilisateur.getProfils() != null ?
			                utilisateur.getProfils().stream()
			                    .map(ProfilDTO::fromEntity)
			                    .collect(Collectors.toList()) : null
			        )
				.build();
	}

public static Utilisateur toEntity(UtilisateurDTO utilisateurDTO) {

		if (utilisateurDTO == null) {
			return null;
		}

		Utilisateur utilisateur = new Utilisateur();
		/*je suis comme ca */
		utilisateur.setId(utilisateurDTO.getId());
		utilisateur.setNom(utilisateurDTO.getNom());
		utilisateur.setPrenom(utilisateurDTO.getPrenom());
		utilisateur.setEmail(utilisateurDTO.getEmail());
		utilisateur.setPassword(utilisateurDTO.getPassword());
		utilisateur.setConfirmPassword(utilisateurDTO.getConfirmPassword());
		
		utilisateur.setLabo(LaboDTO.toEntity(utilisateurDTO.getLabo()));
		
		return utilisateur;
	}






}
