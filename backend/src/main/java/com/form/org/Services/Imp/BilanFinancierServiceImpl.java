package com.form.org.Services.Imp;

import com.form.org.Repository.BilanFinancierRepository;
import com.form.org.Services.BilanFinancierService;
import com.form.org.dto.BilanFinancierDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.model.BilanFinancier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BilanFinancierServiceImpl implements BilanFinancierService {

    private BilanFinancierRepository bilanFinancierRepository;

    @Autowired
    public BilanFinancierServiceImpl(BilanFinancierRepository bilanFinancierRepository) {
        this.bilanFinancierRepository = bilanFinancierRepository;
    }

    @Override
    public BilanFinancierDTO save(BilanFinancierDTO dto) {
        return BilanFinancierDTO.fromEntity(
                bilanFinancierRepository.save(
                        BilanFinancierDTO.toEntity(dto)));
    }

    @Override
    public BilanFinancierDTO findByIdBilan(Integer idBilan) {
        Optional<BilanFinancier> bilanFinancier=bilanFinancierRepository.findById(idBilan);

        return Optional.of(BilanFinancierDTO.fromEntity(bilanFinancier.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun bilan avec l'ID ="+ idBilan +"n'été trouve dans la BDD",
                        ErrorCodes.RESERVATION_NOT_FOUND));
    }

    @Override
    public List<BilanFinancierDTO> findAll() {
        return bilanFinancierRepository.findAll().stream()
                .map(BilanFinancierDTO :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idBilan) {
        if(idBilan == null) {
            log.error("reservation id is null");
            return ;
        }

        bilanFinancierRepository.deleteById(idBilan);

    }
}
