
package com.disneyApi.Alkemy.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "film")
@Getter
@Setter
@SQLDelete(sql = "UPDATE pais SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class FilmEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String image;
    private String title;
    
    @Column(name="fecha_estreno")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaEstreno;
    
    private int calification[]={1,2,3,4,5};
    
    //una o muchas peliculas van a tener solo un genero
    //inicializacion de tipo temprana (fetch tipo EAGER) cuando se pida una pelicula va a volver con su genero
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "genero_id", insertable = false, updatable = false)  //insertable, updatable ¿?               
    private GeneroEntity genero;
    //con generoId se define el genero al que pertenece y con la definicion anterior
    //se vincula ese generoId a un genero entidad
    @Column(name = "genero_id", nullable = false)
    private Long generoId;
    
    //una o muchas peliculas van a tener uno o varios personajes
    //cuando se crea el film se puede pasar una lista de personajes y se crea la relacion
    //el dueño de la relacion va a ser filmEntity
    // en las relaciones @ManyToMany los registros son independientes de los registros 
    // a los que son relacionados, por lo que en este caso, podrían existir las 
    // peliculas si no existieran los personajes, y al revés.
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST, //las operaciones de guardado en la base de datos 
                                         // de la entidade Film se propagarán a las entidades relacionadas en listPersonajes
                    CascadeType.MERGE  //si se actualiza FilmEntity se propaga la accion y se actualizan los objetos existente en la base de datos
            })
    @JoinTable(
            name = "personaje_film",
            joinColumns = @JoinColumn(name = "film_id"), //se utiliza para marcar una propiedad la cual requiere de un JOIN para poder accederla 
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private Set<PersonajeEntity> listPersonajes = new HashSet<>(); //para poder acceder a listPersonajes es necesario la informacion de la tabla join
    
    

    
    
    private boolean deleted = Boolean.FALSE;

}
