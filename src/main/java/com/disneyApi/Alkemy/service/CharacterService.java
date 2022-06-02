
package com.disneyApi.Alkemy.service;

import com.disneyApi.Alkemy.dto.CharacterDTO;
import java.util.List;


public interface CharacterService {

    CharacterDTO save(CharacterDTO characterDTO);

    List<CharacterDTO> getAllCharacters();
    
}
