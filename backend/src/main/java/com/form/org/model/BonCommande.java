package com.form.org.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

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
	@Column(name="dateCommande")
	private Date dateCommande;
	@Column(name="QuantiteCommande")
	private Integer QuantiteCommande;

	/*
	@ManyToOne
	@JoinColumn(name="id_employe")
	private Employe employe;
	 */
	
	@ManyToOne
	@JoinColumn(name="idFournisseur")
	private Fournisseur fournisseur;

	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;

}
