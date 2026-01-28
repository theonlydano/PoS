package gui;

public class Cell {
    private String state = " ";
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE  = "\u001B[34m";
    public static final String RED   = "\u001B[31m";
    public static final String YELLOW= "\u001B[33m";
    public String Color = RESET;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        switch (state){
            case "X":
                Color = RED;
                break;
            case "S":
            case "G":
                Color = GREEN;
                break;
            default:
                Color = RESET;
                break;
        }
    }

    @Override
    public String toString() {
        return Color + state;
    }

}
