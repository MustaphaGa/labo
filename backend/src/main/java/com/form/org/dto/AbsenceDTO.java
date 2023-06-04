package com.form.org.dto;

import com.form.org.model.Absence;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.stream.Collectors;
@Data
@Builder
public class AbsenceDTO {

    private Integer idAbsence;
    private Date dateDebut;
    private Date dateFin;
    private String justifie;
    private String motif;
    private String pieceJustificatifString;

    private EmployeDTO employe;

    public static AbsenceDTO fromEntity(Absence absence) {

        if(absence == null) {
            return null;
        }
        return AbsenceDTO.builder()
                .idAbsence(absence.getIdAbsence())
                .dateDebut(absence.getDateDebut())
                .dateFin(absence.getDateFin())
                .motif(absence.getMotif())
                .justifie(absence.getJustifie())
                .pieceJustificatifString(absence.getPieceJustificatifString())
                .employe(EmployeDTO.fromEntity(absence.getEmploye()))
                        .build();
    }

    public static Absence toEntity(AbsenceDTO absenceDTO) {
        if(absenceDTO == null) {
            return null;
        }
        Absence absence = new Absence();
        absence.setIdAbsence(absenceDTO.getIdAbsence());
        absence.setDateDebut(absenceDTO.getDateDebut());
        absence.setDateFin(absenceDTO.getDateFin());
        absence.setMotif(absenceDTO.getMotif());
        absence.setJustifie((absenceDTO.getJustifie()));
        absence.setPieceJustificatifString(absenceDTO.getPieceJustificatifString());

        absence.setEmploye(EmployeDTO.toEntity(absenceDTO.getEmploye()));

        return absence;
    }


}
