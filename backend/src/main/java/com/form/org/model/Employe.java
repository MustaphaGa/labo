package com.form.org.model;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private Integer id_employe;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "email")
	private String email;

	@Column(name = "cin")
	private String cin;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "salaire")
	private double salaire;

	@Column(name = "password")
	private String password;

	@Column(name = "date_embauchDate")
	private Date date_embauchDate;

	@Column(name = "photo")
	private String photo;

	@ManyToOne
	@JoinColumn(name = "id_labo")
	private Labo labo;


	@OneToMany(mappedBy = "employe",fetch = FetchType.EAGER)
	private List<Roles> roles;

	@OneToMany(mappedBy="employe")
	private List<Conge> conges;

	@OneToMany(mappedBy="employe")
	private List<Absence> absences;

	@OneToMany(mappedBy="employe")
	private List<Recrutement> recrutements;

	@OneToMany(mappedBy="employe")
	private List<Mouvement> mouvements;

	@OneToMany(mappedBy="employe")
	private List<BonCommande> bonCommandes;

	/*@OneToOne(mappedBy = "employe")
	private Stock stock;*/

	@OneToMany(mappedBy="employe")
	private List<Operation> operations;
}


	



