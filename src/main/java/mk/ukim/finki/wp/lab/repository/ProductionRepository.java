package mk.ukim.finki.wp.lab.repository;

import jakarta.annotation.PostConstruct;
//import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.model.Production;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductionRepository {

    List<Production> productions;

    @PostConstruct  //MUST
    public void init(){
        productions = new ArrayList<>();
        Production production1 = new Production("MARVEL","USA", "NY NY");
        Production production2 = new Production("WARNER BROS","USA", "Washington DC");

        productions.add(production1);
        productions.add(production2);
    }


//    private List<Production> productions;
//
    public Optional<Production> findById(Long id){
        return productions.stream().filter(m -> m.getId().equals(id)).findFirst();
    }
    public List<Production> findAll(){
        return productions;
    }

}
