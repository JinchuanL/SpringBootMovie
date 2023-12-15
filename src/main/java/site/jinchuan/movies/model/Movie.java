package site.jinchuan.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

/*
    === Annotation Explain ===
    Data: Take care of all getter,setter and toString methods
    AllArgsConstructor: Constructor takes all these private fields as arguments
    NoArgsConstructor: Constructor takes no arguments
    DocumentReference: Only store the ids of the review and reviews will be in a separate collection

    === UML Relationship ===
    movie 1 ------ * reviews

*/

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference
    private List<Review> reviewIds;


}
