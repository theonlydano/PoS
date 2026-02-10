import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Obere Grenze: ");
        int upperLimit = sc.nextInt();
        Fibonacci fibonacci = new Fibonacci(upperLimit);
        fibonacci.computeSum();
        System.out.println(fibonacci.toString());
    }
}