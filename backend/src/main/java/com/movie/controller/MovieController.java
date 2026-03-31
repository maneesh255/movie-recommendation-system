package com.movie.controller;

import com.movie.entity.Movie;
import com.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam(required = false) String query) {
        return ResponseEntity.ok(movieService.searchMovies(query));
    }

    @GetMapping("/{id}/recommendations")
    public ResponseEntity<List<Movie>> getRecommendations(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getRecommendations(id));
    }

    @GetMapping("/recommendations/history")
    public ResponseEntity<List<Movie>> getRecommendationsByHistory(@RequestParam String genres) {
        return ResponseEntity.ok(movieService.getRecommendationsByHistory(genres));
    }
}
