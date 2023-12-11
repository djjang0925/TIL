import { useEffect, useState } from "react";

function App() {
  const [loading, setLoading] = useState(true);
  const [movies, setMovies] = useState([]);
  const getMovies = async () => {
    const json = await (
      await fetch(`https://yts.mx/api/v2/list_movies.json?minimum_rating=8.8`)
    ).json();
    setMovies(json.data.movies);
    setLoading(false);
  };

  useEffect(() => {
    getMovies();
  }, []);

  return (
    <div>
      {loading ? (
        <h1>Loading...</h1>
      ) : (
        <div>
          {movies.map((movie) => (
            <div
              key={movie.id}
              style={{
                border: "10px black",
                borderStyle: "double groove",
                borderRadius: "10px",
                margin: "10px",
                padding: "10px",
              }}
            >
              <div style={{width: "100%", textAlign: "center"}}>
                <img src={movie.medium_cover_image} />
              </div>
              <h2>
                {movie.title}({movie.year})
              </h2>
              <p>{movie.summary}</p>
              <ul>
                {movie.genres == null
                  ? ""
                  : movie.genres.map((genre) => <li key={genre}>{genre}</li>)}
              </ul>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}

export default App;
