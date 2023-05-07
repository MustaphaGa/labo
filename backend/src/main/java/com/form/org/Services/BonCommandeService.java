package com.form.org.Services;

import com.form.org.dto.AnalyseMedicalDTO;
import com.form.org.dto.BonCommandeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface BonCommandeService {
    BonCommandeDTO save(BonCommandeDTO dto);

    BonCommandeDTO findById(Integer idBonCommande);

    BonCommandeDTO findByDateCommande(Date dateCommande);

    List<BonCommandeDTO> findAll();

    void delete(Integer idBonCommande);
}
