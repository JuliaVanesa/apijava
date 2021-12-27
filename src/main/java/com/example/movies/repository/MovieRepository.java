package com.example.movies.repository;

import com.example.movies.model.Movie;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    /*public abstract List<Movie>findByPrioridad(Integer prioridad);*/
    /*List<Movie>findByName(String title);*/
    @Query ("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
    List <Movie>findByName(@Param("title") String title);

    @Query ("SELECT m FROM Movie m WHERE m.classified LIKE %:classified%")
    List<Movie> findClass(@Param("classified") String classified);

    @Query ("SELECT m FROM  Movie m ORDER BY m.rate DESC")
    List<Movie> findMasVistas(PageRequest pageRequest);
}