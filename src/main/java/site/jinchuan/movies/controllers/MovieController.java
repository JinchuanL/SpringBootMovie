package site.jinchuan.movies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.jinchuan.movies.models.Movie;
import site.jinchuan.movies.services.MovieService;

import java.util.List;

/*
    === Annotation Explain ===
    RestController: Annotate this class as restController
    RequestMapping("/api/v1/movies"): Any request to /api/v1/movies endpoint will be handled by this restController

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
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }
}
