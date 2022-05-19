
package com.disneyApi.Alkemy.service.impl;

import com.disneyApi.Alkemy.dto.GeneroDTO;
import com.disneyApi.Alkemy.service.GeneroService;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl implements GeneroService {
    
    @Override
    public GeneroDTO save(GeneroDTO dto) {

        // II. validar que el genero no exista
        // III. guardar el genero
        // IV. retornar el genero guardado
        System.out.println("GENERO GUARDADO");
        return dto;
    }
}
