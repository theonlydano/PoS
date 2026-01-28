import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Order {
    private Integer id;
    public LocalDate date;
    public LocalDate delivery;
    private String status;
    private Integer customerId;

    // Set -> Collection keine Dupletten (doppelten Einträge)
    Set<Product> products = new HashSet<>();
    public Customer customer; // Backreference

    public Order(Integer id, String date, String delivery, String status, Integer customerId) {
        this.id = id;
        this.date = LocalDate.parse(date);
        this.delivery = LocalDate.parse(delivery);
        this.status = status;
        this.customerId = customerId;
    }

    public void addProduct(Product p){
        products.add(p);
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", delivery=" + delivery +
                ", status='" + status + '\'' +
                ", customerId=" + customerId +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
