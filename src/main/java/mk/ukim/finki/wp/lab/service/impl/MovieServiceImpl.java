package mk.ukim.finki.wp.lab.service.impl;


import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.model.Production;
import mk.ukim.finki.wp.lab.model.exceptions.ProductionNotFoundException;
import mk.ukim.finki.wp.lab.repository.MovieRepository;
import mk.ukim.finki.wp.lab.repository.ProductionRepository;
import mk.ukim.finki.wp.lab.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    //zavisnost
    private final MovieRepository inMemoryRepo;
    private final ProductionRepository productionRepository;
    public MovieServiceImpl(MovieRepository inMemoryRepo, ProductionRepository productionRepository) {
        this.inMemoryRepo = inMemoryRepo;
        this.productionRepository = productionRepository;
    }

    @Override
    public List<Movie> listAll() {
        return inMemoryRepo.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text) {
        return inMemoryRepo.searchMovies(text);
    }

    @Override
    public List<Movie> searchMovieByTitleAndRating(String title, Double rating) {
        return inMemoryRepo.searchMovieByTitleAndRating(title, rating);
    }

    @Override
    public void deleteById(Long id) {
        this.inMemoryRepo.deleteId(id);
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return inMemoryRepo.findById(id);
    }

    @Override
    public Optional<Movie> saveMovie(String title, String summary, double rating, Long productionId, Long movieId) {
        Production production = this.productionRepository.findById(productionId).orElseThrow(ProductionNotFoundException::new);
        return inMemoryRepo.saveMovie(title, summary, rating, production, movieId);
    }
}
