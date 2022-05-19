
package com.disneyApi.Alkemy.mapper;

import com.disneyApi.Alkemy.dto.GeneroDTO;
import com.disneyApi.Alkemy.entity.GeneroEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GeneroMapper {
    
    public GeneroEntity generoDTO2Entity(GeneroDTO dto){
        GeneroEntity entity = new GeneroEntity();
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        return entity;
    }
    
    public GeneroDTO generoEntity2DTO(GeneroEntity entity){
        GeneroDTO dto = new GeneroDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());
        return dto;
    }

    public List<GeneroDTO> generoListEntity2DTO(List<GeneroEntity> entities) {
        List<GeneroDTO> dtos = new ArrayList<>();
        for(GeneroEntity entity : entities){
            dtos.add(this.generoEntity2DTO(entity));
        }
        return dtos;
    }
}
