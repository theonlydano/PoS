import java.util.Random;

public class Password {
    private Random rand = new Random();

    private String password;
    private int length;
    private boolean numbers;
    private boolean lowercase;
    private boolean uppercase;
    private boolean symbols;
    private String possiblechars;

    public Password() {
        numbers = false;
        lowercase = false;
        uppercase = false;
        symbols = false;

    }
    public void possiblecharsPassword(){
        StringBuilder sb = new StringBuilder();

        if(numbers){
            sb.append("123456789");
        }
        if(lowercase){
            sb.append("abcdefghijklmnopqrstuvwxyz");
        }
        if(uppercase){
            sb.append("abcdefghijklmnopqrstuvwxyz".toUpperCase());
        }
        if(symbols){
            sb.append("!§$%&/()=?`");
        }

        possiblechars = sb.toString();
    }

    public String password(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < length; i++){
            sb.append(possiblechars.charAt(rand.nextInt(0, possiblechars.length())));
        }

        return sb.toString();
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isNumbers() {
        return numbers;
    }

    public void setNumbers(boolean numbers) {
        this.numbers = numbers;
    }

    public boolean isLowercase() {
        return lowercase;
    }

    public void setLowercase(boolean lowercase) {
        this.lowercase = lowercase;
    }

    public boolean isSymbols() {
        return symbols;
    }

    public void setSymbols(boolean symbols) {
        this.symbols = symbols;
    }

    public boolean isUppercase() {
        return uppercase;
    }

    public void setUppercase(boolean uppercase) {
        this.uppercase = uppercase;
    }
}
