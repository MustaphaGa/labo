package com.form.org.Services;

import com.form.org.dto.AbsenceDTO;
import com.form.org.dto.BilanFinancierDTO;

import java.util.List;

public interface BilanFinancierService {

    BilanFinancierDTO save(BilanFinancierDTO dto);

    BilanFinancierDTO findByIdBilan(Integer idBilan);


    List<BilanFinancierDTO> findAll();

    void delete(Integer idBilan);
}
