package com.form.org.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Fournisseur")
public class Fournisseur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idFournisseur")
	private Integer idFournisseur;
	private String nom;
	private  String Adresse;
	private String telephone;
	
	@OneToMany(mappedBy="fournisseur")
	private List<BonCommande> bonCommandes;

}
