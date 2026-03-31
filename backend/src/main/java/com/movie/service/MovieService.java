package com.movie.service;

import com.movie.entity.Movie;
import com.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> searchMovies(String query) {
        if (query == null || query.trim().isEmpty()) {
            return getAllMovies();
        }
        return movieRepository.findByTitleContainingIgnoreCaseOrGenreContainingIgnoreCase(query, query);
    }

    public List<Movie> getRecommendations(Long movieId) {
        Movie movie = getMovieById(movieId);
        if (movie == null) return new ArrayList<>();

        // Content-based recommendation based on exact genre match excluding the current movie
        // In a real scenario, this logic could be more complex (e.g., comparing multiple keywords).
        List<Movie> similarMovies = movieRepository.findByGenreAndIdNot(movie.getGenre(), movieId);
        
        // Return top 5 recommendations
        return similarMovies.stream()
                .limit(5)
                .collect(Collectors.toList());
    }
    
    public List<Movie> getRecommendationsByHistory(String genres) {
        if(genres == null || genres.trim().isEmpty()) return new ArrayList<>();
        
        String[] genreArray = genres.split(",");
        List<Movie> recommended = new ArrayList<>();
        for (String genre : genreArray) {
            recommended.addAll(movieRepository.findByGenreContainingIgnoreCase(genre.trim()));
        }
        
        // Return distinct top 10 recommended
        return recommended.stream()
                .distinct()
                .limit(10)
                .collect(Collectors.toList());
    }
}
