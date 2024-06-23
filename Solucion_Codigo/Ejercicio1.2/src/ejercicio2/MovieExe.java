package ejercicio2;
import java.util.ArrayList;
import java.util.Arrays;

public class MovieExe {
    public static void main(String[] args) {
        DVD dvdFormat = new DVD(5);
        VHS vhsFormat = new VHS("Cinrta Standar");
        Format objFormat = new Format();
        ArrayList<Movie> movieList = new ArrayList<Movie>(Arrays.asList(
                                     new Movie("Inside Out 2", "ElRicky", 2024, 7, "English", objFormat),
                                     new Movie("Bad Boys", "Venequin", 2024, 7, "English", vhsFormat),
                                     new Movie("EndGame", "Jenak", 2024, 7, "English", dvdFormat)
                                     ));
        for (Movie mov : movieList) {
            System.out.println(mov);
        }
    }
    
    
}

class Movie{
    public String title;
    public String author;
    public int editionYear;
    public double price;
    public String language;
    public Format format;

    public Movie(String title, String author, int editionYear, double price, String language, Format format) {
        this.title = title;
        this.author = author;
        this.editionYear = editionYear;
        this.price = price;
        this.language = language;
        this.format = format;
    }
    
    public void calcuRentCost(){
        
    }

    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", author=" + author + ", editionYear=" + editionYear + ", price=" + price + ", language=" + language + ", format=" + format + '}';
    }
    
}
class Format{
    
}
class DVD extends Format{
    public double capacityGB;

        public DVD(double capacityGB) {
            this.capacityGB = capacityGB;
        }
    

    @Override
    public String toString() {
        return "DVD{" + "capacityGB=" + capacityGB + '}';
    }
    
}
class VHS extends Format{
    public String typeTape;

        public VHS(String typeTape) {
            this.typeTape = typeTape;
        }

        @Override
        public String toString() {
            return "VHS{" + "typeTape=" + typeTape + '}';
        }
    
    
}