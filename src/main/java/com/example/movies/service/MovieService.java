package com.example.movies.service;

import com.example.movies.model.Movie;
import com.example.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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


    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    //Eliminar
    public void deleteMovie(Integer id) { movieRepository.deleteById(id); }

    //Modificar
    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }


    //Por id
    public Optional<Movie> obtenerPorId (Integer id) { return movieRepository.findById(id); }

    public List<Movie> findClass(String classified) {
        return movieRepository.findClass(classified);
    }

    public List<Movie> findMasVistas() {
        return movieRepository.findMasVistas(PageRequest.of(0,3));
    }

    //public List <Movie> obtenerPorNombre (String title) {return movieRepository.findByName(title); }
}

