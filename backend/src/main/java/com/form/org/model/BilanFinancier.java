package com.form.org.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="BilanFinancier")
public class BilanFinancier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idBilan")
	private Integer idBilan;
	@Column(name="Annee_BF")
	private String Annee_BF;
	@Column(name="Montant_BF")
	private Double Montant_BF;


	@ManyToOne
	@JoinColumn(name="idCompte")
	private Compte compte;






}
