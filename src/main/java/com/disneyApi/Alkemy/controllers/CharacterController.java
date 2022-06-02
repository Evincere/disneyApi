
package com.disneyApi.Alkemy.controllers;

import com.disneyApi.Alkemy.dto.CharacterDTO;
import com.disneyApi.Alkemy.service.CharacterService;
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
@RequestMapping("character")
public class CharacterController {
    
    @Autowired
    CharacterService characterService;
    
    @PostMapping
    public ResponseEntity<CharacterDTO> saveCharacter(@RequestBody CharacterDTO characterDTO){
        CharacterDTO characterSaved = characterService.save(characterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(characterSaved);
    }
    
    @GetMapping
    public ResponseEntity<List<CharacterDTO>> getAllCharacters(){
        List<CharacterDTO> listCharactersDtos = characterService.getAllCharacters();
        return ResponseEntity.ok().body(listCharactersDtos);
    }
}
