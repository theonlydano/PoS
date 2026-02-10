public class World {
    public static void main(String[] args) {
        Utility utility = new Utility();
        Person generatedPerson = utility.generatePerson(12);
        System.out.println(generatedPerson);

        Company c = new Company("HTBLA");

        for(int i = 1; i < 100 - 1; i++){
            Person p = utility.generatePerson(i);
            c.addToEmployees(p);
        }
        //Person davidSundl = utility.generatePerson(12);
        System.out.println(c);
        System.out.println("---------------");

        // your turn: which person earns the highest money amount
        c.addDummyPerson();
        Person highestMoneyPerson = c.getPersonWithHighestMoneyAmount();
        System.out.println(highestMoneyPerson);
    }
}
