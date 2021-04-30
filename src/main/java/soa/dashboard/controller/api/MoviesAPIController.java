package soa.dashboard.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import soa.dashboard.model.dto.MovieDTO;
import soa.dashboard.model.entity.Movie;
import soa.dashboard.model.service.MoviesAPIService;
import java.util.List;

@Controller
@RequestMapping("/dashboard/api/movies")
public class MoviesAPIController {

    private final MoviesAPIService service;

    @Autowired
    public MoviesAPIController(WebClient moviesAPI){
        this.service = new MoviesAPIService(moviesAPI);
    }


    /*
        READ
    */
    @GetMapping
    public String getOverviewMovies(Model model){
        List<Movie> movies = this.service.read();
        model.addAttribute("movies",movies);
        return "api-movies";
    }
    @GetMapping("/{id}")
    public String showOneMovie(@PathVariable int id, Model model){
        model.addAttribute("movie",this.service.readOne(id));
        return "api-movies-movie";
    }


    /*
        CREATE
    */
    @GetMapping("/new")
    public String getNewMovie(Model model){
        model.addAttribute("movie",new MovieDTO());
        return "api-movies-new";
    }
    @PostMapping("/new")
    public String postNewMovie(
                               @RequestParam(name = "title") String title,
                               @RequestParam(name = "genre") String genre,
                               @RequestParam(name = "director") String director,
                               @RequestParam(name = "release") String release,
                               @RequestParam(name = "duration") int duration,
                               @RequestParam(name = "about") String about
                              ){
        /*
            @ModelAttribute MovieDTO movie
            Werkt niet om één of andere reden?
        */
        MovieDTO gotfromhtml = new MovieDTO(title, genre, director, release, duration, about);
        MovieDTO receivedMovie = this.service.create(gotfromhtml);
        return "redirect:/dashboard/api/movies";
    }


    /*
        UPDATE
    */
    @GetMapping("/{id}/update")
    public String getUpdateMovie(@PathVariable int id, Model model){
        Movie movie = this.service.readOne(id);
        model.addAttribute("id",id);
        model.addAttribute("movie",movie);
        return "api-movies-update";
    }
    @PostMapping("/{id}/update")
    public String postUpdateMovie(
                                  @PathVariable int id,
                                  @RequestParam(name = "title") String title,
                                  @RequestParam(name = "genre") String genre,
                                  @RequestParam(name = "director") String director,
                                  @RequestParam(name = "release") String release,
                                  @RequestParam(name = "duration") int duration,
                                  @RequestParam(name = "about") String about
                                 ){
        /*
            @ModelAttribute MovieDTO movie
            Werkt niet om één of andere reden?
        */
        MovieDTO gotfromhtml = new MovieDTO(title, genre, director, release, duration, about);
        MovieDTO receivedMovie = this.service.update(id,gotfromhtml);
        return "redirect:/dashboard/api/movies/" + id;
    }


    /*
        DELETE
    */
    @GetMapping("/{id}/delete")
    public String deleteMovie(@PathVariable int id){
        this.service.delete(id);
        return "redirect:/dashboard/api/movies";
    }

}
