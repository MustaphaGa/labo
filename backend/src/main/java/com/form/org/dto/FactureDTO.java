package com.form.org.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.form.org.model.Facture;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FactureDTO {

	public FactureDTO() {
		super();
	}

	private Integer idFacture;
	private Date dateFacture;
	private BigDecimal montant;

	private AnalyseMedicalDTO analyseMedical;

public static FactureDTO fromEntity(Facture facture) {
		if (facture == null) {
			return null;
		}
		return FactureDTO.builder()

				.idFacture(facture.getIdFacture())
				.dateFacture(facture.getDateFacture())
				.montant(facture.getMontant())
				.analyseMedical(AnalyseMedicalDTO.fromEntity(facture.getAnalyseMedical()))

				.build();
	}

public static Facture toEntity(FactureDTO factureDTO) {

		if (factureDTO == null) {
			return null;
		}

		Facture facture = new Facture();

		facture.setIdFacture(factureDTO.getIdFacture());
		facture.setDateFacture(factureDTO.getDateFacture());
		facture.setMontant(factureDTO.getMontant());
		facture.setAnalyseMedical(AnalyseMedicalDTO.toEntity(factureDTO.getAnalyseMedical()));
		return facture;
	}

public FactureDTO(Integer idFacture, Date dateFacture, BigDecimal montant, AnalyseMedicalDTO analyseMedical) {
	super();
	this.idFacture = idFacture;
	this.dateFacture = dateFacture;
	this.montant = montant;
	this.analyseMedical = analyseMedical;
}

}
