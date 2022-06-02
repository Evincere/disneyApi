package com.disneyApi.Alkemy.mapper;

import com.disneyApi.Alkemy.dto.GeneroDTO;
import com.disneyApi.Alkemy.entity.GeneroEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneroMapper {

    @Autowired
    FilmMapper filmMapper;

    /**
     * generoDTO to Entity
     *
     * @param dto
     * @param loadFilms
     * @return GeneroEntity
     */
    public GeneroEntity generoDTO2Entity(GeneroDTO dto, boolean loadFilms) {
        GeneroEntity entity = new GeneroEntity();
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        if (loadFilms) {
            entity.setListFilms(filmMapper.filmListDTO2ListEntity(dto.getListFilms()));
        }

        return entity;
    }

    public GeneroDTO generoEntity2DTO(GeneroEntity entity, boolean loadFilms) {
        GeneroDTO dto = new GeneroDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());
        if (loadFilms) {
            dto.setListFilms(filmMapper.filmListEntity2ListDTO(entity.getListFilms(),true));
        }
        return dto;
    }

    public List<GeneroDTO> generoListEntity2DTO(List<GeneroEntity> entities) {
        List<GeneroDTO> dtos = new ArrayList<>();
        entities.forEach(entity -> {
            dtos.add(this.generoEntity2DTO(entity,true));
        });
        return dtos;
    }
}
