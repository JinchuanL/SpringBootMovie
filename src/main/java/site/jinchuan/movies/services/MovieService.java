package site.jinchuan.movies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.jinchuan.movies.MovieRepository;
import site.jinchuan.movies.models.Movie;

import java.util.List;

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
}
