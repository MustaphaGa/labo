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
@Table(name="NatureOperation")
public class NatureOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idNatureOperation")
    private Integer idNatureOperation;

    @Column(name="libNatureOperation")
    private String libNatureOperation;

    @OneToMany(mappedBy = "natureOperation")
    private List<Operation> operations;
}
