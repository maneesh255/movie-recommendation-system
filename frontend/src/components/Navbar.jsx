import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Film, Search } from 'lucide-react';

const Navbar = () => {
  const [query, setQuery] = useState('');
  const navigate = useNavigate();

  const handleSearch = (e) => {
    e.preventDefault();
    if (query.trim()) {
      navigate(`/search?query=${query}`);
    }
  };

  return (
    <nav className="navbar">
      <div className="container nav-content">
        <Link to="/" className="brand">
          <Film color="#58a6ff" />
          MovieRec
        </Link>
        
        <form onSubmit={handleSearch} style={{ display: 'flex', gap: '10px', flexGrow: 0.5, maxWidth: '400px' }}>
          <input
            type="text"
            className="search-input"
            placeholder="Search movies..."
            value={query}
            onChange={(e) => setQuery(e.target.value)}
          />
          <button type="submit" className="btn-primary" style={{ padding: '10px 15px' }}>
            <Search size={18} />
          </button>
        </form>

        <div className="nav-links">
          <Link to="/" className="nav-link">Home</Link>
          <Link to="/movies" className="nav-link">All Movies</Link>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
