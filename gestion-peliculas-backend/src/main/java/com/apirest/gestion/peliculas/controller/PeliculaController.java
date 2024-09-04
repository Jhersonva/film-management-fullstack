package com.apirest.gestion.peliculas.controller;

import com.apirest.gestion.peliculas.model.Pelicula;
import com.apirest.gestion.peliculas.service.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//Controller PeliculaController para manejar las solicitudes HTTP
@RestController
@RequestMapping("/api/pelicula")
@Validated
public class PeliculaController {

    //Realizando una inyeccion de dependecias del servicio PeliculaService
    @Autowired
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    //endpoint para listar las peliculas paginadas
    @GetMapping("/list")
    public Page<Pelicula> getAllPeliculas(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return peliculaService.getAllPeliculas(pageable);
    }

    //endpoint para la creacion de peliculas
    @PostMapping("/create")
    public Pelicula createPelicula(@Valid @RequestBody Pelicula pelicula){
        Pelicula nuevaPelicula = peliculaService.createPelicula(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPelicula).getBody();
    }

    //endpoint para obtener pelicula por id
    @GetMapping("/{id}")
    public Pelicula getPeliculaById(@PathVariable Long id){
        return peliculaService.getPeliculaById(id);
    }

    //endpoint para actualizar datos de la pelicula segun el id
    @PutMapping("/{id}")
    public Pelicula updatePelicula(@PathVariable Long id, @RequestBody Pelicula peliculaDetails){
        return peliculaService.updatePelicula(id, peliculaDetails);
    }

    //endpoint para eliminar una pelicula por el id
    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable Long id){
        peliculaService.deletePelicula(id);
    }
}
