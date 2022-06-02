
package com.disneyApi.Alkemy.service.impl;

import com.disneyApi.Alkemy.dto.GeneroDTO;
import com.disneyApi.Alkemy.entity.GeneroEntity;
import com.disneyApi.Alkemy.mapper.GeneroMapper;
import com.disneyApi.Alkemy.repository.GeneroRepository;
import com.disneyApi.Alkemy.service.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl implements GeneroService {
    
    @Autowired
    GeneroMapper generoMapper;
    
    @Autowired
    GeneroRepository generoRepository;
    
    /**
     * save Genero
     * @param dto
     * @return GeneroDTO
     */
    public GeneroDTO save(GeneroDTO dto) {
        GeneroEntity entity = generoMapper.generoDTO2Entity(dto, true);
        GeneroEntity entitySaved = generoRepository.save(entity);
        GeneroDTO dtoSaved = generoMapper.generoEntity2DTO(entitySaved, true);
        return dtoSaved;
    }

    public List<GeneroDTO> getAllGeneros() {
        List<GeneroEntity> entities = generoRepository.findAll();
        List<GeneroDTO> dtos = generoMapper.generoListEntity2DTO(entities);
        return dtos;
    }
}
