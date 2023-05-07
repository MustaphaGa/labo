package com.form.org.Services.Imp;

import com.form.org.Repository.FournisseurRepository;
import com.form.org.Services.FournisseurService;
import com.form.org.dto.FournisseurDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.model.Fournisseur;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

    private FournisseurRepository fournisseurRepository;

    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public FournisseurDTO save(FournisseurDTO dto) {

        return FournisseurDTO.fromEntity(
                fournisseurRepository.save(
                        FournisseurDTO.toEntity(dto)
                )
        );
    }

    @Override
    public FournisseurDTO findById(Integer idFournisseur) {
        if(idFournisseur == null) {
            log.error("facture id is null");
            return null;
        }
        Optional<Fournisseur> fournisseur=fournisseurRepository.findById(idFournisseur);

        return Optional.of(FournisseurDTO.fromEntity(fournisseur.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun Fournisseur avec l'ID ="+ idFournisseur +"n'été trouve dans la BDD",
                        ErrorCodes.FOURNISSEUR_NOT_FOUND)
        );    }

    @Override
    public FournisseurDTO findByNom(String nom) {
        Optional<Fournisseur> fournisseur=fournisseurRepository.findByNom(nom);

        return Optional.of(FournisseurDTO.fromEntity(fournisseur.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun fournisseur avec cette date ="+ nom +"n'été trouve dans la BDD",
                        ErrorCodes.FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public List<FournisseurDTO> findAll() {
        return fournisseurRepository.findAll().stream()
                .map(FournisseurDTO :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idFournisseur) {
        if(idFournisseur == null) {
            log.error("fournisseur id is null");
            return ;
        }

        fournisseurRepository.deleteById(idFournisseur);

    }

    }

