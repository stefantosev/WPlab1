package mk.ukim.finki.wp.lab.model;


import lombok.Data;

@Data
public class Production {
    private Long id;
    private String name;
    private String country;
    private String address;

    public Production(String name, String country, String address) {
        this.id = (long) (Math.random() *1000);
        this.name = name;
        this.country = country;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format(" %s, %s, %s", name, country, address);
    }
}
