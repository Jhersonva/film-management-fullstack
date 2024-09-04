package com.apirest.gestion.peliculas.service;

import com.apirest.gestion.peliculas.exception.ResourceNotFoundException;
import com.apirest.gestion.peliculas.model.Pelicula;
import com.apirest.gestion.peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

//Service para la implementacion de la lógica
@Service
public class PeliculaService {

    //Inyectando la dependecia de la interfaz PeliculaRepository
    @Autowired
    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    //Método para Listar las películas y Paginarlos
    public Page<Pelicula> getAllPeliculas(Pageable pageable) {
        return peliculaRepository.findAll(pageable);
    }

    //Méodo para crear una película
    public Pelicula createPelicula(Pelicula pelicula){
        return peliculaRepository.save(pelicula);
    }

    //Método para mostrar una película por su ID
    public Pelicula getPeliculaById(Long id){
        return peliculaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pelicula not found"));
    }

    //Método para actualizar los datos de una pelicula según el ID
    public Pelicula updatePelicula(Long id, Pelicula peliculaDetails){
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pelicula not fount"));
        pelicula.setTitulo(peliculaDetails.getTitulo());
        pelicula.setDirector(peliculaDetails.getDirector());
        pelicula.setGenero(peliculaDetails.getGenero());
        return peliculaRepository.save(pelicula);
    }

    //Método para eliminar una película según el ID
    public void deletePelicula(Long id){
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pelicula not fount"));
        peliculaRepository.delete(pelicula);
    }
}
