package com.form.org.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.Patient;
import com.form.org.model.Reservation;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class PatientDTO {
	
	private Integer idPatient;
	private String nom;
	private String prenom;
	private String email;
	private String sexe;
	private String telephone;
	private String codePatient;
	private String cni;
	private Date dateNaissance;
	private String adressse;
	
	@JsonIgnore
	private List<Reservation> reservations;
	
	
public static PatientDTO fromEntity(Patient patient) {
		
	if(patient == null) {
		return null;
		}
		return
		    		PatientDTO.builder()
		    		.idPatient(patient.getIdPatient())
		    		.nom(patient.getNom())
		    		.prenom(patient.getPrenom())
		    		.email(patient.getEmail())
		    		.sexe(patient.getSexe())
		            .telephone(patient.getTelephone())
                    .codePatient(patient.getCodePatient())
                    .cni(patient.getCni())
                    .dateNaissance(patient.getDateNaissance())
		    		.adressse(patient.getAdressse())
		    		.build();
	}
	
	 public static Patient toEntity(PatientDTO patientdto) {
		 
		 if(patientdto == null) {
			 return null;
		 }
		 
		 Patient patient = new Patient();
		 patient.setIdPatient(patientdto.getIdPatient());
		 patient.setNom(patientdto.getNom());
		 patient.setPrenom(patientdto.getPrenom());
		 patient.setEmail(patientdto.getEmail());
		 patient.setSexe(patientdto.getSexe());
		 patient.setTelephone(patientdto.getTelephone());
		 patient.setCodePatient(patientdto.getCodePatient());
		 patient.setCni(patientdto.getCni());
		 patient.setDateNaissance(patientdto.getDateNaissance());
		 patient.setAdressse(patientdto.getAdressse());
		 
		     return patient;
	 }


	public PatientDTO(Integer idPatient, String nom, String prenom, String email, String sexe, String telephone,
			String codePatient, String cni, Date dateNaissance, String adressse, List<Reservation> reservations) {
	super();
		this.idPatient = idPatient;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.sexe = sexe;
		this.telephone = telephone;
		this.codePatient = codePatient;
		this.cni = cni;
		this.dateNaissance = dateNaissance;
		this.adressse = adressse;
		this.reservations = reservations;
	}

	public PatientDTO( String nom, String prenom, String email, String sexe, String telephone,
			String codePatient, String cni, Date dateNaissance, String adressse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.sexe = sexe;
		this.telephone = telephone;
		this.codePatient = codePatient;
		this.cni = cni;
		this.dateNaissance = dateNaissance;
		this.adressse = adressse;
	}

	public PatientDTO() {
		super();
		
	}
	
	 

}
