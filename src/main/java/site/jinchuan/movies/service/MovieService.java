package site.jinchuan.movies.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.jinchuan.movies.repository.MovieRepository;
import site.jinchuan.movies.model.Movie;

import java.util.List;
import java.util.Optional;

/*
    === Annotation Explain ===

 */

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    // Using Optional here because the search movie by id may return null
    // Here the return value either being a movie or null
    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
