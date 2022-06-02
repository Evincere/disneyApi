
package com.disneyApi.Alkemy.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "personaje")
@Getter
@Setter
@SQLDelete(sql = "UPDATE icon SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class CharacterEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String name;
    private int age;
    private double weight;
    private String image;
    private String history;
    /**
     * uno o varios personajes pueden estar en una o varias peliculas
     * la relacion va a estar mapeada por la propiedad del otro lado "listPersonajes"
     * el dueño de la relacion va a ser filmEntity
     */
    @ManyToMany(mappedBy = "listCharacters", cascade = CascadeType.ALL) 
    private List<FilmEntity> listFilms = new ArrayList<>();
    
    private boolean deleted = Boolean.FALSE;

}
