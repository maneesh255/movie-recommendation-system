package com.movie.repository;

import com.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    List<Movie> findByTitleContainingIgnoreCase(String title);
    
    List<Movie> findByGenreContainingIgnoreCase(String genre);
    
    List<Movie> findByTitleContainingIgnoreCaseOrGenreContainingIgnoreCase(String title, String genre);
    
    List<Movie> findByRatingGreaterThanEqual(Double rating);
    
    List<Movie> findByGenreAndIdNot(String genre, Long id);
}
