import java.util.Scanner;

public class _01_StringApiBasics {
    public static void main(String[] args) {
        // Erzeugen eines String Objekts
        // 1.Variante - erzeugen eines Objekts
        // <Datentyp> variablenName = new <DatenTyp>(...)
        String str = new String("Hello World");
        System.out.println(str);

        // 2. Variante
        String strFromPool = "Hello Pool";
        System.out.println(strFromPool);

        // ACHTUNG: Strings sind immutable
        // 1Var vs 2Var
        // 1. Var legt explizit iein Objekt am RAM an
        // 2. Var: Schaut in StringPool (Speicherbereich)
        // nach ob es eubeb String mit ddem selben Inhalt
        // gibt.

        String strObject = new String(strFromPool);
        System.out.println(strObject);

        // Mit String kann man auch rechnen
        String strAdd = strObject + " this is working";
        System.out.println(strAdd);

        String prefixStr = new String("this is a " + strObject);
        System.out.println(prefixStr);

        // String Operations
        int length = prefixStr.length();
        System.out.println("length: " + length);
        System.out.println(prefixStr.charAt(0));

        // your turn: print each char per line
        for(int i = 0; i < prefixStr.length(); i++){
            System.out.println(prefixStr.charAt(i));
        }

        // your turn: as user I can insert a text and the
        // software calculates the length of inserted text.

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a Text");
        String userInput = sc.nextLine();
        int lengthOfUserInput = userInput.length();
        System.out.println("length of UserInput: " + lengthOfUserInput);

        // Teilen von String
        String subStr = prefixStr.substring(0, 5);
        System.out.println("subStr: " + subStr);

        // your turn: ist der Oben eingebene text länger als 20
        // zeichen so ist dieser zu teilen. Z.B. für Lorem Ipsum
        // Lorem Ipsum ... rem Ipsum
        // Ersten 10 Zeichen gefolgt von drei Punkten und die letzten
        // 10 Zeichen

        String loremIpsum = sc.nextLine();
        if(loremIpsum.length() > 19){
            String firstSubLoremIpsum = loremIpsum.substring(0, 10);
            String secondSubLoremIpsum = loremIpsum.substring(loremIpsum.length() - 10, loremIpsum.length());
            System.out.println(firstSubLoremIpsum + " ... " + secondSubLoremIpsum);
        }

        // vergleich von Strings
        String str1 = new String("hello");
        String str2 = new String("hello");
        boolean areEqual = (str1 == str2); // gleicher Speicher
        boolean isEqual = str1.equals(str2); // gleicher Wert
        System.out.println("Are Equal: " + areEqual);
        System.out.println("Is Equal: " + isEqual);

        System.out.println(prefixStr.toUpperCase());
        System.out.println(prefixStr.toLowerCase());
        System.out.println(prefixStr.replace('o', '0'));

        System.out.println("Contains: " + prefixStr.contains("ell"));
        System.out.println("Contains: " + prefixStr.contains("1"));

        System.out.println("Index Of: " + prefixStr.indexOf("ell"));

        System.out.println("Is Empty: " + prefixStr.isEmpty());
        prefixStr = "";
        System.out.println("Is Empty: " + prefixStr.isEmpty());
        System.out.println();


    }
}
