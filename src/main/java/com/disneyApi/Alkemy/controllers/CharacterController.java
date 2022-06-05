
package com.disneyApi.Alkemy.controllers;

import com.disneyApi.Alkemy.dto.CharacterDTO;
import com.disneyApi.Alkemy.service.CharacterService;
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
@RequestMapping("/character")
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
    
    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getOneCharacter(@PathVariable Long id){
        CharacterDTO characterDTO = characterService.getOneCharacter(id);
        return ResponseEntity.ok().body(characterDTO);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> updateCharacter(@PathVariable Long id, @RequestBody CharacterDTO dto){
        CharacterDTO dtoUpdate = characterService.updateCharacter(id, dto);
        return ResponseEntity.ok().body(dtoUpdate);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id){
        characterService.deleteCharacter(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
