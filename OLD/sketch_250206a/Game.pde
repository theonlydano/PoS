class Game {
    private Box box;
    private Ellipse ellipse;

    public void init() {
        box = new Box(20);
        box.setSpeed(new Vector(-0.3f, -0.5f));
        ellipse = new Ellipse(20);
        ellipse.setSpeed(new Vector(0.3f, 0.5f));
    }
    
    public void update() {
        background(255, 255, 255);
      
        box.update(); // call into DrawableObject
        ellipse.update();
        
        box.paint(); // call into Box into box object
        ellipse.paint();  
    }
}

/*
250207: Als EntwichlerIn habe ich neben einem Rechteck auch einen Kreis mit der selber Funktion, wie dem vom Rechteck.

*/
