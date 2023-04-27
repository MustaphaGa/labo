package com.form.org.Services;

import com.form.org.dto.RecrutementDTO;
import com.form.org.dto.ReservationDTO;
import com.form.org.model.Recrutement;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RecrutementService {

    RecrutementDTO save(RecrutementDTO dto);

    RecrutementDTO findByIdRecrutement(Integer idRecrutement);

    RecrutementDTO findByDateRecrutement(Date dateRecrutement);


    List<RecrutementDTO> findAll();

    void delete(Integer idRecrutement);
}
