package com.disneyApi.Alkemy.dto;

import com.disneyApi.Alkemy.entity.FilmEntity;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDTO {

    private Long id;
    private String name;
    private int age;
    private double weight;
    private String image;
    private String history;
    private List<FilmDTO> listFilms;
}
