class DrawableObject {
    private Vector position;
    private Vector speed;

    public DrawableObject() {
        this.position = new Vector(width/2, height/2);
        this.speed = new Vector();
    }
    
    public void setSpeed(Vector speed){
      this.speed = speed; 
    }
    
    public Vector getLocation(){
      return position; 
    }

    // Kein Übergabeparameter
    public void update() {
        position.add(speed);
        
        if(position.x <= 0 || position.x >= width){
          speed.x *= -1; 
        }
        if(position.y <= 0 || position.y >= height){
          speed.y *= -1; 
        }
    }
    
}
