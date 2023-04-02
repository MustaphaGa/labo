package com.form.org.model;
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
@Table(name ="Biologiste")

public class Biologiste extends Employe{
	
	private Integer idBiologiste;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="email")
	private String email;
	
	@Column(name="sexe")
	private String sexe;
	
	@Column(name="telephone")
	private String telephone;

	@Column(name ="codeBiologiste")
	private String codeBiologiste;
	
	@Column(name = "service")
	private String service;

	@OneToMany(mappedBy="biologiste")
	private List<DetailResultat> detailResultats;

	@ManyToOne
	@JoinColumn(name="idDepartement")
	private Departement departement;

}
