public class Square extends GenericObject{

    public Square(int x, int y) {
        this.location = new Vector(x, y);
        this.acceleration = new Vector(1,0);
    }

    @Override
    public void update(int width, int height) {
        this.location.add(acceleration.getX(), acceleration.getY());

        if (location.getX() < 0 || location.getX() > width){
            this.acceleration.multiply(-1, 1);
        }

        if (location.getY() < 0 || location.getY() > height){
            this.acceleration.multiply(1, -1);
        }
    }

    @Override
    public void draw(int width, int height) {
        for (int x = 0; x < width; x++){
            if(x == location.getX()){
                System.out.print(" X ");
            }else{
                System.out.print(" - ");
            }
        }
    }
}
