import java.util.Random;

public class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Random rand = new Random();
        int[] numbers = new int[10];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1,10);
            System.out.print(numbers[i] + " ");
        }

        System.out.println("");

        for(int i = 0; i < (numbers.length); i++) {
            int index = i;
            for(int j = index; j < numbers.length; j++){
                if(numbers[j] < numbers[index]) {
                    index = j;
                    System.out.print(numbers[index]);
                }
            }
            int swapper = numbers[i];
            numbers[i] = numbers[index];
            numbers[index] = swapper;
        }

        System.out.println("");
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");

    }
}