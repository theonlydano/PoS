import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileChanger {

    /*
    your turn:
    Write a program, which monitors the status of a file.
    If the file is modified, print out some kind of message.
    The file is located in resources and named demo.txt

    Files.getLastModifiedTime
     */

    public static void main(String[] args) {
        String filename = "demo.txt";
        Path path = Path.of(System.getProperty("user.dir"),"src/main/resources/", filename);
        File file = path.toFile();
        OwnRunnable or = new OwnRunnable(file);
        Thread thread = new Thread(or);

        thread.start();
    }

    public static class OwnRunnable implements Runnable {
        File demo;
        long lastModified;

        public OwnRunnable(File demo) {
            this.demo = demo;
            lastModified = demo.lastModified();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    if (demo.lastModified() > lastModified) {
                        System.out.println("File " + demo.getName() + " has been changed...");
                        lastModified = demo.lastModified();
                        Thread.sleep(1000);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
