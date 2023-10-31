package mk.ukim.finki.wp.lab.service.impl;


import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.repository.MovieRepository;
import mk.ukim.finki.wp.lab.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    //zavisnost
    private final MovieRepository inMemoryRepo;

    public MovieServiceImpl(MovieRepository inMemoryRepo) {
        this.inMemoryRepo = inMemoryRepo;
    }

    @Override
    public List<Movie> listAll() {
        return inMemoryRepo.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text) {
        return inMemoryRepo.searchMovies(text);
    }
}
