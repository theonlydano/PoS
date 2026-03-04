import java.util.ArrayList;
import java.util.List;

public class _02_PrimeFinder_App {
    public static void main(String[] args) {

        Long duration = System.currentTimeMillis();

        List<Long> primes = new ArrayList<Long>();

        Long start = 3L;
        Long end = 20_000_000L;

        Long div = end / 4;

        _02_PrimeFinder_Worker r1 = new _02_PrimeFinder_Worker(start, div, primes);
        _02_PrimeFinder_Worker r2 = new _02_PrimeFinder_Worker(start + div, div * 2, primes);
        _02_PrimeFinder_Worker r3 = new _02_PrimeFinder_Worker(start + div * 2, div * 3, primes);
        _02_PrimeFinder_Worker r4 = new _02_PrimeFinder_Worker(start + div * 3, div * 4, primes);;

        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        Thread thread3 = new Thread(r3);
        Thread thread4 = new Thread(r4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try{
            thread1.join(); // warte auf Threads
            thread2.join();
            thread3.join();
            thread4.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        // for(Long prime : primes)
        //    System.out.println(prime);

        System.out.println("Duration: " + r1.duration);
        System.out.println("Duration: " + r2.duration
                + "\nDuration: " + r3.duration
                + "\nDuration: " + r4.duration);

        duration = System.currentTimeMillis() - duration;
        System.out.println("Sys-Duration: " + duration);

        System.out.println("Bye.. bye...");
    }
}
