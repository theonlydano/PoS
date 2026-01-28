public class Pet {
    private PetType type;
    private String name;
    private int age;

    public void setType(PetType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PetType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "PET [type=" + type + ", name=" + name + ", age=" + age + "]";
    }

    public static void main(String[] args) {
        Pet pet = new Pet();
        pet.setType(PetType.CAT);

        System.out.println(pet);
    }
}
