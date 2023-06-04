package com.form.org.dto;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.*;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@Data
@Builder
//@MappedSuperclass
public class EmployeDTO  {
	
	private Integer id_employe;
	private String nom;
	private String prenom;
	private String email;
	private String cin;
	private String adresse;
	private String telephone;
	private double salaire;
	private String password;
	private Date date_embauchDate;
	private String photo;
	
	@JsonIgnore
	private List<Conge> conges;
	@JsonIgnore
	private List<Absence> absences;
	@JsonIgnore
	private List<Mouvement> mouvements;
	@JsonIgnore
	private List<BonCommande> bonCommandes;
	@JsonIgnore
	private List<Recrutement> recrutements;

	@JsonIgnore
	private List<RolesDTO> roles;

	private LaboDTO labo;


	
public static EmployeDTO fromEntity(Employe employe) {
		
		if(employe == null) {
			return null;
		}
		return EmployeDTO.builder()	
			.id_employe(employe.getId_employe())
			.nom(employe.getNom())
			.prenom(employe.getPrenom())
			.telephone(employe.getTelephone())
			.email(employe.getEmail())
			.password(employe.getPassword())
			.cin(employe.getCin())
			.adresse(employe.getAdresse())
			.salaire(employe.getSalaire())
			.date_embauchDate(employe.getDate_embauchDate())
				.labo(LaboDTO.fromEntity(employe.getLabo()))
				.roles(
						employe.getRoles() != null ?
								employe.getRoles().stream()
										.map(RolesDTO::fromEntity)
										.collect(Collectors.toList()) : null
				)
				.build();
	}
    
	public static Employe toEntity(EmployeDTO employeDTO) {
		if(employeDTO == null) {	
			return null;
			}
		Employe employe = new Employe();

		employe.setId_employe(employeDTO.getId_employe());
		employe.setNom(employeDTO.getNom());
		employe.setPrenom(employeDTO.getPrenom());
		employe.setEmail(employeDTO.getEmail());
		employe.setCin(employeDTO.getCin());
		employe.setAdresse(employeDTO.getAdresse());
		employe.setTelephone(employeDTO.getTelephone());
		employe.setSalaire(employeDTO.getSalaire());
		employe.setPassword(employeDTO.getPassword());
		employe.setDate_embauchDate(employeDTO.getDate_embauchDate());
		employe.setLabo(LaboDTO.toEntity(employeDTO.getLabo()));
		
		return employe;	
	}




}



