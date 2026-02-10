import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        Password p = new Password();
        p.setLength(10);
        p.setLowercase(true);
        p.setUppercase(false);
        p.setNumbers(true);
        p.possiblecharsPassword();

        String password = p.password();
        System.out.println(password);
    }
}

