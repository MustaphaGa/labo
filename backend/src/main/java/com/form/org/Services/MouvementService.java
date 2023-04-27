package com.form.org.Services;

import com.form.org.dto.MouvementDTO;

import java.util.List;

public interface MouvementService {

    MouvementDTO save(MouvementDTO dto);

    MouvementDTO findById(Integer idMouvement);

    MouvementDTO findByTypeMouvement(String typeMouvement);

    List<MouvementDTO> findAll();

    void delete(Integer idMouvement);
}
