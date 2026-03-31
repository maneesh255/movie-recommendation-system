import React, { useEffect, useState } from 'react';
import { useParams, useSearchParams } from 'react-router-dom';
import { searchMovies } from '../api/api';
import MovieCard from '../components/MovieCard';

const SearchResults = () => {
  const [movies, setMovies] = useState([]);
  const [loading, setLoading] = useState(true);
  const [searchParams] = useSearchParams();
  const query = searchParams.get('query');

  useEffect(() => {
    const doSearch = async () => {
      setLoading(true);
      try {
        if (query) {
          const results = await searchMovies(query);
          setMovies(results);
        } else {
          setMovies([]);
        }
      } catch (error) {
        console.error("Search failed", error);
      } finally {
        setLoading(false);
      }
    };
    doSearch();
  }, [query]);

  return (
    <div>
      <h1 className="page-title">Search Results for "{query}"</h1>
      {loading ? (
        <div className="loading">Searching...</div>
      ) : movies.length > 0 ? (
        <div className="movie-grid">
          {movies.map(movie => (
            <MovieCard key={movie.id} movie={movie} />
          ))}
        </div>
      ) : (
        <p style={{ color: 'var(--text-secondary)' }}>No movies found matching your query.</p>
      )}
    </div>
  );
};

export default SearchResults;
