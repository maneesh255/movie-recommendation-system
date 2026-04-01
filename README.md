# Movie Recommendation System

A full-stack movie recommendation system built with **Spring Boot** (Backend) and **React** (Frontend).
The database is MySQL.

## Features
- **Home Page**: Featured movies and "Recommended For You" based on your local search/viewing history.
- **Movie Details**: View movie posters, genres, description, and "More Like This" recommendations.
- **Search**: Search movies by title or genre.
- **Favorites**: Add movies to favorites dynamically.
- **Responsive UI**: Aesthetic dark-mode UI with beautiful hover states and layouts.
- **Backend Content-Based Filtering**: The backend suggests movies based on similar genres and dynamically learns from history passed by the frontend.
- **Sample Data**: The backend automatically populates sample movies via `DataInitializer` on startup.

---

## Prerequisites
- **Java 17+**
- **Maven**
- **Node.js (v18+)**
- **MySQL Server** (running on port `3306`)

---

## How to Run in VS Code

### 1. Database Setup
Ensure your local MySQL server is running. The application is configured to connect via user `root` with no password (`""`), and it will automatically create the database `movie_db` if it doesn't exist.
- If your MySQL uses a different username or password, open `backend/src/main/resources/application.properties` and update `spring.datasource.username` and `spring.datasource.password`.

### 2. Run the Backend (Spring Boot)
1. Open a new terminal in VS Code (`Ctrl + \`` or `Cmd + \``).
2. Navigate to the backend folder:
   ```bash
   cd backend
   ```
3. Run the Spring Boot application using the Maven Wrapper:
   ```bash
   mvnw spring-boot:run
   ```
   *Note: If you get "mvnw: command not found", use `mvn spring-boot:run` assuming Maven is installed globally.*
   
   The backend will start on `http://localhost:8080`.

### 3. Run the Frontend (React)
1. Open a **second terminal** in VS Code.
2. Navigate to the frontend folder:
   ```bash
   cd frontend
   ```
3. Run the Vite development server:
   ```bash
   npm run dev
   ```
   The frontend will start. Check the terminal for the exact URL, usually it is `http://localhost:5173`. 
   
CTRL + Click the local URL in the terminal to open the application in your browser!

The Vite dev server now proxies `/api` requests to `http://127.0.0.1:8080`, so the frontend and backend work together locally without changing the frontend API URL.

## Deployment

This project is set up to deploy as a single service on Render:

1. Push this repository to GitHub.
2. Create a new Blueprint or Web Service on Render from the repo.
3. Render will use the root `Dockerfile` and `render.yaml`.
4. When Render prompts for environment variables, set:
   - `SPRING_DATASOURCE_URL`
   - `SPRING_DATASOURCE_USERNAME`
   - `SPRING_DATASOURCE_PASSWORD`
5. After the first successful deploy, the app will be available at your Render service URL.

If the service name `movie-recommendation-system` is available in Render, the app URL is typically:

```text
https://movie-recommendation-system.onrender.com
```

Note: the repository no longer stores live database credentials. Keep your real database values only in Render environment variables.

## API Endpoints (Backend)
- `GET /api/movies` : All movies
- `GET /api/movies/{id}` : Single movie by id
- `GET /api/movies/search?query=text` : Search by title or genre
- `GET /api/movies/{id}/recommendations` : Content-based recommendations for a specific movie
- `GET /api/movies/recommendations/history?genres=text` : Personal recommendations based on viewing history
