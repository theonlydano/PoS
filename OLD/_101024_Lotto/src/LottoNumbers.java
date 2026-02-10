import java.util.Random;

public class LottoNumbers {
    private int[] numbers = new int[6];
    private int additionalNumber = 0;
    Random rand = new Random();
    private String stringOfNumbers = "";

    public void randomNumbers(){
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = rand.nextInt(45) + 1;
        }
        additionalNumber = rand.nextInt(45) + 1;
    }
    public void sortNumbers(){
        for(int i = 0; i < numbers.length; i++){
            if (numbers[i] > numbers[i+1]){
                int swap = numbers[i];
                numbers[i] = numbers[i+1];
                numbers[i+1] = swap;
            }
        }
    }
    public void outputNumbers(){
        System.out.println("Lottozahlen: ");
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i]);
            if(i != numbers.length - 1){
                System.out.print(",");
            }
        }
        System.out.println(" Zusatzzahlen: " + additionalNumber);
    }
    /*public String toString(){
        for(int i = 0; i < numbers.length; i++){
            stringOfNumbers += numbers[i] + ",";
        }
        return stringOfNumbers;
    }*/
}
