
package com.disneyApi.Alkemy.controllers;

import com.disneyApi.Alkemy.dto.GeneroDTO;
import com.disneyApi.Alkemy.service.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;
    
    /**
     * saveGenero
     * endpoint para guardar un genero
     * @param genero DTO
     * @return GeneroDTO
     */
    @PostMapping
    public ResponseEntity<GeneroDTO> saveGenero(@RequestBody GeneroDTO genero) {
        GeneroDTO generoSaved = generoService.save(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoSaved);
    }
    
    /**
     * getAll
     * ENDPOINT TRAER TODOS LOS GENEROS
     * @return 
     */
    @GetMapping
    public ResponseEntity<List<GeneroDTO>> getAll(){
        List<GeneroDTO> dtos = generoService.getAllGeneros();
        return ResponseEntity.ok().body(dtos);
    }
    
    
}
