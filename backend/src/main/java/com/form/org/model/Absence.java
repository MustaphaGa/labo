package com.form.org.model;

import java.util.Date;

import javax.persistence.*;

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
	private String justifie;
	private String motif;
	private String pieceJustificatifString;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idEmploye")
	private Employe employe;

}
