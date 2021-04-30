package soa.dashboard.model.dto;

/*
    Deze klasse was alleen nodig omdat mijn API een volledig movie object vraagt
    Normaal is dit niet nodig als je gwn je lijst terug geeft
    + te lui om een andere manier te vinden om het op te lossen
 */
public class OnlyMovieObject {

    private MovieDTO movie;

    public OnlyMovieObject() {}

    public OnlyMovieObject(MovieDTO movie) {
        this.setMovie(movie);
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }
}
