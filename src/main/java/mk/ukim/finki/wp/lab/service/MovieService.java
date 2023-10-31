package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    List<Movie> listAll();
    List<Movie> searchMovies(String text);
}
