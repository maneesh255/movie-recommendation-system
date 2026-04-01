import axios from 'axios';

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL || '/api/movies';

export const fetchMovies = async () => {
    const response = await axios.get(API_BASE_URL);
    return response.data;
};

export const fetchMovieById = async (id) => {
    const response = await axios.get(`${API_BASE_URL}/${id}`);
    return response.data;
};

export const searchMovies = async (query) => {
    const response = await axios.get(`${API_BASE_URL}/search?query=${query}`);
    return response.data;
};

export const getRecommendations = async (id) => {
    const response = await axios.get(`${API_BASE_URL}/${id}/recommendations`);
    return response.data;
};

export const getRecommendationsByHistory = async (genres) => {
    const response = await axios.get(`${API_BASE_URL}/recommendations/history?genres=${genres}`);
    return response.data;
};
