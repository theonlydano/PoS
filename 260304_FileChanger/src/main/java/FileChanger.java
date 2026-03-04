import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileChanger implements Runnable {

    File demo;
    long lastModified;

    public FileChanger(File demo) {
        this.demo = demo;
        lastModified = demo.lastModified();
    }

    /*
    your turn:
    Write a program, which monitors the status of a file.
    If the file is modified, print out some kind of message.
    The file is located in resources and named demo.txt

    Files.getLastModifiedTime
     */

    public static void main(String[] args) {
        Path path = Path.of("src/main/resources/demo.txt");
        File file = path.toFile();
        FileChanger fc = new FileChanger(file);
        Thread thread = new Thread(fc);

        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            if (demo.lastModified() > lastModified) {
                System.out.println("File " + demo.getName() + " has been changed...");
                lastModified = demo.lastModified();
            }
        }
    }
}
