package com.form.org.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="GestionStock")
public class GestionStock extends Employe {
	
	
	private Integer idGesStock;
	
	@OneToMany(mappedBy="gestionStock")
	private List<BonCommande> bonCommandes;
	
	@OneToOne(mappedBy = "gestionStock")
    private Stock stock;
	

}
