package com.form.org.dto;

import java.util.Date;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.Absence;
import com.form.org.model.Conge;
import com.form.org.model.Employe;
import com.form.org.model.Roles;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeDTO {
	
	private Integer idEmploye;
	private String nom;
	private String prenom;
	private String email;
	private String cin;
	private String adresse;
	private String telephone;
	private double salaire;
	private String login;
	private String password;
	private Date date_embauchDate;
	
	@JsonIgnore
	private List<Conge> conges;
	@JsonIgnore
	private List<Absence> absences;
	@JsonIgnore
	private List<Roles> roles;
	
public static EmployeDTO fromEntity(Employe employe) {
		
		if(employe == null) {
			return null;
		}
		return EmployeDTO.builder()	
			.idEmploye(employe.getIdEmploye())
			.nom(employe.getNom())
			.login(employe.getLogin())
			.prenom(employe.getPrenom())
			.telephone(employe.getTelephone())
			.email(employe.getEmail())
			.password(employe.getPassword())
			.cin(employe.getCin())
			.adresse(employe.getAdresse())
			.salaire(employe.getSalaire())
			.date_embauchDate(employe.getDate_embauchDate())
			.build();
	}
    
	public static Employe toEntity(EmployeDTO employeDTO) {
		if(employeDTO == null) {	
			return null;
			}
		Employe employe = new Employe();
		employe.setIdEmploye(employeDTO.getIdEmploye());
		employe.setNom(employeDTO.getNom());
		employe.setPrenom(employeDTO.getPrenom());
		employe.setEmail(employeDTO.getEmail());
		employe.setCin(employeDTO.getCin());
		employe.setAdresse(employeDTO.getAdresse());
		employe.setTelephone(employeDTO.getTelephone());
		employe.setSalaire(employeDTO.getSalaire());
		employe.setLogin(employeDTO.getLogin());
		employe.setPassword(employeDTO.getPassword());
		employe.setDate_embauchDate(employeDTO.getDate_embauchDate());
		
		return employe;	
	}

	

	
}



