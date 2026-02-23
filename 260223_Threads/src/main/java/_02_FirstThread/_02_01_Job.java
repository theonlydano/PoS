package _02_FirstThread;

public class _02_01_Job implements Runnable {
    private String name;

    public _02_01_Job(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int counter = 1;
        for(;;){
            System.out.print(name + " " + counter++);
        }
    }
}
