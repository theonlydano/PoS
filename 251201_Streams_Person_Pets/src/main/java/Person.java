import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;

    private List<Pet> pets = new ArrayList<Pet>();

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(PetType type, String name, int age){
        Pet pet = new Pet();
        pet.setType(type);
        pet.setName(name);
        pet.setAge(age);
        this.pets.add(pet);
    }

    public void addPet(Pet pet){
        this.pets.add(pet);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Pet> getPets() {
        return pets;
    }

    // refactoring 2. your turn:
    public boolean hasPet(PetType type) {
        return pets.stream().anyMatch(pet -> pet.getType() == type);
    }

    // refactor PersonGetNameQuecker (myself made)
    public boolean checkName(String name) {
        return this.firstName.equals(name);
    }

    // static inner class Builder
    public static class Builder{
        private String firstName;
        private String lastName;
        private List<Pet> pets = new ArrayList<>();

        public Builder setFirstName(String value){
            this.firstName = value;
            return this;
        }

        public Builder setLastName(String value){
            this.lastName = value;
            return this;
        }

        public Builder setPet(PetType type, String name, int age){
            Pet pet = new Pet();
            pet.setType(type);
            pet.setName(name);
            pet.setAge(age);
            this.pets.add(pet);
            return this;
        }

        public Person build(){
            Person p = new Person();
            p.setFirstName(this.firstName);
            p.setLastName(this.lastName);
            p.setPets(this.pets);
            return p;
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + pets;
    }
}
