import React, { useEffect, useState } from 'react';
import { fetchMovies, getRecommendationsByHistory } from '../api/api';
import MovieCard from '../components/MovieCard';

const Home = () => {
  const [featuredMovies, setFeaturedMovies] = useState([]);
  const [recommended, setRecommended] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const loadData = async () => {
      try {
        const allMovies = await fetchMovies();
        // Just take the top 6 as featured
        setFeaturedMovies(allMovies.slice(0, 6));

        // Get user history from localStorage
        const history = localStorage.getItem('movieHistory');
        if (history) {
          const recs = await getRecommendationsByHistory(history);
          setRecommended(recs);
        }
      } catch (error) {
        console.error("Failed to fetch home data", error);
      } finally {
        setLoading(false);
      }
    };
    loadData();
  }, []);

  if (loading) return <div className="loading">Loading movies...</div>;

  return (
    <div>
      <h1 className="page-title">Featured Movies</h1>
      <div className="movie-grid">
        {featuredMovies.map(movie => (
          <MovieCard key={movie.id} movie={movie} />
        ))}
      </div>

      {recommended.length > 0 && (
        <div style={{ marginTop: '50px' }}>
          <h2 className="page-title" style={{ fontSize: '1.5rem', marginBottom: '20px' }}>
            Recommended For You
          </h2>
          <div className="horizontal-scroll">
            {recommended.map(movie => (
              <MovieCard key={movie.id} movie={movie} />
            ))}
          </div>
        </div>
      )}
    </div>
  );
};

export default Home;
