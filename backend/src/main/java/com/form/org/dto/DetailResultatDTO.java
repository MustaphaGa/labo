package com.form.org.dto;

import java.math.BigDecimal;
import com.form.org.model.DetailResultat;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Builder
@Data
public class DetailResultatDTO {
	
	private Integer idResultat;
	private String description;
	private BigDecimal valeur1;
	private BigDecimal valeur2;
	private BigDecimal valeur3;
	private BigDecimal valeur4;
	private BigDecimal valeur5;
	private BigDecimal valeur6;
	private BigDecimal valeur7;
	private BigDecimal valeur8;
	private BigDecimal valeur9;
	private BigDecimal valeur10;
	
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
				.valeur1(detailResultat.getValeur1())
						.valeur2(detailResultat.getValeur2())
						.valeur3(detailResultat.getValeur3())
						.valeur4(detailResultat.getValeur4())
						.valeur5(detailResultat.getValeur5())
						.valeur6(detailResultat.getValeur6())
						.valeur7(detailResultat.getValeur7())
						.valeur8(detailResultat.getValeur8())
						.valeur9(detailResultat.getValeur9())
						.valeur10(detailResultat.getValeur10())
				
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
		detailResultat.setValeur1(detailResultatDTO.getValeur1());
	    detailResultat.setValeur2(detailResultatDTO.getValeur2());
	    detailResultat.setValeur3(detailResultatDTO.getValeur3());
	    detailResultat.setValeur4(detailResultatDTO.getValeur4());
	    detailResultat.setValeur5(detailResultatDTO.getValeur5());
	    detailResultat.setValeur6(detailResultatDTO.getValeur6());
	    detailResultat.setValeur7(detailResultatDTO.getValeur7());
	    detailResultat.setValeur8(detailResultatDTO.getValeur8());
	    detailResultat.setValeur9(detailResultatDTO.getValeur9());
	    detailResultat.setValeur10(detailResultatDTO.getValeur10());
		detailResultat.setBiologiste(BiologisteDTO.toEntity(detailResultatDTO.getBiologiste()));
		detailResultat.setAnalyseMedical(AnalyseMedicalDTO.toEntity(detailResultatDTO.getAnalyseMedical()));
		
			
		return detailResultat;
	}

public DetailResultatDTO() {
	super();
	// TODO Auto-generated constructor stub
}

public DetailResultatDTO(Integer idResultat, String description, BigDecimal valeur1,BigDecimal valeur2,BigDecimal valeur3,BigDecimal valeur4,BigDecimal valeur5,BigDecimal valeur6,BigDecimal valeur7,BigDecimal valeur8,BigDecimal valeur9,BigDecimal valeur10, BiologisteDTO biologiste,
		AnalyseMedicalDTO analyseMedical) {
	super();
	this.idResultat = idResultat;
	this.description = description;
	this.valeur1 = valeur1;
	this.valeur2=valeur2 ;
	this.valeur3=valeur3 ;
	this.valeur4=valeur4 ;
	this.valeur5=valeur5 ;
	this.valeur6=valeur6 ;
	this.valeur7=valeur7 ;
	this.valeur8=valeur8 ;
	this.valeur9=valeur9 ;
	this.valeur10=valeur10 ;
	this.biologiste = biologiste;
	this.analyseMedical = analyseMedical;
}

}
