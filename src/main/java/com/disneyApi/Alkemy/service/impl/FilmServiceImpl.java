
package com.disneyApi.Alkemy.service.impl;

import com.disneyApi.Alkemy.dto.FilmDTO;
import com.disneyApi.Alkemy.entity.FilmEntity;
import com.disneyApi.Alkemy.mapper.FilmMapper;
import com.disneyApi.Alkemy.repository.FilmRepository;
import com.disneyApi.Alkemy.service.FilmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmMapper filmMapper;
    @Autowired
    FilmRepository filmRepository;

    /**
     * saveFilm
     * @param filmDTO
     * @return FilmDTO
     */
    public FilmDTO saveFilm(FilmDTO filmDTO) {
        FilmEntity entity = filmMapper.filmDTO2Entity(filmDTO, true);
        return filmMapper.filmEntity2DTO(filmRepository.save(entity), true);
    }

    /**
     * getAllFilms
     * @return List<FilmDTO>
     */
    public List<FilmDTO> getAllFilms() {
        List<FilmEntity> entities = filmRepository.findAll();
        List<FilmDTO> dtos = filmMapper.filmListEntity2ListDTO(entities, true);
        return dtos;
        
    }

    

    

}
