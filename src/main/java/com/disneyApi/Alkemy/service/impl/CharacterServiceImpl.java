package com.disneyApi.Alkemy.service.impl;

import com.disneyApi.Alkemy.dto.CharacterDTO;
import com.disneyApi.Alkemy.entity.CharacterEntity;
import com.disneyApi.Alkemy.mapper.CharacterMapper;
import com.disneyApi.Alkemy.repository.CharacterRepository;
import com.disneyApi.Alkemy.service.CharacterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterMapper characterMapper;
    @Autowired
    CharacterRepository characterRepository;
    
    @Override
    public CharacterDTO save(CharacterDTO characterDTO) {
        CharacterEntity characterEntity = characterMapper.characterDTO2Entity(characterDTO, true);
        CharacterDTO characterDTOSaved = characterMapper.characterEntity2DTO(characterRepository.save(characterEntity),true);
        return characterDTOSaved;
    }

    @Override
    public List<CharacterDTO> getAllCharacters() {
        List<CharacterEntity> entities = characterRepository.findAll();
        List<CharacterDTO> dtos = characterMapper.characterListEntity2ListDTO(entities);
        return dtos;
    }
    
}
