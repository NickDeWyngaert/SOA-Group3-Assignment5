package soa.dashboard.model.entity;

import java.util.Objects;

public class Movie {

    private int id;
    private String title;
    private String genre;
    private String director;
    private String release;
    private int duration;
    private String about;

    public Movie() {}

    public Movie(int id, String title, String genre, String director, String release, int duration, String about){
        this.setId(id);
        this.setTitle(title);
        this.setGenre(genre);
        this.setDirector(director);
        this.setRelease(release);
        this.setDuration(duration);
        this.setAbout(about);
    }

    public int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    private void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }
    private void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }
    private void setDirector(String director) {
        this.director = director;
    }

    public String getRelease() {
        return release;
    }
    private void setRelease(String release) {
        this.release = release;
    }

    public int getDuration() {
        return duration;
    }
    private void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", release=" + release +
                ", duration=" + duration +
                ", about='" + about + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && duration == movie.duration && Objects.equals(title, movie.title) && Objects.equals(genre, movie.genre) && Objects.equals(director, movie.director) && Objects.equals(release, movie.release);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, director, release, duration);
    }
}
