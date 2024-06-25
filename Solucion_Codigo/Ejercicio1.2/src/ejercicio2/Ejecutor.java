package ejercicio2;
import java.util.Arrays;
import java.util.List;

public class Ejecutor  {
    public static void main(String[] args) {
        // Crear una película en DVD
        DVD dvd = new DVD(5.0);
        List<String> dvdLanguages = Arrays.asList("English", "Spanish");
        Movie dvdMovie = new Movie("Movie Title", "Movie Author", 2020, 3.0, dvdLanguages, dvd);

        // Crear una película en VHS
        VHS vhs = new VHS("VHS-C");
        List<String> vhsLanguages = Arrays.asList("English");
        Movie vhsMovie = new Movie("VHS Movie Title", "VHS Movie Author", 1990, 2.0, vhsLanguages, vhs);

        // Calcular precios
        System.out.println("DVD Movie Price: " + Movie.calculatePrice(dvdMovie));
        System.out.println("VHS Movie Price: " + Movie.calculatePrice(vhsMovie));
    }
}

// Clase Movie
class Movie {
    private String title;
    private String author;
    private int editionYear;
    private double price;
    private List<String> languages;
    private Support support;

    public Movie(String title, String author, int editionYear, double price, List<String> languages, Support support) {
        this.title = title;
        this.author = author;
        this.editionYear = editionYear;
        this.price = price;
        this.languages = languages;
        this.support = support;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getEditionYear() {
        return editionYear;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public Support getSupport() {
        return support;
    }

    public static double calculatePrice(Movie movie) {
        if (movie.getSupport() instanceof DVD) {
            return movie.getPrice() * 1.1;
        } else {
            return movie.getPrice();
        }
    }
}

class Support {
    public Support() {}
}

// Clase DVD que hereda de Support
class DVD extends Support {
    private double capacityGB;

    public DVD(double capacityGB) {
        this.capacityGB = capacityGB;
    }

    public double getCapacityGB() {
        return capacityGB;
    }
}

// Clase VHS que hereda de Support
class VHS extends Support {
    private String typeTape;

    public VHS(String typeTape) {
        this.typeTape = typeTape;
    }

    public String getTypeTape() {
        return typeTape;
    }
}
