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
@Table(name="Preleveur")
public class Preleveur  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idPreleveur")
	private Integer idPreleveur;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="email")
	private String email;
	
	@Column(name="specialite")
	private String specialite;
	
	
	@Column(name="sexe")
	private String sexe;
	
	@Column(name="telephone")
	private String telephone;
	
	@ManyToOne
	@JoinColumn(name="idAnalyseMedical")
	private AnalyseMedical analyseMedical;
	
	
	
	

}
