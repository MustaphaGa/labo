package com.form.org.model;
import java.math.BigDecimal;
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
@Table(name="DetailResultat")

public class DetailResultat {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idResultat")
	private Integer idResultat;

	@Column(name="description")
	private String description;
	
	@Column(name="valeur1")
	private BigDecimal valeur1;

	@Column(name="valeur2")
	private BigDecimal valeur2;

	@Column(name="valeur3")
	private BigDecimal valeur3;

	@Column(name="valeur4")
	private BigDecimal valeur4;

	@Column(name="valeur5")
	private BigDecimal valeur5;

	@Column(name="valeur6")
	private BigDecimal valeur6;

	@Column(name="valeur7")
	private BigDecimal valeur7;

	@Column(name="valeur8")
	private BigDecimal valeur8;

	@Column(name="valeur9")
	private BigDecimal valeur9;

	@Column(name="valeur10")
	private BigDecimal valeur10;

	@ManyToOne
	@JoinColumn(name="idBiologiste")
	private Biologiste biologiste;
	
	@ManyToOne
	@JoinColumn(name="idAnalyseMedical")
	private AnalyseMedical analyseMedical;
	
	
	
	
	
	
	

}
