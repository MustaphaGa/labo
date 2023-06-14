package com.form.org.Services;

import com.form.org.dto.CompteDTO;
import java.util.List;

public interface CompteService {

    CompteDTO save(CompteDTO dto);

    CompteDTO findById(Integer idCompte);

    List<CompteDTO> findAll();

    void delete(Integer idCompte);
}
