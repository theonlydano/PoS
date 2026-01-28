import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    public static List<Person> generatePeople(){
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person.Builder()
                .setFirstName("Hans")
                .setLastName("Naja")
                .setPet(PetType.DOG, "Joche", 3)
                .build()
        );

        persons.add(new Person.Builder()
                .setFirstName("Jan")
                .setLastName("Labersack")
                .setPet(PetType.CAT, "creiber", 44)
                .setPet(PetType.DOG, "Miles", 55)
                .build()
        );

        persons.add(new Person.Builder()
                .setFirstName("Jonny")
                .setLastName("Kenneth")
                .setPet(PetType.PIG, "Dolly", 44)
                .setPet(PetType.PIG, "Molly", 55)
                .setPet(PetType.CAT, "Edward", 14)
                .build()
        );

        persons.add(new Person.Builder()
                .setFirstName("Josef")
                .setLastName("Peritsch")
                .setPet(PetType.DOG, "Hidden", 6)
                .build()
        );

        persons.add(new Person.Builder()
                .setFirstName("Georg").setLastName("Kenneth")
                .setPet(PetType.GOAT, "the Goat", 2)
                .build()
        );

        return persons;
    }

    public static void main(String[] args) {
        List<Person> people = generatePeople();

        // your turn: show all in console!
        people.stream()
                .forEach(System.out::println);

        System.out.println("#".repeat(50));

        // your turn: are there any people owning a cat?
        // refactoring: add method to class Person ... (hasPet())
        boolean result = people.stream()
                .anyMatch(person -> person.hasPet(PetType.CAT));

        System.out.println("are people having cats?: " + result);

        boolean result2 = people.stream()
                .anyMatch(person -> person.hasPet(PetType.TURTLE));

        System.out.println("are people having tortois?: " + result2);

        // your turn: count the cat persons!
        Long peopleThatHaveCats = people.stream()
                .filter(person -> person.hasPet(PetType.CAT))
                .count();

        System.out.println("People that have cats: " + peopleThatHaveCats);

        System.out.println("#".repeat(50));
        // your turn: get the list of cat persons and output them
        List<Person> catPeople = people.stream()
                .filter(person -> person.hasPet(PetType.CAT))
                .collect(Collectors.toUnmodifiableList());

        System.out.println("People that have cats: " + catPeople);

        // your tunr: get the list of all non cat persons
        List<Person> notcatPeople = people.stream()
                .filter(person -> !person.hasPet(PetType.CAT))
                .collect(Collectors.toUnmodifiableList());

        System.out.println("People that dont have cats: " + notcatPeople);

        // your turn: get the name of the pet from Hans Naja
        String nameOfNajasPet = people.stream()
                .filter(person -> person.checkName("Hans"))
                .collect(Collectors.toList());


        // your turn

    }
}
