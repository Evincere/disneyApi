package com.disneyApi.Alkemy.service.impl;

import com.disneyApi.Alkemy.dto.CharacterDTO;
import com.disneyApi.Alkemy.entity.CharacterEntity;
import com.disneyApi.Alkemy.exceptions.ParamNotFound;
import com.disneyApi.Alkemy.mapper.CharacterMapper;
import com.disneyApi.Alkemy.repository.CharacterRepository;
import com.disneyApi.Alkemy.service.CharacterService;
import java.util.List;
import java.util.Optional;
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
        List<CharacterDTO> dtos = characterMapper.characterListEntity2ListDTO(entities, true);
        return dtos;
    }

    @Override
    public CharacterDTO getOneCharacter(Long id) {
        CharacterEntity entity = characterRepository.getById(id);
        CharacterDTO dto = characterMapper.characterEntity2DTO(entity, true);
        return dto;
    }

    @Override
    public CharacterDTO updateCharacter(Long id, CharacterDTO dto) {
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Error: Id de Personaje no válido");
        }
        characterMapper.characterEntityRefreshValues(entity.get(),dto);
        CharacterEntity entityUpdated = characterRepository.save(entity.get());
        CharacterDTO dtoUpdate = characterMapper.characterEntity2DTO(entityUpdated, false);
        return dtoUpdate;
    }

    @Override
    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }
    
}
