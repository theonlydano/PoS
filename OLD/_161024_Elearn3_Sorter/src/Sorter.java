import java.util.Scanner;

public class Sorter {
    private int[] numbers;
    private String numbersToString;
    private int input;
    Scanner sc = new Scanner(System.in);

    public Sorter(int sizeOfField) {
        this.numbers = new int[sizeOfField];
        for(int i = 0; i < sizeOfField; i++){
            numbersToString += numbers[i];
            if(i != sizeOfField - 1){
                numbersToString += ", ";
            }
        }
        System.out.println("(1) Selection-Sort");
        System.out.println("(2) Insertion-Sort");
        System.out.println("(3) Bubble-Sort");
        System.out.print("Wählen Sie aus:");
        do{
            input = sc.nextInt();
        }while(input < 1 || input > 3);
        switch(input){
            case 1:
                selectionSort();
                break;
            case 2:
                insertionSort();
                break;
            case 3:
                bubbleSort();
                break;
            default:
                System.out.println("Was passiert hier?!?!?!");
                break;
        }
    }
    public void selectionSort() {
        for (int i = 0; i < numbers.length; i++) {
            int index = 0;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] < numbers[index]) {
                    index = j;
                }
            }
            int tmp = numbers[i];
            numbers[i] = numbers[index];
            numbers[index] = tmp;
        }
    }
    public void insertionSort() {
        for (int i = 1; i < numbers.length; i++) {
            int index = i;
            int num = numbers[index];
            for (int j = i - 1; j >= 0; j--) {
                if (num >= numbers[j]) {
                    break;
                }
                numbers[j + 1] = numbers[j];
                index = j;
            }
            numbers[index] = num;
        }
    }
    public void bubbleSort() {
        boolean sorted;
        do {
            sorted = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    sorted = true;

                    int tmp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = tmp;
                }
            }
        } while (sorted);
    }
    public String toString(){
        return numbersToString;
    }
}
