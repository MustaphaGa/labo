package com.form.org.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idArticle")
    private Integer idArticle;

    @Column(name = "article")
    private String articleName;
    @Column(name = "quantite")
    private String quantite;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idBonCommande")
    private BonCommande bonCommande;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idStock")
    private Stock stock;


}
