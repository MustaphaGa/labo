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
@Table(name="Compte")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idCompte")
    private Integer idCompte;

    @Column(name="libCompte")
    private String libCompte;

    @Column(name="NumeroCompte")
    private String NumeroCompte;

    @OneToMany(mappedBy="compte")
    private List<Operation> operations;

    @OneToMany(mappedBy="compte")
    private List<BilanFinancier> bilanFinanciers;
}
