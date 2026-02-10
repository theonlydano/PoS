import java.util.Scanner;
public class Primefactors {
    private int number = 0;
    private int[] primefactors;

    public  void setNumber(int number){
        this.number = number;
    }
    public void compute(){
        int temp = 0;
        int counter = 0;
        int numberequal = number;
        for(int i = 2; i <= number; i++){
            while(numberequal % i == 0){
                numberequal = numberequal / i;
                counter++;
            }
        }
        primefactors = new int[counter];
        for(int i = 2; i <= number; i++){
            if(number % i == 0){
                number = number / i;
                primefactors[temp] = i;
                temp++;
            }
        }
    }
    public String toString(){
        String result = "";
        for(int i = 0; i < primefactors.length; i++){
            result += primefactors[i];
            if(i != primefactors.length - 1){
                result += ", ";
            }
        }
        return "Primfaktoren: " + result;
    }
}
