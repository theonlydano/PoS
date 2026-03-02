import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _01_PrimeFinder_Process {
    public static void main(String[] args) {
        int start = 2;
        long end = 2_000_000;

        long startTime = System.currentTimeMillis();

        List<Integer> primes = new ArrayList<>();
        primes.add(2);

        for (int i=start; i<=end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Total time: " + totalTime + "ms");

        System.out.println("5. Prime Number: " + primes.get(4));

    }

    public static boolean isPrime(int number) {

        if(number % 2 == 0){
            return false;
        }

        for(int i = 3; i <= Math.sqrt(number); i+=2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
