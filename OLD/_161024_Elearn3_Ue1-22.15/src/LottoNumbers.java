import java.util.Random;

public class LottoNumbers {
    private int[] numbers = new int[6];
    private int additionalNumber = 0;
    Random rand = new Random();

    public LottoNumbers(){
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length; j++){
                numbers[i] += rand.nextInt(45);
                if(i == numbers.length - 1){
                    additionalNumber += rand.nextInt(45);
                }
            }
        }
    }
    public void sortNumbers(){
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length; j++){
                if(numbers[i] > numbers[j]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }
    public String toString(){
        String output = "";
        for(int i = 0; i < numbers.length; i++){
            output += numbers[i];
            if(i != numbers.length - 1){
                output += ",";
            }
        }
        return "Lottozahlen:" + output + " Zusatzzahlen: " + additionalNumber;
    }
}
