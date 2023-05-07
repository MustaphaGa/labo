package com.form.org.Services;

import com.form.org.dto.FournisseurDTO;

import java.util.Date;
import java.util.List;

public interface FournisseurService {
    FournisseurDTO save(FournisseurDTO dto);

    FournisseurDTO findById(Integer idFournisseur);

    FournisseurDTO findByNom(String nom);

    List<FournisseurDTO> findAll();

    void delete(Integer idFournisseur);
}
