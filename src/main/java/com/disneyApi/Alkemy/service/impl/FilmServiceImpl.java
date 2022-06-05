
package com.disneyApi.Alkemy.service.impl;

import com.disneyApi.Alkemy.dto.FilmDTO;
import com.disneyApi.Alkemy.entity.FilmEntity;
import com.disneyApi.Alkemy.exceptions.ParamNotFound;
import com.disneyApi.Alkemy.mapper.FilmMapper;
import com.disneyApi.Alkemy.repository.FilmRepository;
import com.disneyApi.Alkemy.service.FilmService;
import java.util.List;
import java.util.Optional;
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

    @Override
    public FilmDTO getOneFilm(Long id) {
        FilmDTO dto = filmMapper.filmEntity2DTO(filmRepository.getById(id), true);
        return dto;
    }

    @Override
    public FilmDTO updateFilm(Long id, FilmDTO filmDTO) {
        Optional<FilmEntity> entity = filmRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Error: Id de Film no válido");
        }
        filmMapper.filmEntityRefreshValues(entity.get(),filmDTO);
        FilmEntity entityUpdated = filmRepository.save(entity.get());
        FilmDTO dto = filmMapper.filmEntity2DTO(entityUpdated, true);
        return dto;
    }

    @Override
    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }

    

    

}
