package ejercicio2;

public class Ejecutor {
    public static void main(String[] args) {
        // Crear una película en DVD
        DVD dvd = new DVD(5.0);
        Movie dvdMovie = new Movie("InsideOut", "Jeank", 2020, 10, "English", dvd);

        // Crear una película en VHS
        VHS vhs = new VHS("VHS-C");
        Movie vhsMovie = new Movie("El gran Dictador", "Charles Chaplin", 1940, 10, "German", vhs);

        // Mostrar información detallada de las películas
        System.out.println("DVD Movie:");
        System.out.println(dvdMovie); // Esto imprimirá toda la información usando toString()
        System.out.println("DVD Movie Price: " + Movie.calculatePrice(dvdMovie));

        System.out.println("\nVHS Movie:");
        System.out.println(vhsMovie); // Esto imprimirá toda la información usando toString()
        System.out.println("VHS Movie Price: " + Movie.calculatePrice(vhsMovie));
    }
}

// Clase Movie
class Movie {
    private String title;
    private String author;
    private int editionYear;
    private double price;
    private String languages;
    private Support support;

    public Movie(String title, String author, int editionYear, double price, String languages, Support support) {
        this.title = title;
        this.author = author;
        this.editionYear = editionYear;
        this.price = price;
        this.languages = languages;
        this.support = support;
    }
    public double getPrice() {
        return price;
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

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", editionYear=" + editionYear +
                ", price=" + price +
                ", languages='" + languages + '\'' +
                ", support=" + describeSupport() +
                '}';
    }

    private String describeSupport() {
        if (support instanceof DVD) {
            return "DVD with capacity " + ((DVD) support).getCapacityGB() + "GB";
        } else if (support instanceof VHS) {
            return "VHS with tape type " + ((VHS) support).getTypeTape();
        } else {
            return "Unknown support type";
        }
    }
}

// Clase Support 
class Support {
    public Support() {}
}
class DVD extends Support {
    private double capacityGB;

    public DVD(double capacityGB) {
        this.capacityGB = capacityGB;
    }

    public double getCapacityGB() {
        return capacityGB;
    }
}

class VHS extends Support {
    private String typeTape;

    public VHS(String typeTape) {
        this.typeTape = typeTape;
    }

    public String getTypeTape() {
        return typeTape;
    }
}
