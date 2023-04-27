package com.form.org.Services;

import com.form.org.dto.RhDTO;

import java.util.List;

public interface RhService {

    RhDTO save(RhDTO dto);

    RhDTO findById(Integer idRh);


    List<RhDTO> findAll();

    void delete(Integer idRh);

}
