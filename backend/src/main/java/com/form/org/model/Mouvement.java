package com.form.org.model;

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
@Table(name="Mouvement")
public class Mouvement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idMouvement")
	private Integer idMouvement;
	private String typeMouvement;
	private String detailMouvement;
	private double frais;
	
	@ManyToOne
	@JoinColumn(name="idRh")
	private RH rh;

}
