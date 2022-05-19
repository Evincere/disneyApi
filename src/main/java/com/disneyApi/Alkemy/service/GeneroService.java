
package com.disneyApi.Alkemy.service;

import com.disneyApi.Alkemy.dto.GeneroDTO;
import java.util.List;


public interface GeneroService {
    GeneroDTO save(GeneroDTO dto);

    List<GeneroDTO> getAllGeneros();
}
