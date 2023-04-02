package com.form.org.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@Table(name="Employe")
public class Employe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idEmploye")
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
	
	@OneToMany(mappedBy="employe")
	private List<Conge> conges;
	
	@OneToMany(mappedBy="employe")
	private List<Absence> absences;

}
