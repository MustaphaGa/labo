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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Absence")
public class Absence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idAbsence")
	private Integer idAbsence;
	private Date dateDebut;
	private Date dateFin;
	private boolean justifie;
	private String motif;
	private String pieceJustificatifString;
	
	@ManyToOne
	@JoinColumn(name="idEmploye")
	private Employe employe;

}
