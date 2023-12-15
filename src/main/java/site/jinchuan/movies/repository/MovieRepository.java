package site.jinchuan.movies.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import site.jinchuan.movies.model.Movie;

import java.util.Optional;

/*
    === Annotation Explain ===
    Repository: Frameworks knows this class is a repository

*/

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    Optional<Movie> findMovieByImdbId(String imdbId);
}
