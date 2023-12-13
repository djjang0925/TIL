import PropTypes from "prop-types"

import { Link } from "react-router-dom";

const Movie = ({ id, coverImg, title, year, summary, genres }) => {
  return (
    <div>
      <div
        style={{
          border: "10px black",
          borderStyle: "double groove",
          borderRadius: "10px",
          margin: "10px",
          padding: "10px",
        }}
      >
        <div style={{ width: "100%", textAlign: "center" }}>
          <img src={coverImg} alt="post" />
        </div>
        <h2>
          <Link to={`/movie/${id}`}>{title}</Link>
          ({year})
        </h2>
        <p>{summary}</p>
        <ul>
          {genres == null
            ? ""
            : genres.map((genre) => <li key={genre}>{genre}</li>)}
        </ul>
      </div>
    </div>
  );
};

Movie.propTypes = {
  id: PropTypes.number.isRequired,
  coverImg: PropTypes.string.isRequired,
  title: PropTypes.string.isRequired,
  summary: PropTypes.string.isRequired,
  genres: PropTypes.arrayOf(PropTypes.string).isRequired
}

export default Movie;
