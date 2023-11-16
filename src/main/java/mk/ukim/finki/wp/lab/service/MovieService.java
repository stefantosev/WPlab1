package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.model.Production;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface MovieService {
    List<Movie> listAll();
    List<Movie> searchMovies(String text);

    List<Movie> searchMovieByTitleAndRating(String title, Double rating);

    void deleteById(Long id);
    public Optional<Movie> findById(Long id);

    public  Optional<Movie> saveMovie(String title, String summary, double rating, Long productionId, Long movieId);
}
