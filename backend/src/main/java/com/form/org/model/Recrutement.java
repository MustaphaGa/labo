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
@Table(name="Recrutement")
public class Recrutement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idRecrutement")
	private Integer idRecrutement;
	private Date dateRecrutement;
	private String typeRecrutement;
	
	@ManyToOne
	@JoinColumn(name="id_employe")
	private Employe employe;

}
