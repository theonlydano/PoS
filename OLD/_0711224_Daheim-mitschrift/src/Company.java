public class Company {
    private String name;
    private Person[] employees;
    private Person[] boardOfDirectors;
    private Person p;

    public static int counterOfEmployees = 0;
    public static int counterOfDirectors = 0;

    public Company(String name) {
        this.name = name;
        this.employees = new Person[1000];
        this.boardOfDirectors = new Person[10];
    }

    public void addToEmployees(Person person) {
        this.employees[counterOfEmployees++] = person;
    }

    public void addToBordOfDirectors(Person person) {
        this.boardOfDirectors[counterOfDirectors++] = person;
    }

    public Person getPersonWithHighestMoneyAmount(){
        Person p = employees[0];
        for(int i = 1; i < employees.length - 1; i++) {
            Person temp = employees[i];
            if(p.getSalery() > temp.getSalery()) {
                p = temp;
            }
        }
        return p;
    }
    public void addDummyPerson(){
         Utility utility = new Utility();
         Person p = utility.generatePerson(112);
         p.setSalery(5500.f);
         
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Company: " + this.name);
        sb.append("\n------------------------------\n");
        for (int i = 0; i < counterOfEmployees; i++) {
            sb.append("\n\n" + employees[i].toString());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Person p = new Person(12, "Ernst", "Huber");
        Address a = new Address("Strasse", 12, 8430, "Kaindorf");
        p.setAddress(a);
        Company c = new Company("HTBLA Kaindorf");
        c.addToEmployees(p);

        System.out.println(c);
    }
}