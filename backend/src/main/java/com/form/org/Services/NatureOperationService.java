package com.form.org.Services;


import com.form.org.dto.NatureOperationDTO;

import java.util.List;

public interface NatureOperationService {

    NatureOperationDTO save(NatureOperationDTO dto);
    NatureOperationDTO findById(Integer idNatureOperation);
    List<NatureOperationDTO> findAll();
    void delete(Integer idNatureOperation);

}
