package mk.ukim.finki.wp.lab.repository;


import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class MovieRepository {

    public static List<Movie> movies;

    @PostConstruct  //MUST
    public void init(){
        movies = new ArrayList<>();
        movies.add(new Movie("Captain America 4" , "best movie", 4.4));
        movies.add(new Movie("Hercules" , "best movie", 6.1));
        movies.add(new Movie("The shining" , "best movie", 5.5));
        movies.add(new Movie("God of war" , "best movie", 7.1));
        movies.add(new Movie("Blue beetle" , "best movie", 5.0));
        movies.add(new Movie("Captain America 1" , "best movie", 7.7));
        movies.add(new Movie("Star Wars" , "best movie", 2.2));
        movies.add(new Movie("Indiana Jones" , "best movie", 4.5));
        movies.add(new Movie("Interstellar" , "best movie", 4.0));
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


}
