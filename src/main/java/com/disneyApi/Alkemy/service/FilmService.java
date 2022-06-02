
package com.disneyApi.Alkemy.service;

import com.disneyApi.Alkemy.dto.FilmDTO;
import java.util.List;


public interface FilmService {

    FilmDTO saveFilm(FilmDTO filmDTO);

    List<FilmDTO> getAllFilms();
    
}
