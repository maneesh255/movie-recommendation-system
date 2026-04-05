package com.movie.service;

import com.movie.config.DataInitializer;
import com.movie.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

@Service
public class MovieService {

    private final List<Movie> movies;

    public MovieService(DataInitializer dataInitializer) {
        this.movies = dataInitializer.getMovies();
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(Long id) {
        return movies.stream()
                .filter(movie -> Objects.equals(movie.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public List<Movie> searchMovies(String query) {
        if (query == null || query.trim().isEmpty()) {
            return getAllMovies();
        }

        String normalizedQuery = normalize(query);
        List<Movie> matchingMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (containsIgnoreCase(movie.getTitle(), normalizedQuery)
                    || containsIgnoreCase(movie.getGenre(), normalizedQuery)) {
                matchingMovies.add(movie);
            }
        }
        return matchingMovies;
    }

    public List<Movie> getRecommendations(Long movieId) {
        Movie movie = getMovieById(movieId);
        if (movie == null) return new ArrayList<>();

        List<Movie> similarMovies = new ArrayList<>();
        for (Movie candidate : movies) {
            if (!Objects.equals(candidate.getId(), movieId)
                    && candidate.getGenre() != null
                    && candidate.getGenre().equalsIgnoreCase(movie.getGenre())) {
                similarMovies.add(candidate);
            }
            if (similarMovies.size() == 5) {
                break;
            }
        }
        return similarMovies;
    }

    public List<Movie> getRecommendationsByHistory(String genres) {
        if (genres == null || genres.trim().isEmpty()) return new ArrayList<>();

        String[] genreArray = genres.split(",");
        Map<Long, Movie> recommended = new LinkedHashMap<>();
        for (String genre : genreArray) {
            String normalizedGenre = normalize(genre);
            if (normalizedGenre.isEmpty()) {
                continue;
            }
            for (Movie movie : movies) {
                if (containsIgnoreCase(movie.getGenre(), normalizedGenre)) {
                    recommended.putIfAbsent(movie.getId(), movie);
                }
            }
        }

        List<Movie> distinctRecommendations = new ArrayList<>(recommended.values());
        return distinctRecommendations.size() > 10
                ? distinctRecommendations.subList(0, 10)
                : distinctRecommendations;
    }

    private String normalize(String value) {
        return value == null ? "" : value.trim().toLowerCase(Locale.ROOT);
    }

    private boolean containsIgnoreCase(String value, String query) {
        return value != null && value.toLowerCase(Locale.ROOT).contains(query);
    }
}
