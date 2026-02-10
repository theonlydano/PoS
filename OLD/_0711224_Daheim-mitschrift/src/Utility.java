import java.util.Random;

public class Utility {
    private String[] firstnames = new String[10];
    private String[] lastnames = new String[10];
    private String[] streets = new String[10];
    private String[] cities = new String[10];
    Random random;


    public Utility(){
        generateFirstNames();
        generateLastNames();
        generateStreets();
        generateCity();
    }

    private void generateFirstNames(){
        firstnames[0] = "Hans";
        firstnames[1] = "Herbert";
        firstnames[2] = "Klaus";
        firstnames[3] = "Axel";
        firstnames[4] = "Martina";
        firstnames[5] = "Gerda";
        firstnames[6] = "Jörg-Otoo";
        firstnames[7] = "Bea";
        firstnames[8] = "Michaela";
        firstnames[9] = "Silke";
    }

    private void generateLastNames(){
        lastnames[0] = "Loaner";
        lastnames[1] = "Hansworth";
        lastnames[2] = "Mittgard";
        lastnames[3] = "Vanek-Rupp";
        lastnames[4] = "Martbauaer";
        lastnames[5] = "Gandalf";
        lastnames[6] = "Pichler";
        lastnames[7] = "Geruda";
        lastnames[8] = "Jamnisch";
        lastnames[9] = "Solver";
    }
    private void generateStreets(){
        streets[0] = "Schreiberweg";
        streets[1] = "Hagenbauerweg";
        streets[2] = "Mitgawer";
        streets[3] = "Borgendswald";
        streets[4] = "Haulerner";
        streets[5] = "Gehweg";
        streets[6] = "Waldweg";
        streets[7] = "Bergweg";
        streets[8] = "Pichlerregerweg";
        streets[9] = "Gerwalderweg";
    }
    private void generateCity(){
        cities[0] = "Graz";
        cities[1] = "Leibnitz";
        cities[2] = "Muenchen";
        cities[3] = "Wien";
        cities[4] = "Paris";
        cities[5] = "Koeln";
        cities[6] = "Hamburg";
        cities[7] = "Salzburg";
        cities[8] = "Schreibmannshausen";
        cities[9] = "Vanala";
    }
    private Address generateAddress(String street, int id, int plz, String city){
        Address a = new Address(street, id, plz, city);
        return a;
    }

    // your turn: generate randomly lastnames and random adresses

    public Person generatePerson(int id){
        String firstName = "unknown";
        String surName = "unknown";
        String street = "unknown";
        String city = "unknown";

        random = new Random();
        int randomIndex = random.nextInt(firstnames.length);
        firstName = firstnames[randomIndex];
        surName = lastnames[randomIndex];
        street = streets[randomIndex];
        city = cities[randomIndex];

        Address address = generateAddress(street, random.nextInt(10,150), random.nextInt(8000, 8999), city);

        Person person = new Person(id, firstName, surName);
        person.setAddress(address);

        person.setSalery(random.nextFloat(1200,4800));

        return person;
    }
}
