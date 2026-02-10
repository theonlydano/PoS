import java.util.Scanner;

public class UseClasses {
    public static void main(String[] args){
        Student myStudent;
        Student myStudentTwo;

        myStudent = new Student("Albert","Einstein");
        myStudentTwo = new Student("Nils", "Bohr");

        myStudent.output();
        myStudentTwo.output();

        myStudent.setId(21);
        myStudentTwo.setId(34);

        myStudent.setFirstName("Hans Herbert");
        myStudent.setLastName("Hensler");

        myStudent.output();
        myStudentTwo.output();

    }
}
