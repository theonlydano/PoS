import java.util.Scanner;

public class Birthdate {
    private int day;
    private int month;
    private int year;
    private String monthName;
    private String dayOfYear;
    private double weekdayNumber;
    private String weekdayName;
    private int yearFistNumbers;
    private int yearLastNumbers;
    Scanner scanner = new Scanner(System.in);

    public void input(){
        System.out.println("Enter your birthday:");
        do {
            System.out.print("Day: ");
            day = scanner.nextInt();

            System.out.print("Month: ");
            month = scanner.nextInt();
        }while(day>31 || month>12);

        System.out.print("Year: ");
        year = scanner.nextInt();

    }
    public void compute(){
        switch(month){
            case 1:
                monthName = "January";
                break;

            case 2:
                monthName = "February";
                break;

            case 3:
                monthName = "March";
                break;

            case 4:
                monthName = "April";
                break;

            case 5:
                monthName = "May";
                break;

            case 6:
                monthName = "June";
                break;

            case 7:
                monthName = "July";
                break;

            case 8:
                monthName = "August";
                break;

            case 9:
                monthName = "September";
                break;

            case 10:
                monthName = "October";
                break;

            case 11:
                monthName = "November";
                break;

            case 12:
                monthName = "December";
                break;

            default:
                monthName = "Invalid month";
                break;
        }
        yearFistNumbers = year/100;
        yearLastNumbers = year%100;
        dayOfYear = "" + ((month - 1) * 30 + day);
        weekdayNumber = ((day+(2.6 * month - 0.2) + yearLastNumbers + (yearLastNumbers/4)+(yearFistNumbers/4)-(2*yearLastNumbers))%7);
        switch((int)weekdayNumber){
            case 1:
                weekdayName = "Monday";
                break;
            case 2:
                weekdayName = "Tuesday";
                break;
            case 3:
                weekdayName = "Wednesday";
                break;
            case 4:
                weekdayName = "Thursday";
                break;
            case 5:
                weekdayName = "Friday";
                break;
            case 6:
                weekdayName = "Saturday";
                break;
            case 7:
                weekdayName = "Sunday";
                break;
            default:
                weekdayName = "Invalid weekday";
                break;
        }
    }
    public void output(){
        System.out.println("Your birthdate is: " + day + "." + monthName + "." + year);
        System.out.println("Day of the Year is: " + dayOfYear);
        System.out.println("Weekday is the: " + weekdayName);
    }

}
