package com.form.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Profil")
public class Profil {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idProfil")
	private Integer idProfil;
	
	@Column(name="nomProfil")
	private String nomProfil;
	
	@Column(name="droit")
	private String droit;
	
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur utilisateur;
	
	

}
