package mk.ukim.finki.wp.lab.repository;


import jakarta.annotation.PostConstruct;
//import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.model.Production;
import mk.ukim.finki.wp.lab.model.exceptions.ProductionNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class MovieRepository {

    public static List<Movie> movies;

    @PostConstruct  //MUST
    public void init(){
        movies = new ArrayList<>();

        Production production1 = new Production("MARVEL","USA", "NY NY");
        Production production2 = new Production("WARNER BROS","USA", "Washington DC");



        movies.add(new Movie("Captain America 4" , "best movie", 4.4, production1));
        movies.add(new Movie("Hercules" , "best movie", 6.1, production1));
        movies.add(new Movie("The shining" , "best movie", 5.5, production2));
        movies.add(new Movie("God of war" , "best movie", 7.1, production1));
        movies.add(new Movie("Blue beetle" , "best movie", 5.0, production2));
        movies.add(new Movie("Captain America 1" , "best movie", 7.7, production1));
        movies.add(new Movie("Star Wars" , "best movie", 2.2,production2));
        movies.add(new Movie("Indiana Jones" , "best movie", 4.5, production2));
        movies.add(new Movie("Interstellar" , "best movie", 4.0, production1));
    }


    public List<Movie> findAll() {
      return movies;
    }


    //site da gi najdeme po tekst i ime
    public List<Movie> searchMovies(String text) {
        return movies.stream()
                .filter(m -> m.getTitle().contains(text)  || m.getSummary().contains(text))  //vajda treba i summarry
                .collect(Collectors.toList());
    }


    public Optional<Movie> findById(Long id){
        return movies.stream()
                .filter(m -> m.getId().equals(id)).findFirst();
    }

    public Optional<Movie> saveMovie(String title, String summary, double rating, Production productionId, Long id){
        if(productionId == null ){
            throw new ProductionNotFoundException();
        }




        Movie movie = new Movie(title, summary, rating , productionId);

        // For new movies
        if (id != 0) {
            movie.setId(id);
        }

        movies.removeIf(m -> m.getId().equals(movie.getId()));
        movies.add(movie);
        return Optional.of(movie);
    }

    public List<Movie> searchMovieByTitleAndRating(String title, double rating){
        return movies.stream()
                .filter(m -> m.getTitle().contains(title)  && m.getRating() >= rating)  //vajda treba i summarry
                .collect(Collectors.toList());
    }

    public  void deleteId(Long id){
        movies.removeIf(m->m.getId().equals(id));
    }

}

