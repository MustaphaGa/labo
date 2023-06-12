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
	private Date dateCommande;
	private double prix;
	
	@ManyToOne
	@JoinColumn(name="id_employe")
	private Employe employe;
	
	@ManyToOne
	@JoinColumn(name="idFournisseur")
	private Fournisseur fournisseur;
	
	@OneToOne
	@JoinColumn(name = "idFacture")
    private Facture facture;

	@OneToMany(mappedBy="bonCommande")
	private List<Article> articles;
	

}
