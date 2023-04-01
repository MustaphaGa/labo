package com.form.org.dto;

import java.math.BigDecimal;
import com.form.org.model.DetailResultat;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DetailResultatDTO {
	
	private Integer idResultat;
	private String description;
	private BigDecimal valeur;
	
	private BiologisteDTO biologiste;
	private AnalyseMedicalDTO analyseMedical;
	
public static DetailResultatDTO fromEntity(DetailResultat detailResultat) {
		if(detailResultat == null) {
			return null;
		}
		return  
				DetailResultatDTO.builder()
				.idResultat(detailResultat.getIdResultat())
				.description(detailResultat.getDescription())
				.valeur(detailResultat.getValeur())
				
				.biologiste(BiologisteDTO.fromEntity(detailResultat.getBiologiste()))
				.analyseMedical(AnalyseMedicalDTO.fromEntity(detailResultat.getAnalyseMedical()))
				.build();
				
	}
	
public static DetailResultat toEntity(DetailResultatDTO detailResultatDTO) {
		
		if(detailResultatDTO == null) {
			return null;
		}
		
		DetailResultat detailResultat = new DetailResultat();
		
		detailResultat.setIdResultat(detailResultatDTO.getIdResultat());
		detailResultat.setDescription(detailResultatDTO.getDescription());
		detailResultat.setValeur(detailResultatDTO.getValeur());
		detailResultat.setBiologiste(BiologisteDTO.toEntity(detailResultatDTO.getBiologiste()));
		detailResultat.setAnalyseMedical(AnalyseMedicalDTO.toEntity(detailResultatDTO.getAnalyseMedical()));
		
			
		return detailResultat;
	}

public DetailResultatDTO() {
	super();
	// TODO Auto-generated constructor stub
}

public DetailResultatDTO(Integer idResultat, String description, BigDecimal valeur, BiologisteDTO biologiste,
		AnalyseMedicalDTO analyseMedical) {
	super();
	this.idResultat = idResultat;
	this.description = description;
	this.valeur = valeur;
	this.biologiste = biologiste;
	this.analyseMedical = analyseMedical;
}

}
