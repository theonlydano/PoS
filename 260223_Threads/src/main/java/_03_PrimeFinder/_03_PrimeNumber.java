package _03_PrimeFinder;

public class _03_PrimeNumber {
    public static void main(String[] args) {
        int upperNumber = 2_000_000_000;
        int parts = upperNumber / 4;

        Runnable runnable1 = new Prime(2, parts); // 2, 500_000_000
        Runnable runnable2 = new Prime(parts + 1, parts * 2); // 500_000_001, 250_000_000
        Runnable runnable3 = new Prime(parts * 2 + 1, parts * 3); // ...
        Runnable runnable4 = new Prime(parts * 3 + 1, upperNumber); // ...

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);
        Thread thread4 = new Thread(runnable4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    static class Prime implements Runnable {
        private int start;
        private int end;

        public Prime(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for(int i = start; i <= end; i++){
                if(isPrimeNumber(i)){
                    System.out.println("Thread at " + i);
                }
            }
        }

        private boolean isPrimeNumber(int number) {
            if(number < 2){
                return false;
            }

            for(int i = 2; i * i <= number; i++){
                if(number % i == 0){
                    return false;
                }
            }

            return true;
        }
    }

}