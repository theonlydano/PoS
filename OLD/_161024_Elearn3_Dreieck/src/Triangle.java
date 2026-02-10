public class Triangle {
    private int sideA = 0;
    private int sideB = 0;
    private int sideC = 0;
    private String typeOfTriangle = "0";
    public Triangle(int sideA, int sideB, int sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    public void sortSides(){
        for(int i = 0; i < 3; i++) {
            if (sideA > sideB) {
                int temp = sideA;
                sideA = sideB;
                sideB = temp;
            } else if (sideB > sideC) {
                int temp = sideB;
                sideB = sideC;
                sideC = temp;
            }
        }
    }
    public void determineType(){
        if(Math.sqrt(sideA * sideA + sideB * sideB) == sideC){
            typeOfTriangle = "rechtwinkelig";
        }else{
            typeOfTriangle = "kein Dreieck";
        }
    }
    public String toString(){
        return "Dreieck " + "(" + sideA + "," + sideB + "," + sideC + ") -> " + typeOfTriangle;
    }
}
