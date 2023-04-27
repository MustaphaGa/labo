package com.form.org.Services;

import com.form.org.dto.AbsenceDTO;

import java.util.List;

public interface AbsenceService {


    AbsenceDTO save(AbsenceDTO dto);

    AbsenceDTO findById(Integer idAbsence);

    AbsenceDTO findByMotif(String motif);

    List<AbsenceDTO> findAll();

    void delete(Integer idAbsence);
}
