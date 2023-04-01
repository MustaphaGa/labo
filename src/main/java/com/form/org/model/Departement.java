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
@Table(name="Departement")

public class Departement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idDepartement")
	private Integer idDepartement;
	
	@Column(name="nomDepartement")
	private String nomDepartement;
	
	@OneToMany(mappedBy="departement")
	private List<Biologiste> biologistes;
	

	

}
