package mk.ukim.finki.wp.lab.model;


import lombok.Data;

@Data
public class Movie {
    String title;
    String summary;
    double rating;
    private Long id;
    Production production;
    public Movie(String title, String summary, double rating, Production production) {
        this.id = (long) (Math.random() * 1000);
        this.title = title;
        this.summary = summary;
        this.rating = rating;
        this.production = production;
    }

}
