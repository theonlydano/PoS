public class Person {
    private String firstName;
    private String surName;
    private int id;
    private float salery;

    private Address address; // diese Referenzvariable zeigt auf 0x0 (null)

    public Person(int id, String firstName, String surName) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return this.surName;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }

    public float getSalery() {
        return this.salery;
    }
    public void setSalery(float salery) {
        this.salery = salery;
    }

    public Address getAddress() {
        return this.address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.firstName + " " + this.surName + String.format("(%10.2f)", this.salery));
        sb.append(this.address);

        return sb.toString();
    }

    public void main(String[] args) {
        Address a = new Address("Leopoldstrasse", 23, 80634, "München");
        Person p = new Person(1, "Albert", "Einstein");
        System.out.println(p);
    }
}