package com.form.org.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Stock")
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idStock")
	private Integer idStock;


	

	@Column(name="QuatiteStock")
	private String QuatiteStock;
	@Column(name="dateStock")
	private Date dateStock;


	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;

}
