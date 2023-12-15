package site.jinchuan.movies.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.jinchuan.movies.model.Movie;
import site.jinchuan.movies.service.MovieService;

import java.util.List;
import java.util.Optional;

/*
    === Annotation Explain ===
    RestController: Annotate this class as restController
    RequestMapping("/api/v1/movies"): Any request to /api/v1/movies endpoint will be handled by this restController
    PathVariable: Let framework know we will be passing the information we got in the mapping as a path variable

    === HttpStatus ===
    OK: status code 200

    === Testing ===
    cmd: curl -i http://localhost:8080/api/v1/movies

    Response:
    HTTP/1.1 200
    Content-Type: text/plain;charset=UTF-8
    Content-Length: 11
    Date: Thu, 14 Dec 2023 10:28:09 GMT

    All movies!%

*/

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }

    // Search a movie by its ID
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}
