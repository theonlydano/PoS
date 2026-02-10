import java.util.Scanner;

public class HangmanGame {
    private String letters = "";
    private String word = "Rememberance";
    private Scanner sc = new Scanner(System.in);
    private char userInput;
    private boolean bool = true;
    private char[] guess = new char[word.length()];
    private int counter = 10;

    public void play(){
        compute();
        display();
        end();
    }

    private void compute(){
        System.out.println("-- WILLKOMMEN BEIM HANGMAN --");
        word = word.toLowerCase();
        for(int i = 0; i < word.length(); i++) {
            guess[i] = '_';
        }
    }
    private void display(){
        do{
            counter--;
            System.out.println("Versuche übrig: " + counter);
            if(counter == 0){
                System.out.println("Keine Versuche mehr");
                break;
            }

            System.out.print("Wort:");
            for(int i = 0; i < word.length(); i++) {
                if(i < word.length()) {
                    System.out.print(" ");
                }
                System.out.print(guess[i]);
            }
            System.out.println();

            do {
                System.out.println("Bitte geben Sie einen Buchstaben ein:");
                userInput = sc.next().toLowerCase().charAt(0);
            }while(letters.contains("" + userInput));
            letters += userInput;
            for (int i = 0; i < word.length(); i++) {
                if(guess[i] == userInput) {
                    counter--;
                }
                if (word.charAt(i) == userInput) {
                    guess[i] = userInput;
                }
            }
            String fullWord = "";
            for (int i = 0; i < word.length(); i++) {
                fullWord = fullWord + guess[i];
                if (fullWord.equals(word)) {
                    bool = false;
                }
            }
            //}while(letters.contains(userInput));
            /*counter--;
            System.out.println("Versuche übrig: " + counter);
            if(counter == 0){
                System.out.println("Keine Versuche mehr");
                break;
            }
            */
            System.out.println();
        }while(bool == true);
    }
    private void end(){
        if(counter >= 1){
            System.out.println("Congrats");
        }
        System.out.print("Das wort lautet: " + word);
        System.out.println();
    }
}
