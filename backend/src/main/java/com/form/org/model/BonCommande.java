package com.form.org.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="BonCommande")
public class BonCommande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idBonCommande")
	private Integer idBonCommande;
	private Date dateCommande;
	private double prix;
	
	@ManyToOne
	@JoinColumn(name="idGesStock")
	private GestionStock gestionStock;
	
	@ManyToOne
	@JoinColumn(name="idFournisseur")
	private Fournisseur fournisseur;
	
	@OneToOne(mappedBy = "bonCommande")
    private Facture facture;
	

}
