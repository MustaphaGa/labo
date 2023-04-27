package com.form.org.Services;

import com.form.org.dto.CongeDTO;

import java.util.List;

public interface CongeService {
    CongeDTO save(CongeDTO dto);

    CongeDTO findById(Integer idConge);



    List<CongeDTO> findAll();

    void delete(Integer idConge);
}
