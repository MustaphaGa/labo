package com.form.org.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Operation")

public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idOperation")
	private Integer idOperation;

	@Column(name="dateOperation")
	private Date dateOperation;

	@Column(name="Annee")
	private Integer Annee;

	@Column(name="description")
	private String description;

	@Column(name="Montant")
	private Float Montant;

	@ManyToOne
	@JoinColumn(name="idNatureOperation")
	private NatureOperation natureOperation;

	@ManyToOne
	@JoinColumn(name="idCompte")
	private Compte compte;


}
