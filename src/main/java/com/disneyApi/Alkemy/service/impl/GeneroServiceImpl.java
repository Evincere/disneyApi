
package com.disneyApi.Alkemy.service.impl;

import com.disneyApi.Alkemy.dto.GeneroDTO;
import com.disneyApi.Alkemy.entity.GeneroEntity;
import com.disneyApi.Alkemy.mapper.GeneroMapper;
import com.disneyApi.Alkemy.repository.GeneroRepository;
import com.disneyApi.Alkemy.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl implements GeneroService {
    
    @Autowired
    GeneroMapper mapper;
    
    @Autowired
    GeneroRepository repository;
    
    public GeneroDTO save(GeneroDTO dto) {
        GeneroEntity entity = mapper.generoDTO2Entity(dto);
        GeneroEntity entitySaved = repository.save(entity);
        GeneroDTO dtoSaved = mapper.generoEntity2DTO(entitySaved);
        return dtoSaved;
    }
}
