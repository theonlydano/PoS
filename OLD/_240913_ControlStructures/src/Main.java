import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("### Controllstructure ###");
        int value = 16;

        if(value < 10){
            System.out.println("Is smaller");
        }else{
            System.out.println("is greater");
        }

        // #### IF

        boolean isRunning = false;
        if(isRunning == false){
            System.out.println("is not running");
        }
        if(!isRunning) { // Negation
            System.out.println("is not running");
        }

        // #### NESTED IF
        int otherValue = 12;
        if(otherValue > 10){
            if(otherValue < 15){
                System.out.println("number is between 10 and 15");
            }else{
                System.out.println("number is bigger than 15");
            }
        }

        // IF-ELSE-LADDER

        if(otherValue < 10){
            System.out.println("smaller 10");
        }else if (otherValue < 20){
            System.out.println("smaller 20");
        }else if (otherValue < 30){
            System.out.println("smaller 30");
        }else{
            System.out.println("ERROR");
        }

        int switcher = 3;
        switch(switcher){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("This should be never be seen!");
                break;
        }

        char cswitcher = 'c';
        switch(cswitcher){
            case 'C':
            case 'c':
                System.out.println("C");
                break;

            default:
                System.out.println("ERROR");
                break;
        }

        String teacher = "SC";
        switch(teacher){
            case "LB":
                System.out.println("Loibner");
                break;

            case "SC":
                System.out.println("Schreiber");
                break;

            case "RI":
                System.out.println("Riesel");
                break;

            default:
                System.out.println("ERROR");
                break;
        }

        // LOOPS
        System.out.println("##### LOOPS #####");

        int counter = 0;
        isRunning = true;
        while(isRunning){
            counter++;
            if(counter > 10_000){
                isRunning = false;
            }
        }
        System.out.println("1. Loop ended");

        // your turn: rewrite the while loop into a for loop

        for(int y = 0; y < 10_000; y++){
            //System.out.println("counter: " + y);
            System.out.println("do something");
        }
        System.out.println("2. Loop ended");

        do{
            System.out.println("Running in a do-while");
        }while(isRunning);

        System.out.println("#### ARRAY ####");
        String[] names = {"Albert", "Nils", "Max", "Werner"};
        System.out.println("Name of Einstein: " + names[0]);

        for(int i = 0; i < names.length; i++){
            System.out.println("Name: " + names[i]);
        }

        // your turn: Create an array with 7 int values.
        // print them in one line, comma seperated.
        // 1, 3, 6, 3, 2, 4, 6

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i]);
            if(i < numbers.length - 1){
                System.out.print(",");
            }
        }

        System.out.println("#### RANDOM NUMBER ####");
        int lowerBound = 3;
        int upperBound = 12;

        Random random = new Random();

        int theRandomNumber = random.nextInt();
        for(int i = 0; i < 100; i++) {
            System.out.println(theRandomNumber);
        }

        System.out.println("------------------------");
        for(int i = 0; i < 100; i++) {
            int theNewRandomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println(theNewRandomNumber);
        }

        System.out.println("-------RANDOM FLOATS------");
        float lowerLimit = 5.2f;
        float upperLimit = 19.3f;

        for(int i = 0; i < 100; i++){
            float theFloatRandom = random.nextFloat(upperLimit - lowerLimit + 1) + lowerLimit;
            System.out.println(theFloatRandom);
        }

        // your turn:
        // hint: int[] numbers = new int[100]
        // generate 100 random numbers between 1 ... 6 into an array
        // Analyse the array about frequency, ...
        // Proof the Prof


    }
}