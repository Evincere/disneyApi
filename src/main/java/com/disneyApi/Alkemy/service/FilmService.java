
package com.disneyApi.Alkemy.service;

import com.disneyApi.Alkemy.dto.FilmDTO;
import java.util.List;


public interface FilmService {

    FilmDTO saveFilm(FilmDTO filmDTO);

    List<FilmDTO> getAllFilms();

    FilmDTO getOneFilm(Long id);

    FilmDTO updateFilm(Long id, FilmDTO filmDTO);

    void deleteFilm(Long id);
    
}
