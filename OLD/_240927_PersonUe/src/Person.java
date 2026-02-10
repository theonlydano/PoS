import java.sql.Time;
import java.util.Random;

public class Person {
    private String name = "unknown";
    private int year = 1;
    private int month = 1;
    private int day = 1;
    private String socialSecurityNumber = "unknown";

    public Person(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String theName) {
        this.name = theName;
    }

    public String date() {
        return this.year + "-" + this.month + "-" + this.day;
    }

    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        Random random = new Random();
        /*int number = random.nextInt(1,10_000);
        this.socialSecurityNumber = number+"";*/
    }

    public void setSocialSecurityNumber() {
        this.socialSecurityNumber = "1234" + this.year %100 + this.month + this.day;
    }

    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    public void output(){
        System.out.println("Name: " + this.name);
        System.out.println("Birthday " + this.year + "-" + this.month + "-" + this.day);
        System.out.println("Social Security Number: " + this.socialSecurityNumber);
    }
}
