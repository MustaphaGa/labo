package com.form.org.Services.Imp;

import com.form.org.Repository.RhRepository;
import com.form.org.Services.RhService;
import com.form.org.dto.RhDTO;
import com.form.org.exception.EntityNotFoundException;
import com.form.org.exception.ErrorCodes;
import com.form.org.model.RH;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RhServiceImpl implements RhService {

    private RhRepository rhRepository;

    @Autowired
    public RhServiceImpl(RhRepository rhRepository) {
        this.rhRepository = rhRepository;
    }

    @Override
    public RhDTO save(RhDTO dto) {
        return RhDTO.fromEntity(
                rhRepository.save(
                        RhDTO.toEntity(dto)));
    }

    @Override
    public RhDTO findById(Integer idRh) {
        Optional<RH> rh=rhRepository.findById(idRh);

        return Optional.of(RhDTO.fromEntity(rh.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun rh avec l'ID ="+ idRh +"n'été trouve dans la BDD",
                        ErrorCodes.RESERVATION_NOT_FOUND));
    }

    @Override
    public List<RhDTO> findAll() {
        return rhRepository.findAll().stream()
                .map(RhDTO :: fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idRh) {

        if(idRh == null) {
            log.error("reservation id is null");
            return ;
        }

        rhRepository.deleteById(idRh);
    }
}
