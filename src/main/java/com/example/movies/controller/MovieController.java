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



    @PostMapping("/addMovie")
    public Movie createMovie(@RequestBody Movie movie){
        return movieService.createMovie(movie);
    }

    @DeleteMapping("/deleteMovie/{id}")
    public void deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
    }

    @PutMapping("/updateMovie")
    public Optional<Movie>updateMovie(@RequestBody Movie movie) {
        Movie mo = movieService.updateMovie(movie);
        Optional<Movie> opt= Optional.ofNullable(mo);
        return opt;
    }

    @GetMapping("/movie/{id}")
    public Optional<Movie> obtenerPorId(@PathVariable("id") Integer id) {
        return this.movieService.obtenerPorId(id);
    }


    /*@GetMapping ("/movie/{title}")
    public List<Movie>obtenerPorNombre(@PathVariable String title) {
        return movieService.obtenerPorNombre(title);
    }*/
}

