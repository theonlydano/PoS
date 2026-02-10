public class Hangman {
    System.out.println("-- WILLKOMMEN BEIM HANGMAN --");
    String word = "Monkeyking";
    word = word.toLowerCase();
    Scanner sc = new Scanner(System.in);
    char userInput;
    boolean bool = true;
    char[] guess = new char[word.length()];
    int counter = 10;

    public void compute(){
        for(int i = 0; i < word.length(); i++) {
            guess[i] = '_';
        }
    }
    public void display(){
        do{

            System.out.print("Wort:");
            for(int i = 0; i < word.length(); i++) {
                if(i < word.length()) {
                    System.out.print(" ");
                }
                System.out.print(guess[i]);
            }
            System.out.println();

            //do {
            System.out.println("Bitte geben Sie einen Buchstaben ein:");
            userInput = sc.next().toLowerCase().charAt(0);
            //letters += userInput;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == userInput) {
                    guess[i] = userInput;
                    counter++;
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
            counter--;
            System.out.println("Versuche übrig: " + counter);
            if(counter == 0){
                System.out.println("Keine Versuche mehr");
                break;
            }
            System.out.println();
        }while(bool == true);
    }
    public void end(){
        if(counter >= 1){
            System.out.println("Congrats");
        }
        System.out.print("Das wort lautet: " + word);
        System.out.println();
    }
}
