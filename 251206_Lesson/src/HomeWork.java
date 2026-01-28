import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class HomeWork {

    public List<Product> books(String category, double price) {
        // Obtain a list of products belongs to category “Books” with price > 100
        List<Product> products = DataModel.getInstance().getProducts();

        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .filter(p -> p.getPrice() > price)
                .collect(Collectors.toList());
    }

    public List<Order> babies(String category){
        // Obtain a list of order with products belong to category “Baby”

        return DataModel.getInstance().getOrders().stream()
                .filter(o -> o.getProducts().stream()
                        .anyMatch(p -> p.getCategory().equalsIgnoreCase(category)))
                .toList();
    }

    public List<Product> discount(List<Product> products){
        // Obtain a list of all Toys with a price reduction of 10%
    return products.stream()
            .filter(p -> p.getCategory().equalsIgnoreCase("toys"))
            .map(p -> { // use peek() also: similar to foreach, but intermedial
                p.setPrice(p.getPrice()*0.9);
                return p;
            })
            .toList();
    }

    public List<Product> tier2(List<Order> orders){
        // Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-LLL-yyyy"); // L means months as text
        LocalDate start = LocalDate.parse("01-Feb-2021", dtf);
        LocalDate end = LocalDate.parse("01-Apr-2021", dtf);
        return orders.stream()
                .filter(o -> o.customer.tier() == 2)
                .filter(o -> o.date.isAfter(start) && o.date.isBefore(end))
                .flatMap(o -> o.getProducts().stream()) // order -> List of products -> flatMaps
                .toList();
    }
    /*
    public Product cheapest(List<Product> products){
        // Get the cheapest products of “Books” category

    }

    public List<Order> getNextThree(List<Order> orders){
        //Get the 3 most recent orders

    }
    */

    public static void main(String[] args) {
        HomeWork streamExamples = new HomeWork();
        //streamExamples.books("baby", 500.0).stream().forEach(System.out::println);
        //streamExamples.babies("baby").stream().forEach(System.out::println);
        //streamExamples.discount(DataModel.getInstance().getProducts()).stream().forEach(System.out::println);
        streamExamples.tier2(DataModel.getInstance().getOrders()).stream().forEach(System.out::println);
        //System.out.println(streamExamples.cheapest(DataModel.getInstance().getProducts()));
        //streamExamples.getNextThree(DataModel.getInstance().getOrders()).stream().forEach(System.out::println);
    }
}
