package com.example.movies.controller;

import com.example.movies.model.Movie;
import com.example.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("apiMovie/v1")
@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }

    /*@GetMapping("/movie/{id}")
    public List<Movie> getById(@PathVariable Integer id) {
        return movieService.getById(id);
    }*/

    @PostMapping("/addMovie")
    public Movie createMovie(@RequestBody Movie movie){
        return movieService.createMovie(movie);
    }

    @DeleteMapping("/deleteMovie/{id}")
    public void deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
    }

    @PutMapping("/updateMovie")
    public Movie updateMovie(@RequestBody Movie movie){
        return movieService.updateMovie(movie);
    }

    @GetMapping("/movie/{id}")
    public Optional<Movie> obtenerPorId(@PathVariable("id") Integer id) {
        return this.movieService.obtenerPorId(id);
    }
    /*@GetMapping("/movie/prioridad")
    public List<Movie>obtenerPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        return this.movieService.obtenerPorPrioridad(prioridad);
    }*/

    /*@GetMapping ("/movie/name")
    public List<Movie>ObtenerPorNombre(@PathVariable("title") String title) {
        return this.movieService.obtenerPorNombre(title);
    }*/
}

