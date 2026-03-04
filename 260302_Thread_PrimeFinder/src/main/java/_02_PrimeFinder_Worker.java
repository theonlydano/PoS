import java.util.List;

public class _02_PrimeFinder_Worker implements Runnable {

    private Long lowerlimit;
    private Long upperlimit;
    public Long duration;
    private List<Long> primes;

    public _02_PrimeFinder_Worker(Long lowerlimit, Long upperlimit, List<Long> primes) {
        this.lowerlimit = lowerlimit;
        this.upperlimit = upperlimit;

        this.duration = 0L;
        this.primes = primes;
    }

    public boolean isPrime(Long number) {

        /*
        if(number % 2 == 0){
            return false;
        }

        for(int i = 3; i <= Math.sqrt(number); i+=2) {
            if (number % i == 0) {
                return false;
            }
        }
         */

        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;

        int limit = (int) Math.sqrt(number);
        for (int i = 5; i <= limit; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void run() {
        duration = System.currentTimeMillis();

        for (Long i = this.lowerlimit; i <= upperlimit; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        duration = System.currentTimeMillis() - duration;
    }
}
