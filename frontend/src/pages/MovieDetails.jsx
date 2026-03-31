import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { fetchMovieById, getRecommendations } from '../api/api';
import MovieCard from '../components/MovieCard';
import { Star, Heart } from 'lucide-react';

const MovieDetails = () => {
  const { id } = useParams();
  const [movie, setMovie] = useState(null);
  const [recommendations, setRecommendations] = useState([]);
  const [loading, setLoading] = useState(true);
  const [isFavorite, setIsFavorite] = useState(false);

  useEffect(() => {
    const loadDetails = async () => {
      setLoading(true);
      try {
        const data = await fetchMovieById(id);
        setMovie(data);
        
        // Update user history
        if (data && data.genre) {
          let history = localStorage.getItem('movieHistory') || '';
          const genres = history.split(',').filter(Boolean);
          if (!genres.includes(data.genre)) {
            genres.push(data.genre);
            // keep last 5 genres
            if (genres.length > 5) genres.shift();
            localStorage.setItem('movieHistory', genres.join(','));
          }
        }

        const recs = await getRecommendations(id);
        setRecommendations(recs);
      } catch (error) {
        console.error("Failed to load details", error);
      } finally {
        setLoading(false);
      }
    };
    loadDetails();
  }, [id]);

  if (loading) return <div className="loading">Loading details...</div>;
  if (!movie) return <div className="error">Movie not found.</div>;

  return (
    <div>
      <div className="hero-section">
        <img src={movie.posterUrl} alt={movie.title} className="hero-poster" />
        <div className="hero-info">
          <h1 className="hero-title">{movie.title}</h1>
          
          <div className="hero-meta">
            <span className="movie-genre">{movie.genre}</span>
            <span className="movie-rating" style={{ fontSize: '1.2rem' }}>
              <Star size={20} fill="currentColor" />
              {movie.rating.toFixed(1)} / 10
            </span>
          </div>
          
          <p className="hero-desc">{movie.description}</p>
          
          <div style={{ marginTop: 'auto' }}>
            <button 
              className={`btn-secondary ${isFavorite ? 'active' : ''}`}
              onClick={() => setIsFavorite(!isFavorite)}
            >
              <Heart size={20} fill={isFavorite ? 'currentColor' : 'none'} />
              {isFavorite ? 'Remove from Favorites' : 'Add to Favorites'}
            </button>
          </div>
        </div>
      </div>

      {recommendations.length > 0 && (
        <>
          <h2 className="page-title" style={{ fontSize: '1.8rem', marginBottom: '20px' }}>
            More Like This
          </h2>
          <div className="horizontal-scroll">
            {recommendations.map(reco => (
              <MovieCard key={reco.id} movie={reco} />
            ))}
          </div>
        </>
      )}
    </div>
  );
};

export default MovieDetails;
