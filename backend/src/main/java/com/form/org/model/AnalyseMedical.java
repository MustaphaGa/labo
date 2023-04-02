package com.form.org.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="AnalyseMedical")

public class AnalyseMedical {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idAnalyse")
	private Integer idAnalyse;
	
	@Column(name="dateAnalyse")
	private Date dateAnalyse;
	
	@Column(name="prixAnalyse")
	private BigDecimal prixAnalyse;
	
	@Column(name="description")
	private String description;
	
	@Column(name="resultat")
	private Boolean resultat;
	
	@ManyToOne
	@JoinColumn(name="idTypeAnalyse")
	private TypeAnalyse typeAnalyse;
	
	@ManyToOne
	@JoinColumn(name="idReservation")
	private Reservation reservation;
	
	@OneToMany(mappedBy="analyseMedical")
	private List<Preleveur> preleveurs;
	
	@OneToMany(mappedBy="analyseMedical")
	private List<Facture> factures;
	
}
