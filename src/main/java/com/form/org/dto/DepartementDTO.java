package com.form.org.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.form.org.model.Departement;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartementDTO {
	
	private Integer idDepartement;
	private String nomDepartement;
	
	@JsonIgnore
	private List<BiologisteDTO> biologistes;

 public static DepartementDTO fromEntity (Departement departement) {
	 if(departement == null) {
		 return null;
	 }
	 return   
			 DepartementDTO.builder()
			.idDepartement(departement.getIdDepartement())
			.nomDepartement(departement.getNomDepartement())
			
			 .build();
 }
 
 public static Departement toEntity(DepartementDTO departementDTO) {
	   
	   if(departementDTO == null) {
		   return null;
	   }
	   Departement departement = new Departement();
	   
	   departement.setIdDepartement(departementDTO.getIdDepartement());
	   departement.setNomDepartement(departementDTO.getNomDepartement());
	   
	  
	   
	   return departement;
   }

public DepartementDTO() {
	super();
	
}

public DepartementDTO(Integer idDepartement, String nomDepartement, List<BiologisteDTO> biologistes) {
	super();
	this.idDepartement = idDepartement;
	this.nomDepartement = nomDepartement;
	this.biologistes = biologistes;
}
	
}
