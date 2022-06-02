package com.disneyApi.Alkemy.mapper;

import com.disneyApi.Alkemy.dto.FilmDTO;
import com.disneyApi.Alkemy.entity.FilmEntity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {

    @Autowired
    CharacterMapper characterMapper;

    /**
     * mapeador FILM DTO TO ENTITY
     */
    public FilmEntity filmDTO2Entity(FilmDTO dto, boolean loadCharacters) {
        FilmEntity entity = new FilmEntity();
        entity.setGeneroId(dto.getGeneroId());
        entity.setTitle(dto.getTitle());
        entity.setImage(dto.getImage());
        entity.setCalification(dto.getCalification());
        entity.setFechaEstreno(this.string2LocalDate(dto.getFechaEstreno()));
        if (loadCharacters) {
            entity.setListCharacters(characterMapper.characterListDTO2ListEntity(dto.getListCharacters(), false));
        }
        return entity;
    }

    /**
     * mapeador FILM ENTITY TO DTO
     *
     * @param entity Film
     * @return FilmDTO
     */
    public FilmDTO filmEntity2DTO(FilmEntity entity, boolean loadCharacters) {
        FilmDTO dto = new FilmDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setTitle(entity.getTitle());
        dto.setCalification(entity.getCalification());
        dto.setFechaEstreno(entity.getFechaEstreno().toString());
        dto.setGeneroId(entity.getGeneroId());
        if (loadCharacters) {
            dto.setListCharacters(characterMapper.characterListEntity2ListDTO(entity.getListCharacters()));
        }
        return dto;
    }

    /**
     * String to LocalDate
     */
    public LocalDate string2LocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return date;
    }

    /**
     * lista de entidades TO lista de DTOs films
     *
     * @param entities
     * @param loadCharacters
     * @return List<FilmDTO>
     */
    public List<FilmDTO> filmListEntity2ListDTO(List<FilmEntity> entities, boolean loadCharacters) {
        List<FilmDTO> dtos = new ArrayList<>();
        for (FilmEntity entity : entities) {
            dtos.add(this.filmEntity2DTO(entity, loadCharacters));
        }
        return dtos;
    }

    /**
     * ListDTO TO ListEntity
     *
     * @param dtos
     * @return Set<FilmEntity>
     */
    public List<FilmEntity> filmListDTO2ListEntity(List<FilmDTO> listFilmsDtos) {
        List<FilmEntity> filmListEntities = new ArrayList<>();
        for (FilmDTO dto : listFilmsDtos) {
            filmListEntities.add(this.filmDTO2Entity(dto, false));
        }
        return filmListEntities;
    }

    

}
