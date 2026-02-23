package _02_FirstThread;

public class _02_01_Process {
    public static void main(String[] args) {
        // this is my process
        System.out.println("This Process");

        // what we need are:
        // * thread
        // * job

        // JOB
        Runnable runnable1 = new _02_01_Job("Job1");
        Runnable runnable2 = new _02_01_Job("Job2");

        // THREAD
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        // LETS GO AND START
        thread1.start(); // non blocking
        thread2.start();

        // some other methods to combine
        Thread thread3 = new Thread(new Thread(
                () -> {
                    // JOB
                    for(int i = 0; i < 1_000_000; i++){
                        System.out.println("DatumsJob: " + new java.util.Date());
                    }
                })
        );
        thread3.start();

        // anonym
        new Thread(() -> {
            for(;;){
                System.out.println("Hello from the other side...");
            }
        }).start();
    }
}
