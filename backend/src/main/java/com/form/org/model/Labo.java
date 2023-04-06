package com.form.org.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Labo")
public class Labo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idLabo")	
	private Integer idLabo;
	
	@Column(name="nomLabo")	
	private String nomLabo;   
	
	@Column(name="codefiscal")	
	private String codeFiscal;
	
	@Column(name="email")	
	private String email;
	
	@Column(name="numtel")	
	private String numTel;
	
	@Column(name="siteweb")	
	private String siteWeb;
	
	

}
