package soa.dashboard.model.dto;

import java.util.Objects;

public class MovieDTO {

    private String title;
    private String genre;
    private String director;
    private String release;
    private int duration;
    private String about;

    public MovieDTO() {}

    public MovieDTO(String title, String genre, String director, String release, int duration, String about){
        this.setTitle(title);
        this.setGenre(genre);
        this.setDirector(director);
        this.setRelease(release);
        this.setDuration(duration);
        this.setAbout(about);
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
        return "MovieDTO{" +
                "title='" + title + '\'' +
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
        MovieDTO movieDTO = (MovieDTO) o;
        return duration == movieDTO.duration && Objects.equals(title, movieDTO.title) && Objects.equals(genre, movieDTO.genre) && Objects.equals(director, movieDTO.director) && Objects.equals(release, movieDTO.release) && Objects.equals(about, movieDTO.about);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, director, release, duration, about);
    }
}
