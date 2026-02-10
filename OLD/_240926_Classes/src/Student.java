public class Student {
    // instanzvariablen
    //SW: Attributen
    private int id; // auto init with 0
    private String firstName = "unknown";
    private String lastName = "unknown";

    // default
    /*
    public Student(){

    }
    */

    // Constructor - my own
    public Student(String firstName, String lastName){
        setFirstName(firstName);
        this.lastName = lastName;
    }

    // Methode
    // SW: Operation
    public void output(){
        System.out.println("Hello, my id is: " + id);
        System.out.println("My name is");
        System.out.println(firstName + " " + lastName + "\n");
    }

    // Setter
    public void setId(int id){
        this.id = id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
}
