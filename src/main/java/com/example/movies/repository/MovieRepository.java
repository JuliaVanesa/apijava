package com.example.movies.repository;

import com.example.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    /*public abstract List<Movie>findByPrioridad(Integer prioridad);*/
    /*List<Movie>findByName(String title);*/
}