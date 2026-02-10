import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("#### Uebung ####");

        int[] numbers = new int[1];

        for(int i = 0; i < numbers.length; i++){

            System.out.print(numbers[i]);

            if(i < (numbers.length-1)){
                System.out.print(",");
            }
        }

        Random random = new Random();

        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.println("How many numbers would you like to save?");
        int readInput = input.nextInt();
        numbers = new int[readInput];
        System.out.println("Enter Lower Bound");
        int lowerBound = input.nextInt();
        System.out.println("Enter Upper Bound");
        int upperBound = input.nextInt();

        for(int i = 0; i < readInput; i++){
            numbers[i] = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        }
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i]);
            if(i < (numbers.length-1)){
                System.out.print(",");
            }
        }
    }
}