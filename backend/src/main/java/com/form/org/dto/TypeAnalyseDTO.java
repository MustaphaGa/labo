package com.form.org.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.form.org.model.TypeAnalyse;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TypeAnalyseDTO {

	
	private Integer idTypeAnalyse;
	private String typeAnalyse;
	
	@JsonIgnore
	private List<AnalyseMedicalDTO> analyseMedicals;
	
	
	 public static TypeAnalyseDTO fromEntity(TypeAnalyse typeAnalyse) {
			if(typeAnalyse == null) {
				return null;
			}
			return   TypeAnalyseDTO.builder()
					.idTypeAnalyse(typeAnalyse.getIdTypeAnalyse())
					.typeAnalyse(typeAnalyse.getTypeAnalyse())
					.build();

}
	 
	 public static TypeAnalyse toEntity(TypeAnalyseDTO typeAnalyseDTO) {
			
			if(typeAnalyseDTO== null) {
				return null;
			
			}		
			TypeAnalyse typeAnalyse = new TypeAnalyse();
			
			typeAnalyse.setIdTypeAnalyse(typeAnalyseDTO.getIdTypeAnalyse());
			typeAnalyse.setTypeAnalyse(typeAnalyseDTO.getTypeAnalyse());
			
			return typeAnalyse;
		}

	
}
