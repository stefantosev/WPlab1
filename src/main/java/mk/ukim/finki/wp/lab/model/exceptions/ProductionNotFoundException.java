package mk.ukim.finki.wp.lab.model.exceptions;

public class ProductionNotFoundException extends RuntimeException{
    public ProductionNotFoundException(){
        super("Production not found");
    }
}
