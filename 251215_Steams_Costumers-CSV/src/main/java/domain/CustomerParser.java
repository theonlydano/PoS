package domain;

import java.util.Optional;

public class CustomerParser {

    public Optional<Customer> parse(String csv) {
        String[] parts = csv.split(",");
        return Optional.of(new Customer(parts[0], parts[1], parts[2], Integer.parseInt(parts[3])));
    }
}
