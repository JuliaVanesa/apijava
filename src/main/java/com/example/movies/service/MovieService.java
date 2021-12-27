package com.example.movies.service;

import com.example.movies.model.Movie;
import com.example.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    //public List <Movie> getById(Integer id) {return movieRepository.findAllById(id);}

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Integer id) { movieRepository.deleteById(id); }

    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> obtenerPorId (Integer id) { return movieRepository.findById(id); }

    /*public List<Movie> obtenerPorPrioridad(Integer prioridad) { return movieRepository.findByPrioridad(prioridad); }*/

    /*public List <Movie> obtenerPorNombre (String title) {return movieRepository.findByName(title); }*/
}

