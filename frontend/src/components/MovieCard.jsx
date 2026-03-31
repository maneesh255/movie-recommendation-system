import React from 'react';
import { Link } from 'react-router-dom';
import { Star } from 'lucide-react';

const MovieCard = ({ movie }) => {
  return (
    <Link to={`/movie/${movie.id}`} className="movie-card">
      <img src={movie.posterUrl} alt={movie.title} className="movie-poster" />
      <div className="movie-info">
        <h3 className="movie-title">{movie.title}</h3>
        <div className="movie-meta">
          <span className="movie-genre" style={{ marginRight: '5px' }}>{movie.genre}</span>
          {movie.language && (
            <span className="movie-genre" style={{ backgroundColor: 'rgba(163, 113, 247, 0.1)', color: '#a371f7' }}>
              {movie.language}
            </span>
          )}
          <span className="movie-rating" style={{ marginLeft: 'auto' }}>
            <Star size={14} fill="currentColor" />
            {movie.rating.toFixed(1)}
          </span>
        </div>
      </div>
    </Link>
  );
};

export default MovieCard;
