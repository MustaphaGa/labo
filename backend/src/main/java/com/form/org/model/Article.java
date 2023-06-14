package com.form.org.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "NomArticle")
    private String NomArticle;

    @Column(name = "prixArticle")
    private String prixArticle;

    @Column(name = "typeArticle")
    private String typeArticle;

    @Column(name = "codeBarre")
    private String codeBarre;


    @OneToMany(mappedBy="article")
    private List<BonCommande> bonCommandes;

    @OneToMany(mappedBy="article")
    private List<Stock> stocks;





}
