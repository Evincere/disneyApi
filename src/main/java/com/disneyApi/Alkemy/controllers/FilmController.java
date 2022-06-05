
package com.disneyApi.Alkemy.controllers;

import com.disneyApi.Alkemy.dto.FilmDTO;
import com.disneyApi.Alkemy.repository.FilmRepository;
import com.disneyApi.Alkemy.service.FilmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/films")
public class FilmController {
    
    
    @Autowired
    FilmService filmService;
    @Autowired
    FilmRepository filmRepository;
    
    /**
     * ENDPOINT: /films/saveFilm 
     * save film
     * @param filmDTO DTO
     * @return filmDTO
     */
    @PostMapping
    public ResponseEntity<FilmDTO> saveFilm(@RequestBody FilmDTO filmDTO) {
        FilmDTO filmSaved = filmService.saveFilm(filmDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmSaved);
    }
    
    @GetMapping
    public ResponseEntity<List<FilmDTO>> getAllFilms(){
      List<FilmDTO> dtos = filmService.getAllFilms();
      return ResponseEntity.ok().body(dtos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FilmDTO> getOneFilm(@PathVariable Long id){
        FilmDTO dto = filmService.getOneFilm(id);
        return ResponseEntity.ok().body(dto);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<FilmDTO> updateFilm(
            @PathVariable Long id,@RequestBody FilmDTO filmDTO){
        FilmDTO filmDTOUpdated = filmService.updateFilm(id,filmDTO);
        return ResponseEntity.ok().body(filmDTOUpdated);
    }
    
    @DeleteMapping("/{id}")
     public ResponseEntity<Void> deleteFilm(@PathVariable Long id){
        filmService.deleteFilm(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
