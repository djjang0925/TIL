import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import MovieDetail from "../components/MovieDetail";

const Detail = () => {
  const { id } = useParams();

  const [loading, setLoading] = useState(true);
  const [movie, setMovie] = useState();

  const getMovie = async () => {
    const json = await (
      await fetch(`https://yts.mx/api/v2/movie_details.json?movie_id=${id}`)
    ).json();
    setMovie(json.data.movie);
    setLoading(false);
  };

  useEffect(() => {
    getMovie();
  }, );

  return (
    <div>
      {loading ? <h1>Loading...</h1> : <MovieDetail title={movie.title} />}
    </div>
  );
};

export default Detail;
