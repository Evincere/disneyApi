package com.disneyApi.Alkemy.mapper;

import com.disneyApi.Alkemy.dto.CharacterDTO;
import com.disneyApi.Alkemy.entity.CharacterEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {

    @Autowired
    FilmMapper filmMapper;
    @Autowired
    CharacterMapper characterMapper;

    public CharacterEntity characterDTO2Entity(CharacterDTO dto, boolean loadFilms) {
        CharacterEntity entity = new CharacterEntity();
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        entity.setAge(dto.getAge());
        entity.setHistory(dto.getHistory());
        entity.setWeight(dto.getWeight());
        if (loadFilms) {
            entity.setListFilms(filmMapper.filmListDTO2ListEntity(dto.getListFilms()));
        }
        return entity;
    }

    public CharacterDTO characterEntity2DTO(CharacterEntity entity, boolean loadFilms) {
        CharacterDTO dto = new CharacterDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());
        dto.setHistory(entity.getHistory());
        dto.setWeight(entity.getWeight());
        if (loadFilms) {
            dto.setListFilms(filmMapper.filmListEntity2ListDTO(entity.getListFilms(), true));
        }

        return dto;
    }

    public List<CharacterEntity> characterListDTO2ListEntity(List<CharacterDTO> listDTOCharacters, boolean loadCharacters) {
        List<CharacterEntity> listCharacterEntities = new ArrayList<>();
        for (CharacterDTO dto : listDTOCharacters) {
            listCharacterEntities.add(this.characterDTO2Entity(dto,loadCharacters));
        }
        return listCharacterEntities;
    }

    public List<CharacterDTO> characterListEntity2ListDTO(List<CharacterEntity> listCharacterEntities) {
        List<CharacterDTO> listCharacterDtos = new ArrayList<>();
        for (CharacterEntity entity : listCharacterEntities) {
            listCharacterDtos.add(characterMapper.characterEntity2DTO(entity, false));
        }
        return listCharacterDtos;
    }
}
