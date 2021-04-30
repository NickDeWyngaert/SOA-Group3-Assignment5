package soa.dashboard.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import soa.dashboard.model.dto.DataMovie;
import soa.dashboard.model.dto.MovieDTO;
import soa.dashboard.model.dto.OnlyMovieObject;
import soa.dashboard.model.entity.Movie;
import java.time.Duration;
import java.util.List;

@Service
public class MoviesAPIService {

    @Autowired
    private final WebClient moviesAPI;

    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(10); // Dit hoeft niet

    @Autowired
    public MoviesAPIService(WebClient moviesAPI){ this.moviesAPI = moviesAPI; }

    public List<Movie> read() { return this.requestAllMovies().getData(); }
    private DataMovie requestAllMovies(){
        return moviesAPI
                .get()
                .uri("/")
                .retrieve()
                .bodyToMono(DataMovie.class)
                .block(REQUEST_TIMEOUT);
    }

    public Movie readOne(int id){ return requestOneMovie(id); }
    private Movie requestOneMovie(int id){
        return moviesAPI
                .get()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(Movie.class)
                .block(REQUEST_TIMEOUT);
    }

    public MovieDTO create(MovieDTO movie) { return requestCreateMovie(movie); }
    private MovieDTO requestCreateMovie(MovieDTO movie){
        return moviesAPI
                .post()
                .uri("/")
                .body(Mono.just(new OnlyMovieObject(movie)), OnlyMovieObject.class)
                .retrieve()
                .bodyToMono(MovieDTO.class)
                .block(REQUEST_TIMEOUT);
    }

    public MovieDTO update(int id, MovieDTO movie) { return requestUpdateMovie(id,movie); }
    private MovieDTO requestUpdateMovie(int id, MovieDTO movie){
        return moviesAPI
                .put()
                .uri("/" + id)
                .body(Mono.just(new OnlyMovieObject(movie)), OnlyMovieObject.class)
                .retrieve()
                .bodyToMono(MovieDTO.class)
                .block(REQUEST_TIMEOUT);
    }

    public void delete(int id) { this.requestDeleteMovie(id); }
    private void requestDeleteMovie(int id){
        moviesAPI
                .delete()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(Void.class)
                .block(REQUEST_TIMEOUT);
    }

}
