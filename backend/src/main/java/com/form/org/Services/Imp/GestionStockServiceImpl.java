package com.form.org.Services.Imp;

import com.form.org.Repository.GestionStockRepository;
import com.form.org.Services.GestionStockService;
import com.form.org.dto.GestionStockDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.model.GestionStock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Slf4j
public class GestionStockServiceImpl implements GestionStockService {

    private GestionStockRepository gestionStockRepository;

    @Autowired
    public GestionStockServiceImpl(GestionStockRepository gestionStockRepository) {
        this.gestionStockRepository = gestionStockRepository;
    }

    @Override
    public GestionStockDTO save(GestionStockDTO dto) {
        return GestionStockDTO.fromEntity(
                gestionStockRepository.save(
                        GestionStockDTO.toEntity(dto)
                )
        );
    }

    @Override
    public GestionStockDTO findById(Integer idGesStock) {
        Optional<GestionStock> gestionStock=gestionStockRepository.findById(idGesStock);
        return Optional.of(GestionStockDTO.fromEntity(gestionStock.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun gerantstock avec l'ID ="+ idGesStock +"n'été trouve dans la BDD",
                        ErrorCodes.FACTURE_NOT_FOUND)
        );
    }

    @Override
    public List<GestionStockDTO> findAll() {
        return gestionStockRepository.findAll().stream()
                .map(GestionStockDTO :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idGesStock) {
        if(idGesStock == null) {
            log.error("facture id is null");
            return ;
        }

        gestionStockRepository.deleteById(idGesStock);

    }
}
