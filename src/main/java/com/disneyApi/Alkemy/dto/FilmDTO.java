package com.disneyApi.Alkemy.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FilmDTO {
    
    private Long id;
    private String image;
    private String title;
    private String fechaEstreno;
    private int calification;
    private Long generoId;
    private List<CharacterDTO> listCharacters;
}
