package com.form.org.Controller;

import com.form.org.Controller.api.AbsenceApi;
import com.form.org.Services.AbsenceService;
import com.form.org.dto.AbsenceDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class AbsenceController implements AbsenceApi {

    private AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService)
    {
        this.absenceService = absenceService;
    }

    @Override
    public AbsenceDTO save(AbsenceDTO dto) {
        return absenceService.save(dto);
    }

    @Override
    public AbsenceDTO findById(Integer idAbsence) {
        return absenceService.findById(idAbsence) ;
    }

    @Override
    public AbsenceDTO findByMotif(String motif) {
        return absenceService.findByMotif(motif);
    }

    @Override
    public List<AbsenceDTO> findAll() {
        return absenceService.findAll();
    }

    @Override
    public void delete(Integer idAbsence) {
        absenceService.delete(idAbsence);

    }
}
