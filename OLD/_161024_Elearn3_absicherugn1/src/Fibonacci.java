import java.util.Random;
import java.util.Arrays;

public class Fibonacci {
    private int[] numbers = new int[6];
    private int additionalNumber = 0;
    private String numbersString;
    Random rand = new Random();

    public void randomNumbers(){
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = rand.nextInt(46);
        }
        additionalNumber = rand.nextInt(46);
    }
    public void sortNumbers(){
        boolean bool;
        do {
            bool = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    bool = true;

                    int swap = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = swap;
                }
            }
        } while (bool == true);
    }
    public void outputNumbers(){
        /*System.out.println("Lottozahlen: ");
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i]);
            if(i != numbers.length - 1){
                System.out.print(",");
            }
        }
        System.out.println(" Zusatzzahlen: " + additionalNumber);
        */
        for(int i = 0; i < numbers.length; i++){
            numbersString += numbers[i];
            if(i != numbers.length -1){
                numbersString += ",";
            }
        }
    }
    public String toString() {
        //outputNumbers();
        //return "Lottozahlen: " + numbersString + " Zusatzzahlen: " + additionalNumber;
        return "Lottozahlen: " + Arrays.toString(numbers).replaceAll("\\[","").replaceAll("]","") +" Zusatzzahlen: " + this.additionalNumber;
    }
}
