package com.form.org.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
//@MappedSuperclass
@EntityListeners( AuditingEntityListener.class )
@Entity
@Table(name="Utilisateur")

public class Utilisateur implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;

	@Column(name="confirmPassword")
	private String confirmPassword;
	
	@ManyToOne
	@JoinColumn(name="idLabo")
	private Labo labo;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "utilisateur")
	@JsonIgnore
	private List<Profil> profils;
	

}
