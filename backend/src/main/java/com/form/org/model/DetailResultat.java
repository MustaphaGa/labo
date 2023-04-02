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
	
	@Column(name="valeur")
	private BigDecimal valeur;
	
	@ManyToOne
	@JoinColumn(name="idBiologiste")
	private Biologiste biologiste;
	
	@ManyToOne
	@JoinColumn(name="idAnalyseMedical")
	private AnalyseMedical analyseMedical;
	
	
	
	
	
	
	

}
