import java.sql.Time;
import java.util.Scanner;

public class World {
    public static void main(String[] args) {
        System.out.println("#### Uebung #####");

        Person person = new Person(3,2,1);
        person.setDate(2008,10,10);

        person.setName("Noah Daniel");
        person.setSocialSecurityNumber();

        person.output();
    }
}