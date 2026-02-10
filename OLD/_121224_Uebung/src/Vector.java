public class Vector {
    private int x;
    private int y;

    //Constructor
    public Vector(int x, int y){
        this.x = x;
        this.y = y;
    }

    //Methoden
    @Override
    public String toString(){
        /*
        StringBuilder sb = new StringBuilder();

        sb.append(x + ", ");
        sb.append(y);

        return sb.toString();
        */
        return String.format("%d, %d", this.x, this.y);
    }

    //Getter
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public static void main(String[] args){
        Vector v1 = new Vector(10, 20);
        System.out.println(v1.toString());
    }
}
