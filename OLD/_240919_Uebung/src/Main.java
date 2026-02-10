import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // your turn:
        // hint: int[] numbers = new int[100]
        // generate 100 random numbers between 1 ... 6 into an array
        // Analyse the array about frequency, ...
        // Proof the Prof
        long start = System.currentTimeMillis();
        int lowerLimit = 1;
        int upperLimit = 6;
        int[] counters = new int[upperLimit + 1];

        Random random = new Random();
        int[] numbers = new int[100];

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = random.nextInt(lowerLimit, upperLimit+1);
        }
        for(int y = 0; y < upperLimit; y++){
            for(int x = 0; x < numbers.length; x++){
                if(y+1 == numbers[x]){
                    counters[y]++;
                }
            }
        }
        for(int i = 0; i < upperLimit; i++){
            System.out.println("Number of Points " + (i+1) + ": " + counters[i]);
        }

        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("Time: " + duration);

        System.out.println("#### Uebung ####");

    }
}