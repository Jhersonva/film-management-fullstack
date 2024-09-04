package com.apirest.gestion.peliculas.repository;

import com.apirest.gestion.peliculas.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio para interactuar con la base de datos
@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
