package com.apirest.gestion.peliculas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

//Creando mi entidad pelicula
@Entity
@Table(name = "pelicula")
public class Pelicula {

    //Creando atributos y evaluando los campos.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @Column(nullable = false)
    @NotBlank(message = "El director es obligatorio")
    private String director;

    @Column(nullable = false)
    @NotBlank(message = "El género es obligatorio")
    private String genero;


    //Creacion de Getter and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
