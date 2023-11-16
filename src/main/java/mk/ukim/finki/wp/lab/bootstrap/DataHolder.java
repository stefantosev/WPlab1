//package mk.ukim.finki.wp.lab.bootstrap;
//
//import jakarta.annotation.PostConstruct;
//import mk.ukim.finki.wp.lab.model.Movie;
//import mk.ukim.finki.wp.lab.model.Production;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DataHolder {
//    public  static List<Production> productions = null;
//    public static List<Movie> movies = null;
//
//    @PostConstruct  //MUST
//    public void init(){
//        productions = new ArrayList<>();
//        Production production1 = new Production("MARVEL","USA", "NY NY");
//        Production production2 = new Production("WARNER BROS","USA", "Washington DC");
//
//        productions.add(production1);
//        productions.add(production2);
//
//        movies.add(new Movie("Captain America 4" , "best movie", 4.4, production1));
//        movies.add(new Movie("Hercules" , "best movie", 6.1, production1));
//        movies.add(new Movie("The shining" , "best movie", 5.5, production2));
//        movies.add(new Movie("God of war" , "best movie", 7.1, production1));
//        movies.add(new Movie("Blue beetle" , "best movie", 5.0, production2));
//        movies.add(new Movie("Captain America 1" , "best movie", 7.7, production1));
//        movies.add(new Movie("Star Wars" , "best movie", 2.2,production2));
//        movies.add(new Movie("Indiana Jones" , "best movie", 4.5, production2));
//        movies.add(new Movie("Interstellar" , "best movie", 4.0, production1));
//    }
//}
