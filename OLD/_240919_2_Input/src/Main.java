import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        /*
        System.out.println("Please Insert a Name");

        String name = scanner.nextLine();
        System.out.print("Your Name is: ");
        System.out.println(name);

        // get an int from scanner
        System.out.println("Please Insert a number");
        int userInput = scanner.nextInt();
        System.out.println("Given Number: " + userInput);

        // your turn:
        /*
        Please write an application, where the user
        can input two numbers. Find all prime numbers
        between them.
         */
        int lowerBound = 0;
        int upperBound = 0;
        do {
            System.out.println("insert lowerBound:");
            lowerBound = scanner.nextInt();
            System.out.println("insert upperBound: ");
            upperBound = scanner.nextInt();
        }while(lowerBound > upperBound);

        int primeCounter = 0;

        for(int i = lowerBound; i <= upperBound; i++){
            boolean isPrime = true;
            for(int y = 3; y < Math.sqrt(i); y+=2){
                /*if(i == y){
                    primeCounter++;
                }
                 */
                if(i % y == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primeCounter++;
            }
        }
        System.out.println("There are " + primeCounter + " prime numbers");
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");
    }
}