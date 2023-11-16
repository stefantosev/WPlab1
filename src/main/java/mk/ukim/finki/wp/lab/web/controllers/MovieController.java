package mk.ukim.finki.wp.lab.web.controllers;

import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.model.Production;
import mk.ukim.finki.wp.lab.service.impl.MovieServiceImpl;
import mk.ukim.finki.wp.lab.service.impl.ProductionServiceImpl;
import mk.ukim.finki.wp.lab.service.impl.TicketOrderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieServiceImpl movieService;
    private final ProductionServiceImpl productionService;
    private final TicketOrderImpl ticketOrder;

    public MovieController(MovieServiceImpl movieService, ProductionServiceImpl productionService, TicketOrderImpl ticketOrder) {
        this.movieService = movieService;
        this.productionService = productionService;
        this.ticketOrder = ticketOrder;
    }

    @GetMapping
    public String getMoviesPage(@RequestParam(required = false) String error,
                                @RequestParam(required = false) String searchedMovie,
                                @RequestParam(required = false) Double searchedRating,
                                Model model) {

        if(error !=null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Movie> movies = this.movieService.listAll();
        model.addAttribute("Movies", movies);

        if(searchedMovie != null && searchedRating !=null) {
            model.addAttribute("movies", movieService.searchMovieByTitleAndRating(searchedMovie, searchedRating));
        }


        return "listMovies.html";
    }


    @PostMapping("/add")
    public String saveMovie(@RequestParam String title,
                            @RequestParam String summary,
                            @RequestParam Double rating,
                            @RequestParam Long productions,
                            @RequestParam Long id){
        //WORKS
        this.movieService.saveMovie(title, summary, rating, productions, id);
        return "redirect:/movies";
    }

    @GetMapping("/edit-form/{movieId}")
    public String editMovie(@PathVariable Long movieId, Model model){
        //WORKS
        if(this.movieService.findById(movieId).isPresent()){
            Movie movies = this.movieService.findById(movieId).get();
            List<Production> productions = this.productionService.findAll();

            model.addAttribute("productions", productions);
            model.addAttribute("movies", movies);

            return "add-movie.html";
        }

        return "redirect:/movies?error=MovieNotFound";
    }




    @GetMapping("/add-form")
    public String addMoviePage(Model model){
        //WORKS

        List<Production> productions = this.productionService.findAll();
        model.addAttribute("productions", productions);

        return "add-movie.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id){
        //WORKS:
        this.movieService.deleteById(id);
        return "redirect:/movies";
    }


}
