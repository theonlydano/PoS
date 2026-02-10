public class Main {
    public static void main(String[] args) {
        System.out.println("### Variables ###");

        // Declaration
        int ageOfDog;
        ageOfDog = 0; // Initialisation

        // Ganzzahlen
        int iValue = 4; //  32 bit = 4 Bytes = 2^32
        char cValue = 'c'; // 16 bit = 2 Byte = 2^16
        short sValue = 322; // 16 bit
        long lValue = 3422; // 64 bit = 8 byte = 2^64

        byte bValue = 12; // 8 bit = 1 byte = 2^8 = 256
        boolean boolValue = true; // or false //

        // Kommazahlen
        float fValue = 12.6f; // 32 bit
        double dValue = 123.9; // 64 bit

        System.out.println("Inhalt " + iValue);
        System.out.println("Char " + cValue);
        System.out.println("Short: " + sValue);
        System.out.println("Long: " + lValue);
        System.out.println("Byte: " + bValue);
        System.out.println("Boolean: " + boolValue);
        System.out.println("Float: " + fValue);
        System.out.println("Double: " + dValue);

        String name = "Noah Daniel Pichler"; // Stringpool
        String otherName = "Noah Daniel Pichler"; //
        String empty = "";
    }
}