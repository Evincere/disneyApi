
package com.disneyApi.Alkemy.service;

import com.disneyApi.Alkemy.dto.CharacterDTO;
import java.util.List;


public interface CharacterService {

    CharacterDTO save(CharacterDTO characterDTO);

    List<CharacterDTO> getAllCharacters();

    CharacterDTO getOneCharacter(Long id);

    CharacterDTO updateCharacter(Long id, CharacterDTO dto);

    void deleteCharacter(Long id);
    
}
