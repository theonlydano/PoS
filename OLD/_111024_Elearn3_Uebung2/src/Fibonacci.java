public class Fibonacci {
     private int maxNumber;
     private int[] fibonacci;
     private int sum = 0;

     public Fibonacci(int upperlimit) {
          maxNumber = upperlimit;
          fibonacci = new int[maxNumber];
          fibonacci[0] = 1;
          fibonacci[1] = 1;
          for(int i = 2; i < maxNumber; i++){
               fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
          }
     }

     public void computeSum(){
          for(int i = 0; i < maxNumber; i++){
               sum = sum + fibonacci[i];
          }
     }
     public String toString(){
          return "Fibonacci-Summe bis " + maxNumber + ": " + sum;
     }
}
